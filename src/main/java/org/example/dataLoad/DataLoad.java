package org.example.dataLoad;

import org.example.dataGroups.ClassroomDataGroups;
import org.example.dataGroups.PersonAgeDataGroups;
import org.example.dataGroups.PersonNameDataGroups;
import org.example.person.Person;
import org.example.person.SubjectGrades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataLoad {
    public static void loadStudentsData(ClassroomDataGroups classroomDataGroups, PersonAgeDataGroups personAgeDataGroups, PersonNameDataGroups personNameDataGroups) {
        try {
            File file = new File("src/main/resources/students.csv");
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                if (count != 0) {
                    Person person = new Person(values[0],
                            values[1],
                            Integer.parseInt(values[2]),
                            Integer.parseInt(values[3]),
                            new SubjectGrades(
                                    Integer.parseInt(values[4]),
                                    Integer.parseInt(values[4]),
                                    Integer.parseInt(values[6]),
                                    Integer.parseInt(values[7]),
                                    Integer.parseInt(values[8]),
                                    Integer.parseInt(values[9])));
                    classroomDataGroups.addPerson(person);
                    personAgeDataGroups.addPerson(person);
                    personNameDataGroups.addPerson(person);
                }
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
