package org.example.myCollections;

import java.util.ArrayList;
import java.util.List;

public class PersonHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 100;

    private List<Entry<K, V>>[] lists;
    private int size;

    public PersonHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public PersonHashMap(int capacity) {
        lists = new ArrayList[capacity];
        size = 0;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> list = lists[index];
        if (list != null) {
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        List<Entry<K, V>> list = lists[index];
        if (list == null) {
            list = new ArrayList<>();
            lists[index] = list;
        } else {
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }
        }
        list.add(new Entry<>(key, value));
        size++;

        if ((float) size / lists.length > 0.75f) {
            resize();
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> list = lists[index];
        if (list != null) {
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public V getOrDefault(K key, V defaultValue) {
        V value = get(key);
        return value != null ? value : defaultValue;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % lists.length;
    }

    private void resize() {
        int newCapacity = lists.length * 2;
        List<Entry<K, V>>[] arrayLists = new ArrayList[newCapacity];
        for (List<Entry<K, V>> bucket : lists) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int newIndex = Math.abs(entry.getKey().hashCode()) % newCapacity;
                    List<Entry<K, V>> arrayList = arrayLists[newIndex];
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        arrayLists[newIndex] = arrayList;
                    }
                    arrayList.add(entry);
                }
            }
        }
        lists = arrayLists;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
    }
}