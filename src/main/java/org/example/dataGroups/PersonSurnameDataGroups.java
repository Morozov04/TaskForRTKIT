package org.example.dataGroups;

import org.example.myCollections.PersonsArrayList;
import org.example.myCollections.PersonsHashMap;
import org.example.person.Person;

public class PersonSurnameDataGroups {

    //private final Map<Character, List<Person>> map = new HashMap<>();
    private final PersonsHashMap<Character> DATA = new PersonsHashMap<>();

    public void addPerson(Person person) {
        if (!DATA.containsKey(person.getFAMILY().charAt(0))) {
            DATA.put(person.getFAMILY().charAt(0), new PersonsArrayList());
        }
        DATA.get(person.getFAMILY().charAt(0)).add(person);
    }

    public PersonsArrayList getPersons(char firstLetter) {
        return DATA.getOrDefault(firstLetter, new PersonsArrayList());
    }
}
