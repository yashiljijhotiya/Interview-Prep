package problem_solving;

//Leetcode 380. Insert Delete GetRandom O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class OrderOfOneOperation {

    private  static HashMap<Integer, Integer> map = new HashMap<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    private static boolean insert(int data){
        if(map.containsKey(data)){
            return false;
        }
        int index = list.size();
        list.add(data);
        map.put(data,index);
        return true;
    }

    private static boolean remove(int data){
        if(!map.containsKey(data)){
            return  false;
        }
        int indexRemove = map.remove(data);
        int tail = list.get(list.size()-1);
        swap(indexRemove, list.size() - 1);
        map.put(tail,indexRemove);
        list.remove(list.size()-1);
        map.remove(data);
        return true;
    }

    private static int getRandom(){
        if(list.isEmpty()){
            return 0;
        }
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);

    }

    private static void swap(int i, int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    public static void main(String[] args) {
        System.out.println(insert(4));
        System.out.println(insert(9));
        System.out.println(insert(4));
        System.out.println(getRandom());
        System.out.println(getRandom());
        System.out.println(remove(9));
        System.out.println(getRandom());


    }
}
