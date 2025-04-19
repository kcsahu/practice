package com.example.dsa.practice1.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return this.cache.containsKey(key) ? this.cache.get(key) : -1;
    }

    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}
