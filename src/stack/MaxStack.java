package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * push() -> O(1)
 * pop() -> O(1)
 * peek() -> O(1)
 * popTop() -> O(1)
 * peekMax() ->O(1) will get the max element from the stack
 * For all the above 5 operations are done using 2 stacks in the same way as min stack in O(1) operation
 * I/P : 2,3,1,4,2,1 ->  stack : Top-> 1,2,4,1,3,2  maxStack: Top -> 4,4,,4,3,3,2
 * popMax() -> 5,1,5,2 here in stack top has 5 as max and it occurs in 2 places
 * if we pop it should remove the above one entry int the stack otherwise for single occurrence it should
 * remove that element present at any position.
 * Approach: To remove popMax in O(1) we can use doubly linked list and to get the location of max and we
 * have to use treeMap to store the max val
 **/
public class MaxStack {

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    private TreeMap<Integer, List<Node>> treeMap;
    private final Node head;
    private final Node tail;

    public MaxStack() {
        treeMap = new TreeMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }


    private Node addTop(int x) {
        Node node = new Node(x);
        Node prev = tail.prev;
        //connecting from tail
        node.next = tail;
        tail.prev = node;

        //connecting from head
        node.prev = prev;
        prev.next = node;
        return node;
    }

    private Node getTop() {
        return tail.prev;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    private void push(int val) {
        Node node = addTop(val);// add element in the dll
        if (treeMap.containsKey(val)) {
            treeMap.get(val).add(node);
        } else {
            List<Node> list = new ArrayList<>();
            list.add(node);
            treeMap.put(val, list);
        }
    }

    private int pop() {
        Node top = getTop();
        remove(top);
        if (treeMap.containsKey(top.data)) {
            List<Node> list = treeMap.get(top.data);
            list.remove(list.size() - 1);// for multiple occurrence remove the last element
            if (list.size() == 0) {
                treeMap.remove(top.data);
            }
        }
        return top.data;
    }

    private int top() {
        Node top = getTop();
        return top.data;
    }

    private int peek() {
        Node top = getTop();
        return top.data;
    }

    private int peekMax() {
        Integer key = treeMap.lastKey();// return the max val
        return key;
    }

    private int popMax() {
        Integer key = treeMap.lastKey();// return the max val
        if (treeMap.containsKey(key)) {
            List<Node> list = treeMap.get(key);
            Node tmp = list.remove(list.size() - 1);
            remove(tmp);
            if (list.size() == 0) {
                treeMap.remove(key);
            }
        }
        return key;
    }


    public static void main(String[] args) {

    }
}
