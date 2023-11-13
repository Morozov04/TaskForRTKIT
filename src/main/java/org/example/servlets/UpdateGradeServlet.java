package org.example.servlets;

import com.google.gson.Gson;
import org.example.dataBase.CRUDUtils;
import org.example.dataBase.PoolConnectionBuilder;
import org.example.person.Person;
import org.example.person.SubjectGrades;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Примеры запросов:
/*      {
        "id": "3",
        "subjectGrades": {
        "physicsGrade": 2,
        "mathematicsGrade": 5,
        "rusGrade": 3,
        "literatureGrade": 1,
        "geometryGrade": 2
        }
}*/
/*      {
        "id": "3",
        "subjectGrades": {
        "mathematicsGrade": 2,
        "rusGrade": 4,
        }
}*/

@WebServlet(urlPatterns = {"/persons/grades/*"})
public class UpdateGradeServlet extends HttpServlet {

    private CRUDUtils crudUtils;
    @Override
    public void init() throws ServletException {
        crudUtils = new CRUDUtils();
        crudUtils.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Gson gson = new Gson();
            Request requestData;

            try (var input = req.getInputStream()) {
                requestData = gson.fromJson(new String(input.readAllBytes()), Request.class);
            }

            if (!requestData.id().matches("\\d+")) throw new NumberFormatException();
            Person person = crudUtils.getPerson(requestData.id());

            SubjectGrades requestDataGrades = requestData.subjectGrades();
            SubjectGrades personGrades = person.getSubjectGrades();

            int[] grades = {
                    requestDataGrades.getPhysicsGrade(),
                    requestDataGrades.getMathematicsGrade(),
                    requestDataGrades.getRusGrade(),
                    requestDataGrades.getLiteratureGrade(),
                    requestDataGrades.getGeometryGrade(),
                    requestDataGrades.getInformaticsGrade()
            };

            for (int i = 0; i < grades.length; i++) {
                if (grades[i] < 1 & grades[i] > 6) throw new NumberFormatException();
                if (grades[i] != 0 ) {
                    switch (i) {
                        case 0 -> personGrades.setPhysicsGrade(grades[i]);
                        case 1 -> personGrades.setMathematicsGrade(grades[i]);
                        case 2 -> personGrades.setRusGrade(grades[i]);
                        case 3 -> personGrades.setLiteratureGrade(grades[i]);
                        case 4 -> personGrades.setGeometryGrade(grades[i]);
                        case 5 -> personGrades.setInformaticsGrade(grades[i]);
                    }
                }
            }

            String jsonRequest = gson.toJson(new Request(requestData.id(), personGrades));

            try (var output = resp.getWriter()) {
                resp.setContentType("application/json");
                output.write(jsonRequest);
                output.flush();
            }

            crudUtils.updateGrades(personGrades, requestData.id());

        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
            resp.getWriter().println("Error: The grade entered must be a number [1-5].");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500 Internal Server Error
            resp.getWriter().println("Server error: " + e.getMessage());
        }
    }
    record Request(String id, SubjectGrades subjectGrades) {}
}