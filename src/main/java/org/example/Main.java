package org.example;

import org.example.dataGroups.ClassroomDataGroups;
import org.example.dataGroups.PersonAgeDataGroups;
import org.example.dataGroups.PersonSurnameDataGroups;
import org.example.dataLoad.DataLoad;
import org.example.person.Methods;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
        PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
        PersonSurnameDataGroups personSurnameDataGroups = new PersonSurnameDataGroups();

        DataLoad.loadStudentsData(classroomDataGroups, personAgeDataGroups, personSurnameDataGroups);

        Methods.calculateAverageGrade(classroomDataGroups, 10, 11);
        Methods.searchPersonByAssessment(personAgeDataGroups, 14, 18, 5);

        System.out.print("\nВведите фамилию ученика: ");

        Methods.searchPersonBySurname(personSurnameDataGroups, in.nextLine());
    }
}