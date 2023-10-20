package org.example.myCollections;

import java.util.*;

public class PersonsHashMap<K> extends AbstractMap<K, PersonsArrayList> {
    private static final int DEFAULT_CAPACITY = 100;
    private List<Entry<K, PersonsArrayList>>[] lists;
    private int size;

    public PersonsHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public PersonsHashMap(int capacity) {
        lists = new ArrayList[capacity];
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = getIndex((K) key);
        List<Entry<K, PersonsArrayList>> list = lists[index];
        if (list != null) {
            for (Entry<K, PersonsArrayList> entry : list) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public PersonsArrayList put(K key, PersonsArrayList value) {
        int index = getIndex(key);
        List<Entry<K, PersonsArrayList>> list = lists[index];
        if (list == null) {
            list = new ArrayList<>();
            lists[index] = list;
        } else {
            for (Entry<K, PersonsArrayList> entry : list) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return value;
                }
            }
        }
        list.add(new Entry<>(key, value));
        size++;

        if ((float) size / lists.length > 0.75f) {
            resize();
        }
        return value;
    }

    @Override
    public Set<Map.Entry<K, PersonsArrayList>> entrySet() {
        Set<Map.Entry<K,PersonsArrayList>> es = new HashSet<>();
        for (Map.Entry<K, PersonsArrayList> entry : es) {
            while (entry != null) {
                es.add(entry);
                entry = (Map.Entry<K, PersonsArrayList>) entry.getKey();
            }
        }
        return es;
    }

    @Override
    public PersonsArrayList get(Object key) {
        int index = getIndex((K) key);
        List<Entry<K, PersonsArrayList>> list = lists[index];
        if (list != null) {
            for (Entry<K, PersonsArrayList> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public PersonsArrayList getOrDefault(Object key, PersonsArrayList defaultValue) {
        PersonsArrayList value = get(key);
        return value != null ? value : defaultValue;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % lists.length;
    }

    private void resize() {
        int newCapacity = lists.length * 2;
        List<Entry<K, PersonsArrayList>>[] arrayLists = new ArrayList[newCapacity];
        for (List<Entry<K, PersonsArrayList>> bucket : lists) {
            if (bucket != null) {
                for (Entry<K, PersonsArrayList> entry : bucket) {
                    int newIndex = Math.abs(entry.getKey().hashCode()) % newCapacity;
                    List<Entry<K, PersonsArrayList>> arrayList = arrayLists[newIndex];
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