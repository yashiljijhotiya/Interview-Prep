package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperation {

    public static void main(String[] args) {
        List<Integer> prime = Arrays.asList(5,7,11,13);
        List<Integer> odd = Arrays.asList(1,3,5);
        List<Integer> even = Arrays.asList(2,4,6);
        List<List<Integer>> result = Arrays.asList(prime, odd, even);
        List<Integer> flatList = result.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(flatList);

    }
}
