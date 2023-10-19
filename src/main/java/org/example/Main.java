package org.example;

import org.example.dataGroups.ClassroomDataGroups;
import org.example.dataGroups.PersonAgeDataGroups;
import org.example.dataGroups.PersonNameDataGroups;
import org.example.dataLoad.DataLoad;
import org.example.person.Methods;

public class Main {
    public static void main(String[] args) {
        ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
        PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
        PersonNameDataGroups personNameDataGroups = new PersonNameDataGroups();

        DataLoad.loadStudentsData(classroomDataGroups, personAgeDataGroups, personNameDataGroups);

        System.out.println(classroomDataGroups.getPersons(8).size());
        System.out.println(personAgeDataGroups.getPersons(10).size());
        System.out.println(personNameDataGroups.getPersons('П').size());

        System.out.println(Methods.calculateAverageGrade(classroomDataGroups));
    }
}