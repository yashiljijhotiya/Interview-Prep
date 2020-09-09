package Java;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public  int test(int n){
        try{
            return 0;
        }
        catch (Exception e){
            return 2;
        }
        finally {
            return 3;
        }
    }

    public static void main(String[] args) {
       // int arr [] = {8,7,9, 3, 10, 20,21};
        //Test  t = new Test();
        //System.out.println(t.test(arr));
//        Test test = new Test();
//        System.out.println(test.test(111));
        Calendar currentDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.add(startDate.MONTH, -3);
        Date sd = startDate.getTime();
        Date cd = currentDate.getTime();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String ssd = s.format(cd);
        String ccd = s.format(cd);
        System.out.println(ssd);
        System.out.println(ccd);
    }
}
