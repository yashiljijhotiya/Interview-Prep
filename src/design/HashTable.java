package design;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private static class HTObject {
        int val;
        long ttl;

        HTObject(int val, long ttl) {
            this.val = val;
            this.ttl = ttl;
        }
    }

    private List<EntryNode> hashTable;

    HashTable() {
        hashTable = new ArrayList<>();
    }

    private static void put() {

    }

    private static Object get() {
        return null;
    }

    private static boolean contains() {
        return true;
    }

    private void remove() {
    }

    private int getHashCode(Object key) {
        int size = hashTable.size();
        return size;
    }

}
