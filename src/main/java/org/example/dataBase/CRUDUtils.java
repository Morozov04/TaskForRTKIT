package org.example.dataBase;

import org.example.person.Person;
import org.example.person.SubjectGrades;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CRUDUtils {
    public static Person getPerson(String id) {
        Person person = null;
        SubjectGrades grades;
        List<Integer> list = new LinkedList<>();
        try (Connection connection = DBUtils.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement assessment = connection.prepareStatement("SELECT assessment FROM assessment WHERE idStudent = ? ORDER BY idSubject ASC;");
                 PreparedStatement personInfo = connection.prepareStatement("SELECT * FROM student WHERE id = ?;")
            ) {
                assessment.setInt(1,Integer.parseInt(id));
                ResultSet resultSetA = assessment.executeQuery();
                while (resultSetA.next()){list.add(resultSetA.getInt("assessment")); }

                grades = new SubjectGrades(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));

                personInfo.setInt(1, Integer.parseInt(id));
                ResultSet resultSetP = personInfo.executeQuery();
                while (resultSetP.next()){person = new Person(
                        resultSetP.getString("lastName"),
                        resultSetP.getString("firstName"),
                        resultSetP.getInt("age"),
                        resultSetP.getInt("classNumber"), grades);}

                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                System.out.println("Отмена транзакции.");
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
        return person;
    }

    public static void addPerson(Person person) {
        try (Connection connection = DBUtils.getConnection()){
            connection.setAutoCommit(false);
            try (PreparedStatement personInfo = connection.prepareStatement(
                    "INSERT INTO student (lastName, firstName, age, classNumber) VALUES (?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS)
            ) {
                personInfo.setString(1, person.getFamily());
                personInfo.setString(2, person.getName());
                personInfo.setInt(3, person.getAge());
                personInfo.setInt(4, person.getGroup());
                personInfo.executeUpdate();

                ResultSet key = personInfo.getGeneratedKeys();
                while (key.next()) {
                    PreparedStatement assessment = connection.prepareStatement(
                            "INSERT INTO assessment(idStudent, idSubject, assessment) VALUES " +
                                    "(" + key.getInt("id") + ", 1, ?), (" + key.getInt("id") + ", 2, ?), " +
                                    "(" + key.getInt("id") + ", 3, ?), (" + key.getInt("id") + ", 4, ?), " +
                                    "(" + key.getInt("id") + ", 5, ?), (" + key.getInt("id") + ", 6, ?);");
                                        assessment.setInt(1, person.getSubjectGrades().getPhysicsGrade());
                                        assessment.setInt(2, person.getSubjectGrades().getMathematicsGrade());
                                        assessment.setInt(3, person.getSubjectGrades().getRusGrade());
                                        assessment.setInt(4, person.getSubjectGrades().getLiteratureGrade());
                                        assessment.setInt(5, person.getSubjectGrades().getGeometryGrade());
                                        assessment.setInt(6, person.getSubjectGrades().getInformaticsGrade());

                    assessment.executeUpdate();
                }
                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                System.out.println("Отмена транзакции.");
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
    }

    public static void deletePerson(String id) {
        try (Connection connection = DBUtils.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement assessment = connection.prepareStatement("DELETE FROM assessment WHERE idStudent = ?;");
                 PreparedStatement personInfo = connection.prepareStatement("DELETE FROM student WHERE id = ?;")
            ) {
                assessment.setInt(1, Integer.parseInt(id));
                assessment.executeUpdate();
                personInfo.setInt(1, Integer.parseInt(id));
                personInfo.executeUpdate();

                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                System.out.println("Отмена транзакции.");
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
    }

    public static void updateGrades(SubjectGrades grades, String id) {
        try (Connection connection = DBUtils.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement pPhysics = connection.prepareStatement("UPDATE assessment SET assessment = ? WHERE idStudent = ? AND idSubject = 1;");
                 PreparedStatement pMathematics = connection.prepareStatement("UPDATE assessment SET assessment = ? WHERE idStudent = ? AND idSubject = 2;");
                 PreparedStatement pRus = connection.prepareStatement("UPDATE assessment SET assessment = ? WHERE idStudent = ? AND idSubject = 3;");
                 PreparedStatement pLiterature = connection.prepareStatement("UPDATE assessment SET assessment = ? WHERE idStudent = ? AND idSubject = 4;");
                 PreparedStatement pGeometry = connection.prepareStatement("UPDATE assessment SET assessment = ? WHERE idStudent = ? AND idSubject = 5;");
                 PreparedStatement pInformatics = connection.prepareStatement("UPDATE assessment SET assessment = ? WHERE idStudent = ? AND idSubject = 6;")
            ) {

                pPhysics.setInt(1, grades.getPhysicsGrade());
                pPhysics.setInt(2, Integer.parseInt(id));
                pPhysics.executeUpdate();

                pMathematics.setInt(1, grades.getMathematicsGrade());
                pMathematics.setInt(2, Integer.parseInt(id));
                pMathematics.executeUpdate();

                pRus.setInt(1, grades.getRusGrade());
                pRus.setInt(2, Integer.parseInt(id));
                pRus.executeUpdate();

                pLiterature.setInt(1, grades.getLiteratureGrade());
                pLiterature.setInt(2, Integer.parseInt(id));
                pLiterature.executeUpdate();

                pGeometry.setInt(1, grades.getGeometryGrade());
                pGeometry.setInt(2, Integer.parseInt(id));
                pGeometry.executeUpdate();

                pInformatics.setInt(1, grades.getInformaticsGrade());
                pInformatics.setInt(2, Integer.parseInt(id));
                pInformatics.executeUpdate();

                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                System.out.println("Отмена транзакции.");
            }
        } catch (Exception e) {
            System.out.println("Значение введено некорректно.");
        }
    }
}