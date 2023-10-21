package org.example.myCollections;

import org.example.person.Person;

import java.util.AbstractList;

public class PersonsArrayList extends AbstractList<Person> {

    private final int DEFAULT_CAPACITY = 1000;
    private Person[] elements = new Person[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public Person get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Person person) {
        if (size == elements.length - 1) {
            resize();
        }
        elements[size++] = person;
        return true;
    }

    private void resize() {
        Person[] newElements = new Person[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
