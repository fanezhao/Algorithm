package com.zmoyi.dataStructure.list.lru;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("A", "1");
        lruCache.put("B", "2");
        lruCache.put("C", "3");
        lruCache.print();
        System.out.println(lruCache.size());
        System.out.println("-------");

        lruCache.put("D", "4");
        lruCache.put("E", "5");
        lruCache.print();
        System.out.println(lruCache.size());
        System.out.println("-------");

        lruCache.put("F", "6");
        lruCache.print();
        System.out.println(lruCache.size());
        System.out.println("-------");

        System.out.println(lruCache.get("D"));
        lruCache.print();

        System.out.println("-------");
        lruCache.del("E");
        System.out.println(lruCache.size());
        lruCache.print();

    }
}
