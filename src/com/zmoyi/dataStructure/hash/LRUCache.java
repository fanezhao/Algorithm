package com.zmoyi.dataStructure.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhaofeng
 * @date 2023/10/31 19:16
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (super.containsKey(key)) {
            return super.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }
}
