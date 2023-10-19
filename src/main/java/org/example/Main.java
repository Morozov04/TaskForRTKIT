package org.example;

import org.example.dataGroups.ClassroomDataGroups;
import org.example.dataGroups.PersonAgeDataGroups;
import org.example.dataGroups.PersonNameDataGroups;
import org.example.dataLoad.DataLoad;

public class Main {
    public static void main(String[] args) {
        ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
        PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
        PersonNameDataGroups personNameDataGroups = new PersonNameDataGroups();

        DataLoad.loadStudentsData(classroomDataGroups, personAgeDataGroups, personNameDataGroups);

        System.out.println(classroomDataGroups.getPersons(10).size());
        System.out.println(personAgeDataGroups.getPersons(14).size());
        System.out.println(personNameDataGroups.getPersons('А').size());
    }
}