package org.example.myCollections;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class PersonsHashMap<K> extends AbstractMap {
    private static final int DEFAULT_CAPACITY = 100;
    private Node<K, PersonsArrayList>[] buckets;
    private int size;

    public PersonsHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public PersonsHashMap(int capacity) {
        buckets = new Node[capacity];
        size = 0;
    }

    public void put(K key, PersonsArrayList value) {
        int index = getIndex(key);
        Node<K, PersonsArrayList> entry = buckets[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }

        Node<K, PersonsArrayList> newEntry = new Node<>(key, value);
        newEntry.setNext(buckets[index]);
        buckets[index] = newEntry;
        size++;
    }

    @Override
    public PersonsArrayList get(Object key) {
        int index = getIndex((K) key);
        Node<K, PersonsArrayList> entry = buckets[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }

        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = getIndex((K) key);
        Node<K, PersonsArrayList> entry = buckets[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            entry = entry.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<Map.Entry> entrySet() {
        return null;
    }

    private int getIndex(K key) {
        return key.hashCode() % buckets.length;
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}

