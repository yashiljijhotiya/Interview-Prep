package Java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

// Remove duplicate from arraylist
public class RemoveDuplicate {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrList = new CopyOnWriteArrayList<>();

        arrList.add("Yashil");
        arrList.add("shubhi");
        Iterator<String> itr = arrList.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }


        List<String> list = new ArrayList<>();
        list.add("Delhi");
        list.add("Mumbai");
        list.add("Bangalore");
        list.add("Chennai");
        list.add("Kolkata");
        list.add("Mumbai");

        System.out.println(list);
        list = list.stream().distinct().collect(Collectors.toList());

        list.forEach(i ->{
            System.out.println(i);
        });
    }
}
