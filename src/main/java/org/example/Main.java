package org.example;

import org.example.dataGroups.*;
import org.example.dataLoad.FileDataLoader;
import org.example.dataLoad.IDataLoader;
import org.example.methods.Methods;
import org.example.person.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        IDataLoader fileDataLoader = new FileDataLoader();

        fileDataLoader.loadData("src/main/resources/students.csv");

        IGroupCriterion groupCriterion = person -> String.valueOf(person.getGROUP());
        IGroupCriterion ageCriterion = person -> String.valueOf(person.getAGE());
        IGroupCriterion familyCriterion = Person::getFAMILY;

        DataGroup groupGroup = new DataGroup(groupCriterion);
        DataGroup ageGroup = new DataGroup(ageCriterion);
        DataGroup familyGroup = new DataGroup(familyCriterion);

        for (Person person : fileDataLoader.get()) {
            groupGroup.addPerson(person);
            ageGroup.addPerson(person);
            familyGroup.addPerson(person);
        }

        Methods.calculateAverageGrade(groupGroup, 10);
        Methods.calculateAverageGrade(groupGroup, 11);

        Methods.searchPersonByAssessment(ageGroup, 14, 18, 5);

        System.out.print("\nВведите фамилию ученика: ");

        Methods.searchPersonBySurname(familyGroup, in.nextLine());
    }
}
