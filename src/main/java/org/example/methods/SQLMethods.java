package org.example.methods;

import org.example.dataBase.CRUDUtils;
import org.example.dataBase.DBUtils;
import org.example.dto.PersonDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLMethods {
    private static final String CALCULATE_AVERAGE_GRADE_QUERY = "SELECT s.classNumber, AVG(a.assessment) AS averageResult FROM student s JOIN assessment a " +
            "ON s.id = a.idStudent WHERE s.classNumber = ? GROUP BY s.classNumber;";
    private static final String SEARCH_PERSON_BY_ASSESSMENT_QUERY = "SELECT s.lastName, s.firstName, s.age, s.classNumber FROM student s WHERE s.age > ? AND s.age < ? AND NOT EXISTS (SELECT * FROM subject sub " +
            "WHERE NOT EXISTS (SELECT * FROM assessment a WHERE a.idStudent = s.id AND a.idSubject = sub.id AND a.assessment = ?));";
    private static final String SEARCH_PERSON_AVERAGE_GRADE_BY_SURNAME = "SELECT s.lastName, s.firstName, s.age, s.classNumber, AVG(a.assessment) AS averageResult " +
            "FROM student s JOIN assessment a ON s.id = a.idStudent WHERE s.lastName = ? GROUP BY s.lastName, s.firstName, s.age, s.classNumber;";
    public static Map<Integer, Double> calculateAverageGrade(String group) {
        Map<Integer, Double> map = new HashMap<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CALCULATE_AVERAGE_GRADE_QUERY)
        ) {
            preparedStatement.setInt(1, Integer.parseInt(group));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                map.put(resultSet.getInt("classNumber"), resultSet.getDouble("averageResult"));
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
        return map;
    }

    public static List<PersonDto> searchPersonByAssessment(String ageMin, String ageMax, String grade) {
        List<PersonDto> list = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PERSON_BY_ASSESSMENT_QUERY)
        ) {
            preparedStatement.setInt(1, Integer.parseInt(ageMin));
            preparedStatement.setInt(2, Integer.parseInt(ageMax));
            preparedStatement.setInt(3, Integer.parseInt(grade));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PersonDto personDto = new PersonDto(resultSet.getString("lastName"),
                                                    resultSet.getString("firstName"),
                                                    resultSet.getInt("age"),
                                                    resultSet.getInt("classNumber"));
                list.add(personDto);
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
        return list;
    }

    public static List<PersonDto> searchPersonAverageGradeBySurname(String name) {
        List<PersonDto> list = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PERSON_AVERAGE_GRADE_BY_SURNAME)
        ) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PersonDto personDto = new PersonDto(resultSet.getString("lastName"),
                        resultSet.getString("firstName"),
                        resultSet.getInt("classNumber"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("averageResult"));
                list.add(personDto);
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
        return list;
    }
}
