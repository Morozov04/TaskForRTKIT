package org.example.person;

import org.example.dataGroups.ClassroomDataGroups;
import org.example.dataGroups.PersonAgeDataGroups;
import org.example.dataGroups.PersonSurnameDataGroups;
import org.example.myCollections.Persons;

public class Methods {
    public static void calculateAverageGrade(ClassroomDataGroups classroomDataGroups, int groupMin, int groupMax){
        System.out.println("Вычисление средней оценки в классах: " + groupMin + " ... " + groupMax + ".");

        double physicsGrade = 0.0;
        double mathematicsGrade = 0.0;
        double rusGrade = 0.0;
        double literatureGrade = 0.0;
        double geometryGrade = 0.0;
        double informaticsGrade = 0.0;

        int count = 0;

        for (int i = groupMin; i <= groupMax; i++){
            for (int j = 0; j < classroomDataGroups.getPersons(i).size(); j++){
                physicsGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getPHYSICS_GRADE();
                mathematicsGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getMATHEMATICS_GRADE();
                rusGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getRUS_GRADE();
                literatureGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getLITERATURE_GRADE();
                geometryGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getGEOMETRY_GRADE();
                informaticsGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getINFORMATICS_GRADE();

                count++;
            }
        }
        System.out.println(((physicsGrade/count) + (mathematicsGrade/count) + (rusGrade/count)+ (literatureGrade/count)
                +(geometryGrade/count)+ (informaticsGrade/count))/6);
    }

    public static void findExcellentStudents(PersonAgeDataGroups personAgeDataGroups, int ageMin, int ageMax, int grade){
        int ageMinStr = ageMin-- , ageMaxStr = ageMax++;
        System.out.println("\n" + "Ученики с оценками " + grade + " старше " + ageMinStr + " младше " + ageMaxStr + " лет.");
        for (int i = ageMin; i <= ageMax; i++){
            for (int j = 0; j < personAgeDataGroups.getPersons(i).size(); j++){
                if (personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getPHYSICS_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getMATHEMATICS_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getRUS_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getLITERATURE_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getGEOMETRY_GRADE() == grade &&
                        personAgeDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getINFORMATICS_GRADE() == grade){
                           System.out.println(personAgeDataGroups.getPersons(i).get(j).toString());
                }
            }
        }
    }

    public static void searchPersonBySurname(PersonSurnameDataGroups personSurnameDataGroups, String surname){
        System.out.println("\n" + "Ученики с фамилией " + surname + ".");
        Persons<Person> persons = personSurnameDataGroups.getPersons(surname.charAt(0));
        for (int i = 0; i < persons.size(); i++){
            if (persons.get(i).getFAMILY().equals(surname)){
                System.out.println(persons.get(i));
            }
        }
    }
}
