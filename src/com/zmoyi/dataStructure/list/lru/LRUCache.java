package com.zmoyi.dataStructure.list.lru;

public class LRUCache {

    /** 最大容量 */
    private final Integer cap;

    /** 当前容量 */
    private Integer currCap;

    /** 头节点，本身不存值 */
    private LRUCacheNode head = new LRUCacheNode();

    public LRUCache(Integer cap) {
        this.cap = cap;
        this.currCap = 0;
    }

    /**
     * 删除缓存
     * @param key
     */
    public void del(String key) {
        LRUCacheNode temp = head.next;
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.del();
                currCap--;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 添加缓存值，每次添加优先放在最前面；如果超出总容量，则把后面的干掉
     * @param key
     * @param val
     */
    public void put(String key, Object val) {
        if (currCap >= cap) {
            LRUCacheNode temp = head.next;
            while (temp != null) {
                if (temp.next == null) {
                    temp.del();
                    currCap--;
                    break;
                }
                temp = temp.next;
            }
        }
        head.add(new LRUCacheNode(key, val));
        currCap++;
    }

    /**
     * 获取缓存，获取完了之后把该节点从原位置删除并放在最前面
     * @param key
     * @return
     */
    public Object get(String key) {
        LRUCacheNode temp = head.next;
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.del();
                head.add(temp);
                return temp.val;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 打印
     */
    public void print() {
        LRUCacheNode temp = head.next;
        while (temp != null) {
            System.out.printf("key:%s  val:%s%n", temp.key, temp.val);
            temp = temp.next;
        }
    }

    /**
     * 获取缓存当前大小
     * @return
     */
    public Integer size() {
        return currCap;
    }

    /**
     * 获取当前缓存总容量
     * @return
     */
    public Integer cap() {
        return cap;
    }
}
