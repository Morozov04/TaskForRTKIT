package org.example.dataLoad;

import org.example.person.Person;
import java.util.List;

public interface IDataLoader {
    List<Person> get();
    void loadData(String pathname);
}
