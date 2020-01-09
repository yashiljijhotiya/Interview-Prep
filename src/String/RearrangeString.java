package String;

import java.util.PriorityQueue;

//No adjascent char are same
public class RearrangeString {

    private class KeyFreq{
        char c;
        int freq;
    }

    private static void rearrangeStr(String str){
        PriorityQueue<KeyFreq> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);

    }
    public static void main(String[] args) {

    }
}
