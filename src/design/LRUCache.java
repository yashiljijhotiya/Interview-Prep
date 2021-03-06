package design;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    static HashMap<Integer, LRUNode> lru = new HashMap<Integer, LRUNode>();
    LRUNode head = null;
    LRUNode end = null;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        if(lru.containsKey(key)){
            LRUNode temp = lru.get(key);
            remove(temp);
            setHead(temp);
            return  temp.value;

        }
        return -1;
    }

    public void set(int key, int val){
        if(lru.containsKey((key))){
            LRUNode old = lru.get(key);
            old.value = val;
            remove(old);
            setHead(old);
        }
        else{
            LRUNode create = new LRUNode(key,val);
            if(lru.size() >= capacity){
                lru.remove(end.key);
                remove(end);

            }
            setHead(create);
            lru.put(key, create);
        }
    }

    public  void remove(LRUNode node){
        if(node.prv != null){
            node.prv.next = node.next;
        }
        else{
            head = node.next;
        }
        if(node.next != null){
            node.next.prv = node.prv;
        }
        else{
            end = node.prv;
        }
    }

    public void setHead(LRUNode node){
        node.next = head;
        node.prv = null;
        if(head != null){
            head.prv = node;
        }
        head = node;
        if(end == null){
            end = head;
        }
    }

    public static void main(String args[]){
        LRUCache l = new LRUCache(5);
        l.set(5,11);
        l.set(4,12);
        l.set(2,13);
        l.set(8,14);
        l.set(19,15);
        l.set(20,88);
        System.out.println(lru);
        System.out.println(l.get(5));

    }
}
