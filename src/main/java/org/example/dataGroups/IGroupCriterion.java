package org.example.dataGroups;

import org.example.person.Person;

@FunctionalInterface
public interface IGroupCriterion {
    String getGroupKey(Person person);
}
