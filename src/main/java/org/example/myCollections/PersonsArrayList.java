package org.example.myCollections;

import org.example.person.Person;

public class PersonsArrayList {
    private final int DEFAULT_CAPACITY = 1000;
    private int pointer = 0;
    private Object[] array = new Object[DEFAULT_CAPACITY];

    public void add(Person item) {
        if(pointer == array.length-1)
            recreation(array.length*2);
        array[pointer++] = item;
    }

    public Person get(int index) {
        return (Person) array[index];
    }

    public int size() {
        return pointer;
    }

    private void recreation(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}