package org.example.dataGroups;

import org.example.myCollections.PersonHashMap;
import org.example.myCollections.PersonsArrayList;
import org.example.person.Person;

public class ClassroomDataGroups {
    private final PersonHashMap<Integer, PersonsArrayList> DATA = new PersonHashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getGROUP())) {
            DATA.put(person.getGROUP(), new PersonsArrayList());
        }
        DATA.get(person.getGROUP()).add(person);
    }

    public PersonsArrayList getPersons(int groups) {
        return DATA.getOrDefault(groups, new PersonsArrayList());
    }
}
