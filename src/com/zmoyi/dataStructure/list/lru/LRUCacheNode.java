package com.zmoyi.dataStructure.list.lru;

public class LRUCacheNode {

    public LRUCacheNode prev;

    public LRUCacheNode next;

    public String key;

    public Object val;

    public LRUCacheNode() {
    }

    public LRUCacheNode(String key, Object val) {
        this.key = key;
        this.val = val;
    }

    public void del() {
        if (this.next == null) {
            this.prev.next = null;
        } else {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.prev = null;
            this.next = null;
        }
    }

    public void add(LRUCacheNode node) {
        if (this.next != null) {
            node.next = this.next;
            this.next.prev = node;
            node.prev = this;
            this.next = node;
        } else {
            this.next = node;
            node.prev = this;
        }
    }
}
