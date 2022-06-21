package design;

import java.util.*;
/**
 * Review: In the delete() function while deleting element always swap from last index with the deleting element
 * and remove the last one so the array resized will not affect the index of the element
 * */
public class OrderOneSet {
    private Map<Integer, Integer> valMap;
    private List<Integer> valList;
    private Random random;

    public OrderOneSet() {
        valMap = new HashMap<>();
        valList = new ArrayList<>();
        random = new Random();
    }


    private boolean insert(int val) {
        if (!valMap.containsKey(val)) {
            valList.add(val);
            valMap.put(val, valList.size()-1);
            return true;
        } else {
            return false;
        }
    }

    private boolean delete(int val) {
        if (!valMap.containsKey(val)) {
            return false;
        } else {
           // Integer loc = valMap.get(val);
            valList.remove(valMap.get(val));
            valMap.remove(val);
            return true;
        }
    }

    private int getRandom() {
        int val = valList.get(random.nextInt(valList.size()));
        return val;
    }

    public static void main(String[] args) {
        OrderOneSet orderOneSet = new OrderOneSet();
        System.out.println(orderOneSet.insert(1));
        System.out.println(orderOneSet.insert(5));
        System.out.println(orderOneSet.insert(1));
        System.out.println(orderOneSet.getRandom());
        System.out.println(orderOneSet.getRandom());
        System.out.println(orderOneSet.getRandom());
        System.out.println(orderOneSet.delete(1));
        System.out.println(orderOneSet.getRandom());

    }
}
