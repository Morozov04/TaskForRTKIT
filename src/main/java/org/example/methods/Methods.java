package org.example.methods;

import org.example.dataGroups.DataGroup;

public class Methods {
    public static void calculateAverageGrade(DataGroup<Integer> classroomDataGroups, int group) {

        double physicsGrade = 0.0, mathematicsGrade = 0.0, rusGrade = 0.0, literatureGrade = 0.0, geometryGrade = 0.0, informaticsGrade = 0.0;

        System.out.println("Вычисление средней оценки в " + group + " классе.");

        try {
            int count = classroomDataGroups.getPersons(group).size();

            for (int j = 0; j < count; j++) {
                physicsGrade += classroomDataGroups.getPersons(group).get(j).getSubjectGrades().getPhysicsGrade();
                mathematicsGrade += classroomDataGroups.getPersons(group).get(j).getSubjectGrades().getMathematicsGrade();
                rusGrade += classroomDataGroups.getPersons(group).get(j).getSubjectGrades().getRusGrade();
                literatureGrade += classroomDataGroups.getPersons(group).get(j).getSubjectGrades().getLiteratureGrade();
                geometryGrade += classroomDataGroups.getPersons(group).get(j).getSubjectGrades().getGeometryGrade();
                informaticsGrade += classroomDataGroups.getPersons(group).get(j).getSubjectGrades().getInformaticsGrade();
            }
            System.out.println(((physicsGrade / count) + (mathematicsGrade / count) + (rusGrade / count) + (literatureGrade / count)
                    + (geometryGrade / count) + (informaticsGrade / count)) / 6);

        } catch (NullPointerException nullPointerException) {
            System.out.println("Значение 'класс' введено некорректно.");
        }
    }

    public static void searchPersonByAssessment(DataGroup<Integer> personAgeDataGroups, int ageMin, int ageMax, int grade) {

        int ageMinStr = ageMin + 1, ageMaxStr = ageMax - 1;

        System.out.println("\n" + "Ученики с оценками " + grade + " старше " + ageMin + " младше " + ageMax + " лет.");

        try {
            for (int i = ageMinStr; i <= ageMaxStr; i++) {
                for (int j = 0; j < personAgeDataGroups.getPersons(i).size(); j++) {
                    if (personAgeDataGroups.getPersons(i).get(j).getSubjectGrades().getPhysicsGrade() == grade &&
                            personAgeDataGroups.getPersons(i).get(j).getSubjectGrades().getMathematicsGrade() == grade &&
                            personAgeDataGroups.getPersons(i).get(j).getSubjectGrades().getRusGrade() == grade &&
                            personAgeDataGroups.getPersons(i).get(j).getSubjectGrades().getLiteratureGrade() == grade &&
                            personAgeDataGroups.getPersons(i).get(j).getSubjectGrades().getGeometryGrade() == grade &&
                            personAgeDataGroups.getPersons(i).get(j).getSubjectGrades().getInformaticsGrade() == grade) {
                        System.out.println(personAgeDataGroups.getPersons(i).get(j).toString());
                    }
                }
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("Значение 'возраст' или 'оценка' введено некорректно.");
        }
    }

    public static void searchPersonBySurname(DataGroup<Character> personSurnameDataGroups, String surname) {

        System.out.println("\n" + "Ученики с фамилией " + surname + ".");

        try {
            for (int i = 0; i < personSurnameDataGroups.getPersons(surname.charAt(0)).size(); i++) {
                if (personSurnameDataGroups.getPersons(surname.charAt(0)).get(i).getFamily().equals(surname)) {
                    System.out.println(personSurnameDataGroups.getPersons(surname.charAt(0)).get(i));
                }
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("Учеников с такой фамилией нет.");
        }
        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException){
            System.out.println("Значение 'фамилия ученика' пустое.");
        }
    }
}
