package org.example.dataGroups;

import org.example.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGroup<K> {
    private final IGroupCriterion<K> criterion;
    private final Map<K, List<Person>> groups;

    //private final PersonsHashMap<K> GROUPS;

    public DataGroup(IGroupCriterion<K> criterion) {
        this.criterion = criterion;
        this.groups = new HashMap<>();
    }

    public void addPerson(Person person) {
        K groupKey = criterion.getGroupKey(person);
        if (!groups.containsKey(groupKey)) {
            groups.put(groupKey, new ArrayList<>());
        }
        groups.get(groupKey).add(person);
    }

    public List<Person> getPersons(K groupKey) {
        return groups.get(groupKey);
    }
}
