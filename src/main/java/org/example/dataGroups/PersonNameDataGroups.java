package org.example.dataGroups;

import org.example.myCollections.Persons;
import org.example.person.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonNameDataGroups {

    private final Map<Character, Persons<Person>> DATA = new HashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getNAME().charAt(0))) {
            DATA.put(person.getNAME().charAt(0), new Persons<>());
        }
        DATA.get(person.getNAME().charAt(0)).add(person);
    }

    public Persons<Person> getPersons(char firstLetter) {
        return DATA.getOrDefault(firstLetter, new Persons<>());
    }
}
