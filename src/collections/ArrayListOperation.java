package collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListOperation {

    private void operation(){
        ArrayList<String> l = new ArrayList<>();
        l.add("Gwalior");
        l.add("Indore");
        l.add("Bangalore");
        ListIterator<String> itr = l.listIterator();
        System.out.println("traversing using iterator:");
        while(itr.hasNext()){
            System.out.println(itr.next() + " ");
        }
        System.out.println("traversing using forEach: ");
        l.forEach(e -> System.out.println(e));
    }

    public static void main(String[] args) {
        ArrayListOperation a = new ArrayListOperation();
        a.operation();
    }
}
