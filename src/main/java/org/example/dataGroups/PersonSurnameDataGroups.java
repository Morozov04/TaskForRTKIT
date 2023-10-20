package org.example.dataGroups;

import org.example.myCollections.Persons;
import org.example.person.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonSurnameDataGroups {

    private final Map<Character, Persons> DATA = new HashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getFAMILY().charAt(0))) {
            DATA.put(person.getFAMILY().charAt(0), new Persons());
        }
        DATA.get(person.getFAMILY().charAt(0)).add(person);
    }

    public Persons getPersons(char firstLetter) {
        return DATA.getOrDefault(firstLetter, new Persons());
    }
}
