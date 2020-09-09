package design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/* TC: O(log(n))*/
public class MostFrequentStack {

    class Element{
        int val;
        int sequenceNo;
        int frequency;

        Element(int val, int sequenceNo, int frequency){
            this.val = val;
            this.sequenceNo = sequenceNo;
            this.frequency = frequency;
        }
    }

    class ElementComparator implements Comparator<Element>{
        public int compare(Element e1, Element e2){
            if(e1.frequency != e2.frequency){
                return e2.frequency - e1.frequency;
            }
            return e2.sequenceNo - e1.sequenceNo;
        }
    }

    private  int sequenceNo = 0;
    PriorityQueue<Element> queue = new PriorityQueue<>(new ElementComparator());
    HashMap<Integer,Integer> map = new HashMap<>();

    private void push(int val){
        map.put(val,map.getOrDefault(val,0)+1);
        queue.offer(new Element(val,sequenceNo++, map.get(val)));
    }

    private  int pop(){
        int val = queue.poll().val;
        if(map.get(val) > 1){
            map.put(val, map.get(val)+1);
        }
        else{
            map.remove(val);
        }
        return val;
    }


  public static void main(String[] args) {

        MostFrequentStack stack = new MostFrequentStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    //
  }
}
