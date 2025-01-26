package GfG.LinkedLists;
/* 
GfG problem - "LRU Cache" solution
Link : https://www.geeksforgeeks.org/problems/lru-cache/1
 */

import java.util.Map;
import java.util.HashMap;

public class LRUCache {
    int capacity;
    DLLNode head, tail;
    Map<Integer, DLLNode> cache;

    public LRUCache(int cap) {
        this.capacity = cap;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        this.cache = new HashMap<>();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void insert(DLLNode node) {
        DLLNode temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
    }

    public void remove(DLLNode node) {
        DLLNode p = node.prev;
        DLLNode n = node.next;
        p.next = n;
        n.prev = p;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLLNode res = cache.get(key);
            cache.remove(key);
            remove(res);
            insert(res);
            cache.put(key, head.next);
            return res.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLLNode temp = cache.get(key);
            cache.remove(key);
            remove(temp);
        }
        if (cache.size() == capacity) {
            cache.remove(tail.prev.key);
            remove(tail.prev);
        }
        insert(new DLLNode(key, value));
        cache.put(key, head.next);
    }
}
