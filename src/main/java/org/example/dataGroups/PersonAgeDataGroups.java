package org.example.dataGroups;

import org.example.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonAgeDataGroups {

    private final Map<Integer, List<Person>> DATA = new HashMap<>();

    public void addPerson(Person person){
        if (!DATA.containsKey(person.getAGE())) {
            DATA.put(person.getAGE(), new ArrayList<>());
        }
        DATA.get(person.getAGE()).add(person);
    }

    public List<Person> getPersons(int age) {
        return DATA.getOrDefault(age, new ArrayList<>());
    }
}
