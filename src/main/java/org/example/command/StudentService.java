package org.example.command;

import org.example.dataGroups.DataGroup;
import org.example.dataLoad.IDataLoader;
import org.example.person.Person;

public class StudentService {
    private final IDataLoader LOADER;

    public StudentService(IDataLoader dataLoader) {
        this.LOADER = dataLoader;
    }

    public static <K> void toDataGroup(DataGroup<K> dataGroup, StudentService studentService) {
        for (Person person : studentService.LOADER.get()) {
            dataGroup.addPerson(person);
        }
    }
}
