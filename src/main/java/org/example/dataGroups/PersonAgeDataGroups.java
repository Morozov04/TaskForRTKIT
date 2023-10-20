package org.example.dataGroups;

import org.example.myCollections.PersonHashMap;
import org.example.myCollections.PersonsArrayList;
import org.example.person.Person;

public class PersonAgeDataGroups {
    private final PersonHashMap<Integer, PersonsArrayList> DATA = new PersonHashMap<>();

    public void addPerson(Person person){
        if (!DATA.containsKey(person.getAGE())) {
            DATA.put(person.getAGE(), new PersonsArrayList());
        }
        DATA.get(person.getAGE()).add(person);
    }

    public PersonsArrayList getPersons(int age) {
        return DATA.getOrDefault(age, new PersonsArrayList());
    }
}
