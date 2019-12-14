package String;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NoAdjacentCharSame {

    static class Key {
        int freq;
        char val;
        public Key(int freq, char val){
            this.freq = freq;
            this.val = val;
        }
    }


    private static  int Max_Char = 26;

    private static void rearrangeStr(String str){
        int len = str.length();
        int freqCount [] = new int [Max_Char];
        String result = "";
//        Comparator<Key> keyComparator = new Comparator<Key>() {
//            @Override
//            public int compare(Key k1, Key k2) {
//                return k1.val - k2.val;
//            }
//        };

        Comparator<Key> keyComparator = (k1, k2) ->{
            return k1.val - k2.val;
        };
        PriorityQueue<Key> pq = new PriorityQueue<>(keyComparator);
        for(int i = 0; i < len; i++){
             freqCount[str.charAt(i)- 'a']++;
        }

        for(char c = 'a'; c <= 'z'; c++){
            int val = c - 'a';
            if(freqCount[val] > 0){
                pq.add(new Key(freqCount[val], c));
            }
        }
        Key prev = new Key(-1, '#');

        while (!pq.isEmpty()){
          var val = pq.poll();
          result = result + val.val;

          if(prev.freq > 0){
              pq.add(prev);
          }
            (val.freq)--;
          prev = val;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str = "bbbaa";
        rearrangeStr(str);
    }
}
