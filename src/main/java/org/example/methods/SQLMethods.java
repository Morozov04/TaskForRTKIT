package org.example.methods;

import org.example.dataBase.DBUtils;

import java.sql.*;

public class SQLMethods {
    private static final String CALCULATE_AVERAGE_GRADE_QUERY = "SELECT s.classNumber, AVG(a.assessment) AS averageResult FROM student s JOIN assessment a " +
            "ON s.id = a.idStudent WHERE s.classNumber = ? GROUP BY s.classNumber;";
    private static final String SEARCH_PERSON_BY_ASSESSMENT_QUERY = "SELECT * FROM student s WHERE s.age > ? AND s.age < ? AND NOT EXISTS (SELECT * FROM subject sub " +
            "WHERE NOT EXISTS (SELECT * FROM assessment a WHERE a.idStudent = s.id AND a.idSubject = sub.id AND a.assessment = ?));" ;
    private static final String SEARCH_PERSON_AVERAGE_GRADE_BY_SURNAME = "SELECT s.lastName, s.firstName, s.age, s.classNumber, AVG(a.assessment) AS averageResult " +
            "FROM student s JOIN assessment a ON s.id = a.idStudent WHERE s.lastName = ? GROUP BY s.lastName, s.firstName, s.age, s.classNumber;";

    public static void calculateAverageGrade(String group) {
        try {
            Connection connection = DBUtils.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(CALCULATE_AVERAGE_GRADE_QUERY);
            preparedStatement.setInt(1, Integer.parseInt(group));

            ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    System.out.print("Класс = " + resultSet.getInt("classNumber"));
                    System.out.print(" | Средняя оценка = " + resultSet.getDouble("averageResult") + ".\n");
                }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
    }

    public static void searchPersonByAssessment(String ageMin, String ageMax, String grade) {
        try {
            Connection connection = DBUtils.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PERSON_BY_ASSESSMENT_QUERY);
            preparedStatement.setInt(1, Integer.parseInt(ageMin));
            preparedStatement.setInt(2, Integer.parseInt(ageMax));
            preparedStatement.setInt(3, Integer.parseInt(grade));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.print("Фамилия = " + resultSet.getString("lastName"));
                System.out.print(" | Имя = " + resultSet.getString("firstName"));
                System.out.print(" | Возраст = " + resultSet.getInt("age"));
                System.out.print(" | Класс = " + resultSet.getInt("classNumber") + ".\n");
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
    }

    public static void searchPersonAverageGradeBySurname(String name) {
        try {
            Connection connection = DBUtils.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PERSON_AVERAGE_GRADE_BY_SURNAME);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.print("Фамилия = " + resultSet.getString("lastName"));
                System.out.print(" | Имя = " + resultSet.getString("firstName"));
                System.out.print(" | Возраст = " + resultSet.getInt("age"));
                System.out.print(" | Класс = " + resultSet.getInt("classNumber"));
                System.out.print(" | Средняя оценка = " + resultSet.getDouble("averageResult") + ".\n");
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
    }
}
