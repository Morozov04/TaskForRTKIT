package org.example.dataGroups;

import org.example.person.Person;

@FunctionalInterface
public interface IGroupCriterion<K> {
    K getGroupKey(Person person);
}
