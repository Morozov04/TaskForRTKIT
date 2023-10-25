package org.example.dataGroups;

import org.example.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGroup {
    private final IGroupCriterion CRITERION;
    private final Map<String, List<Person>> GROUPS;

    public DataGroup(IGroupCriterion criterion) {
        this.CRITERION = criterion;
        this.GROUPS = new HashMap<>();
    }

    public void addPerson(Person person) {
        String groupKey = CRITERION.getGroupKey(person);
        if (!GROUPS.containsKey(groupKey)) {
            GROUPS.put(groupKey, new ArrayList<>());
        }
        GROUPS.get(groupKey).add(person);
    }

    public List<Person> getPersons(String groupKey) {
        return GROUPS.get(groupKey);
    }
}
