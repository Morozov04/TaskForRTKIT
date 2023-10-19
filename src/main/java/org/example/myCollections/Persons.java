package org.example.myCollections;

public class Persons<T> {
    private final int SIZE = 16;
    private final int CUT = 4;
    private int pointer = 0;
    private Object[] array = new Object[SIZE];

    public void add(T item) {
        if(pointer == array.length-1)
            recreation(array.length*2);
        array[pointer++] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > SIZE && pointer < array.length / CUT)
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
