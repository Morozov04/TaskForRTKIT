package org.example.dataLoad;

import org.example.person.Person;
import org.example.person.SubjectGrades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataLoader implements IDataLoader {

    private final List<Person> PERSON_LIST = new ArrayList<>();

    @Override
    public List<Person> get() {
        return PERSON_LIST;
    }

    @Override
    public void loadData(String pathname) {
        try {
            File file = new File(pathname);
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
                                    Integer.parseInt(values[5]),
                                    Integer.parseInt(values[6]),
                                    Integer.parseInt(values[7]),
                                    Integer.parseInt(values[8]),
                                    Integer.parseInt(values[9])));
                    PERSON_LIST.add(person);
                }
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
