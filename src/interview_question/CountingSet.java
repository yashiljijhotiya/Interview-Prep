package interview_question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountingSet {

   Map<String,Integer> freqCount = new ConcurrentHashMap<>();

    private  int add(String s){
        freqCount.put(s,freqCount.getOrDefault(s,0)+1);
        return freqCount.get(s);
    }

    private int remove(String s){
        int count = 0;
        if(freqCount.containsKey(s)){
            count = freqCount.get(s);
            if(count == 1){
                freqCount.remove(s);
            }
            else {
                freqCount.put(s, freqCount.get(s)-1);
            }
            count--;
        }
        return count;
    }

    private int count(String s){
        if(freqCount.containsKey(s)){
            return freqCount.get(s);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        CountingSet countingSet = new CountingSet();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter no. of threads");
        int noOfThreads = Integer.parseInt(br.readLine());
        ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);
        System.out.println("no. of inputs");
        int noOfInputs = Integer.parseInt(br.readLine());
        int i = 0;

        while(i < noOfInputs) {

            System.out.println("{enter : 1 to add, enter : 2 to count, enter : 3 to remove}");
            int c = Integer.parseInt(br.readLine());
            System.out.println("enter string");
            String str = br.readLine();

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    switch (c) {
                        case 1:
                            System.out.println("count  ('" +str+"') => "+countingSet.add(str));
                            break;
                        case 2:
                            System.out.println("count  ('" +str+"') => "+countingSet.count(str));
                            break;
                        case 3:
                            System.out.println("count  ('" +str+"') => "+countingSet.remove(str));
                            break;
                        default:
                            break;
                    }

                }
            });
            i++;
        }
        executorService.shutdown();
    }
}
