package org.example.servlets;

import org.example.dataBase.CRUDUtils;
import org.example.dataBase.DBUtils;
import org.example.person.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/persons/grades"})
public class UpdateGradeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idPerson = req.getParameter("personId");
                if (idPerson != null) {
                    DBUtils.createConnection();
                    Person person = CRUDUtils.getPerson(idPerson);

                    String[] subjects = {"physics", "math", "rus", "literature", "geometry", "informatics"};

                    for (String subject : subjects) {
                        String gradeParameter = req.getParameter(subject);
                        if (gradeParameter != null ) {
                            if (!gradeParameter.matches("[1-5]")) throw new NumberFormatException();
                            int grade = Integer.parseInt(gradeParameter);
                            switch (subject) {
                                case "physics" -> person.getSubjectGrades().setPhysicsGrade(grade);
                                case "math" -> person.getSubjectGrades().setMathematicsGrade(grade);
                                case "rus" -> person.getSubjectGrades().setRusGrade(grade);
                                case "literature" -> person.getSubjectGrades().setLiteratureGrade(grade);
                                case "geometry" -> person.getSubjectGrades().setGeometryGrade(grade);
                                case "informatics" -> person.getSubjectGrades().setInformaticsGrade(grade);

                            }
                        }
                    }

                    CRUDUtils.updateGrades(person.getSubjectGrades(), idPerson);
                    resp.getWriter().println("Data updated.");
                }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
            resp.getWriter().println("Error: The grade entered must be a number.");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500 Internal Server Error
            resp.getWriter().println("Server error: " + e.getMessage());
        } finally {
               DBUtils.closeConnection();
        }
    }
}
