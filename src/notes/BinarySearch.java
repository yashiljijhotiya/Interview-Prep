package notes;

public class BinarySearch {

    /*
    *First, we will find the middle of start and end. An easy way to find the middle would be:
    * middle=(start+end)/2middle=(start+end)/2. For Java and C++, this equation will work for most cases,
    * but when start or end is large, this equation will give us the wrong result due to integer overflow.
    * Imagine that start is equal to the maximum range of an integer (e.g. for Java: int start = Integer.MAX_VALUE).
    * Now adding anything to start will result in an integer overflow. Since we need to add both the numbers first to
    * evaluate our equation, an overflow might occur. The safest way to find the middle of two numbers without getting
    * an overflow is as follows:  middle  = start + (end-start)/2
    *
    * */
}
