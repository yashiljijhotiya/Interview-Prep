package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderData {

    private static void reorderLogs(String [] logs){
        if(logs == null || logs.length == 0){
            return;
        }
        List<String> digitLog = new ArrayList<>();
        List<String> letterLog = new ArrayList<>();

        for(String s : logs){
            String [] str = s.split(" ");
            if(Character.isDigit(str[1].charAt(0))){
                digitLog.add(s);
            }
            else {
                letterLog.add(s);
            }
        }

        Collections.sort(letterLog, (a,b) -> {
            String s1 = a.substring(a.indexOf(" ") + 1);
            String s2 = b.substring(b.indexOf(" ") + 1);
            return s1.equals(s2) ? a.compareTo(b) : s1.compareTo(s2);
        });
        letterLog.addAll(digitLog);
        letterLog.forEach(i -> System.out.println(i));

    }

    public static void main(String[] args) {
        String [] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reorderLogs(logs);
    }
}
