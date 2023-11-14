package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dataBase.conn.PoolConnectionBuilder;
import org.example.methods.SQLMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = {"/groups/*"})
public class AverageGradesServlet extends HttpServlet {

    private SQLMethods sqlMethods;
    @Override
    public void init() throws ServletException {
        sqlMethods = new SQLMethods();
        sqlMethods.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var mapper = new ObjectMapper();
        try {
            String pathInfo = req.getPathInfo();
            String[] pathParts = pathInfo.split("/");
            String group = pathParts[1];
            if ("students".equals(pathParts[2]) && "avg_marks".equals(pathParts[3])) {
                if (!group.matches("[1-9]|1[0-2]")) {throw new NumberFormatException();}
                Map<String, Double> map = sqlMethods.calculateAverageGradeEachPerson(group);
                try (var output = resp.getWriter()) {
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json");
                    output.write(mapper.writeValueAsString(map));
                    output.flush();
                }
            } else {throw new Exception();}
        } catch (NumberFormatException e) {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
        resp.getWriter().println("Error: The entered class must be a number [1-12].");
        } catch (Exception e) {
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500 Internal Server Error
        resp.getWriter().println("Server error: " + e.getMessage());
        }
    }
}
