package org.example.dataGroups;

import org.example.myCollections.PersonsArrayList;
import org.example.myCollections.PersonsHashMap;
import org.example.person.Person;

public class DataGroup {
    private final IGroupCriterion CRITERION;

    //private final Map<String, List<Person>> GROUPS;
    private final PersonsHashMap<String> GROUPS;

    public DataGroup(IGroupCriterion criterion) {
        this.CRITERION = criterion;
        this.GROUPS = new PersonsHashMap<>();
    }

    public void addPerson(Person person) {
        String groupKey = CRITERION.getGroupKey(person);
        if (!GROUPS.containsKey(groupKey)) {
            GROUPS.put(groupKey, new PersonsArrayList());
        }
        GROUPS.get(groupKey).add(person);
    }

    public PersonsArrayList getPersons(String groupKey) {
        return GROUPS.get(groupKey);
    }
}
