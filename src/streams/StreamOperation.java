package streams;

import java.util.Arrays;

public class StreamOperation {

    public static void main(String[] args) {
        int arr[] = {3,1,2,5,11,19,44,6,33,99,8,104,4,23};
        Arrays.stream(arr).filter(n -> n%2 == 0).forEach(i -> System.out.println(i));
    }
}
