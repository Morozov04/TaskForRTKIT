package org.example.dataGroups;

import org.example.myCollections.PersonsArrayList;
import org.example.myCollections.PersonsHashMap;
import org.example.person.Person;

public class DataGroup<K> {
    private final IGroupCriterion<K> CRITERION;

    //private final Map<K, List<Person>> GROUPS;
    private final PersonsHashMap<K> GROUPS;

    public DataGroup(IGroupCriterion<K> criterion) {
        this.CRITERION = criterion;
        this.GROUPS = new PersonsHashMap<>();
    }

    public void addPerson(Person person) {
        K groupKey = CRITERION.getGroupKey(person);
        if (!GROUPS.containsKey(groupKey)) {
            GROUPS.put(groupKey, new PersonsArrayList());
        }
        GROUPS.get(groupKey).add(person);
    }

    public PersonsArrayList getPersons(K groupKey) {
        return GROUPS.get(groupKey);
    }
}
