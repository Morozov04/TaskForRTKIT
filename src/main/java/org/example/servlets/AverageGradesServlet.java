package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dataBase.DBUtils;
import org.example.methods.SQLMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = {"/persons/grades/avg/*"})
public class AverageGradesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var mapper = new ObjectMapper();
        try {
            DBUtils.createConnection();
            String group = req.getPathInfo().substring(1);
            if (!group.matches("[1-9]|1[0-2]")) throw new NumberFormatException();
            Map<String, Double> map = SQLMethods.calculateAverageGradeEachPerson(group);
            try (var output = resp.getWriter()) {
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("application/json");
                output.write(mapper.writeValueAsString(map));
                output.flush();
            }
        } catch (NumberFormatException e) {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
        resp.getWriter().println("Error: The entered class must be a number [1-12].");
        } catch (Exception e) {
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500 Internal Server Error
        resp.getWriter().println("Server error: " + e.getMessage());
        } finally {
        DBUtils.closeConnection();
        }
    }
}
