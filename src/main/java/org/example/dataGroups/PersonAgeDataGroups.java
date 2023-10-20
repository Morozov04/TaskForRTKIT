package org.example.dataGroups;

import org.example.myCollections.Persons;
import org.example.person.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonAgeDataGroups {

    private final Map<Integer, Persons> DATA = new HashMap<>();

    public void addPerson(Person person){
        if (!DATA.containsKey(person.getAGE())) {
            DATA.put(person.getAGE(), new Persons());
        }
        DATA.get(person.getAGE()).add(person);
    }

    public Persons getPersons(int age) {
        return DATA.getOrDefault(age, new Persons());
    }
}
