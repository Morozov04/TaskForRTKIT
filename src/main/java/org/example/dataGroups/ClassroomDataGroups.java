package org.example.dataGroups;

import org.example.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassroomDataGroups {
    private final Map<Integer, List<Person>> DATA = new HashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getGROUP())) {
            DATA.put(person.getGROUP(), new ArrayList<>());
        }
        DATA.get(person.getGROUP()).add(person);
    }

    public List<Person> getPersons(int groups) {
        return DATA.getOrDefault(groups, new ArrayList<>());
    }
}
