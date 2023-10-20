package org.example.dataGroups;

import org.example.myCollections.Persons;
import org.example.person.Person;

import java.util.HashMap;
import java.util.Map;

public class ClassroomDataGroups {
    private final Map<Integer, Persons> DATA = new HashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getGROUP())) {
            DATA.put(person.getGROUP(), new Persons());
        }
        DATA.get(person.getGROUP()).add(person);
    }

    public Persons getPersons(int groups) {
        return DATA.getOrDefault(groups, new Persons());
    }
}
