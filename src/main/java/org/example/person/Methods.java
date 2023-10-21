package org.example.person;

import org.example.dataGroups.ClassroomDataGroups;
import org.example.dataGroups.PersonAgeDataGroups;
import org.example.dataGroups.PersonSurnameDataGroups;

public class Methods {
    public static void calculateAverageGrade(ClassroomDataGroups classroomDataGroups, int group) {
        System.out.println("Вычисление средней оценки в " + group + " классе.");

        double physicsGrade = 0.0;
        double mathematicsGrade = 0.0;
        double rusGrade = 0.0;
        double literatureGrade = 0.0;
        double geometryGrade = 0.0;
        double informaticsGrade = 0.0;

        int count = classroomDataGroups.getPersons(group).size();
        for (int j = 0; j < count; j++) {
            physicsGrade += classroomDataGroups.getPersons(group).get(j).getSUBJECT_GRADES().getPHYSICS_GRADE();
            mathematicsGrade += classroomDataGroups.getPersons(group).get(j).getSUBJECT_GRADES().getMATHEMATICS_GRADE();
            rusGrade += classroomDataGroups.getPersons(group).get(j).getSUBJECT_GRADES().getRUS_GRADE();
            literatureGrade += classroomDataGroups.getPersons(group).get(j).getSUBJECT_GRADES().getLITERATURE_GRADE();
            geometryGrade += classroomDataGroups.getPersons(group).get(j).getSUBJECT_GRADES().getGEOMETRY_GRADE();
            informaticsGrade += classroomDataGroups.getPersons(group).get(j).getSUBJECT_GRADES().getINFORMATICS_GRADE();
        }
        System.out.println(((physicsGrade / count) + (mathematicsGrade / count) + (rusGrade / count) + (literatureGrade / count)
                + (geometryGrade / count) + (informaticsGrade / count)) / 6);
    }

    public static void searchPersonByAssessment(PersonAgeDataGroups personAgeDataGroups, int ageMin, int ageMax, int grade) {
        int ageMinStr = ageMin + 1, ageMaxStr = ageMax - 1;
        System.out.println("\n" + "Ученики с оценками " + grade + " старше " + ageMin + " младше " + ageMax + " лет.");
        for (int i = ageMinStr; i <= ageMaxStr; i++) {
            for (int j = 0; j < personAgeDataGroups.getPersons(i).size(); j++) {
                if (personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getPHYSICS_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getMATHEMATICS_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getRUS_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getLITERATURE_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getGEOMETRY_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getINFORMATICS_GRADE() == grade) {
                    System.out.println(personAgeDataGroups.getPersons(i).get(j).toString());
                }
            }
        }
    }

    public static void searchPersonBySurname(PersonSurnameDataGroups personSurnameDataGroups, String surname) {
        System.out.println("\n" + "Ученики с фамилией " + surname + ".");
        for (int i = 0; i < personSurnameDataGroups.getPersons(surname.charAt(0)).size(); i++) {
            if (personSurnameDataGroups.getPersons(surname.charAt(0)).get(i).getFAMILY().equals(surname)) {
                System.out.println(personSurnameDataGroups.getPersons(surname.charAt(0)).get(i));
            }
        }
    }
}
