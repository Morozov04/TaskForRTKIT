package org.example.dataGroups;

import org.example.myCollections.PersonsArrayList;
import org.example.myCollections.PersonsHashMap;
import org.example.person.Person;

public class PersonAgeDataGroups {

    //private final Map<Integer, PersonsArrayList> map = new HashMap<>();
    private final PersonsHashMap<Integer> DATA = new PersonsHashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getAGE())) {
            DATA.put(person.getAGE(), new PersonsArrayList());
        }
        DATA.get(person.getAGE()).add(person);
    }

    public PersonsArrayList getPersons(int age) {
        return DATA.getOrDefault(age, new PersonsArrayList());
    }
}
