package mathematics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormBiggestNoFromArr {

    private static void findLargestNumber(List<String> list ){
        if(list == null || list.size() == 0){
            return;
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x+y;
                String yx = y+x;
                return xy.compareTo(yx) > 0 ? -1 : 1;
            }
        });

        for(String str : list){
            System.out.print(str);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("54");
        list.add("546");
        list.add("548");
        list.add("60");
        findLargestNumber(list);
    }
}
