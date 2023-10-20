package org.example.myCollections;

import org.example.person.Person;

public class Persons {
    private final int SIZE = 16;
    private int pointer = 0;
    private Object[] array = new Object[SIZE];

    public void add(Person item) {
        if(pointer == array.length-1)
            recreation(array.length*2);
        array[pointer++] = item;
    }

    public Person get(int index) {
        return (Person) array[index];
    }

    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > SIZE && pointer < array.length / 4)
            recreation(array.length/2);
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
