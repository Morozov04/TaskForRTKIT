package org.example.dataGroups;

import org.example.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonNameDataGroups {

    private final Map<Character, List<Person>> DATA = new HashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getNAME().charAt(0))) {
            DATA.put(person.getNAME().charAt(0), new ArrayList<>());
        }
        DATA.get(person.getNAME().charAt(0)).add(person);
    }

    public List<Person> getPersons(char firstLetter) {
        return DATA.getOrDefault(firstLetter, new ArrayList<>());
    }
}
