package org.example.methods;

import org.example.dataGroups.DataGroup;

public class Methods {
    public static void calculateAverageGrade(DataGroup classroomDataGroups, int group) {

        double physicsGrade = 0.0, mathematicsGrade = 0.0, rusGrade = 0.0, literatureGrade = 0.0, geometryGrade = 0.0, informaticsGrade = 0.0;

        String groupStr = String.valueOf(group);

        System.out.println("Вычисление средней оценки в " + group + " классе.");

        try {
            int count = classroomDataGroups.getPersons(groupStr).size();

            for (int j = 0; j < count; j++) {
                physicsGrade += classroomDataGroups.getPersons(groupStr).get(j).getSUBJECT_GRADES().getPHYSICS_GRADE();
                mathematicsGrade += classroomDataGroups.getPersons(groupStr).get(j).getSUBJECT_GRADES().getMATHEMATICS_GRADE();
                rusGrade += classroomDataGroups.getPersons(groupStr).get(j).getSUBJECT_GRADES().getRUS_GRADE();
                literatureGrade += classroomDataGroups.getPersons(groupStr).get(j).getSUBJECT_GRADES().getLITERATURE_GRADE();
                geometryGrade += classroomDataGroups.getPersons(groupStr).get(j).getSUBJECT_GRADES().getGEOMETRY_GRADE();
                informaticsGrade += classroomDataGroups.getPersons(groupStr).get(j).getSUBJECT_GRADES().getINFORMATICS_GRADE();
            }
            System.out.println(((physicsGrade / count) + (mathematicsGrade / count) + (rusGrade / count) + (literatureGrade / count)
                    + (geometryGrade / count) + (informaticsGrade / count)) / 6);

        } catch (NullPointerException nullPointerException) {
            System.out.println("Значение 'класс' введено некорректно.");
        }
    }

    public static void searchPersonByAssessment(DataGroup personAgeDataGroups, int ageMin, int ageMax, int grade) {

        int ageMinStr = ageMin + 1, ageMaxStr = ageMax - 1;

        System.out.println("\n" + "Ученики с оценками " + grade + " старше " + ageMin + " младше " + ageMax + " лет.");

        try {
            for (int i = ageMinStr; i <= ageMaxStr; i++) {
                for (int j = 0; j < personAgeDataGroups.getPersons(String.valueOf(i)).size(); j++) {
                    if (personAgeDataGroups.getPersons(String.valueOf(i)).get(j).getSUBJECT_GRADES().getPHYSICS_GRADE() == grade &&
                            personAgeDataGroups.getPersons(String.valueOf(i)).get(j).getSUBJECT_GRADES().getMATHEMATICS_GRADE() == grade &&
                            personAgeDataGroups.getPersons(String.valueOf(i)).get(j).getSUBJECT_GRADES().getRUS_GRADE() == grade &&
                            personAgeDataGroups.getPersons(String.valueOf(i)).get(j).getSUBJECT_GRADES().getLITERATURE_GRADE() == grade &&
                            personAgeDataGroups.getPersons(String.valueOf(i)).get(j).getSUBJECT_GRADES().getGEOMETRY_GRADE() == grade &&
                            personAgeDataGroups.getPersons(String.valueOf(i)).get(j).getSUBJECT_GRADES().getINFORMATICS_GRADE() == grade) {
                        System.out.println(personAgeDataGroups.getPersons(String.valueOf(i)).get(j).toString());
                    }
                }
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("Значение 'возраст' или 'оценка' введено некорректно.");
        }
    }

    public static void searchPersonBySurname(DataGroup personSurnameDataGroups, String surname) {

        System.out.println("\n" + "Ученики с фамилией " + surname + ".");

        try {
            for (int i = 0; i < personSurnameDataGroups.getPersons(surname).size(); i++) {
                if (personSurnameDataGroups.getPersons(surname).get(i).getFAMILY().equals(surname)) {
                    System.out.println(personSurnameDataGroups.getPersons(surname).get(i));
                }
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("Учеников с такой фамилией нет.");
        }
    }
}
