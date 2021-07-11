package bit_manipulation;

import java.util.Scanner;
/* -> (<<) left shift : X =  00101011,  X<<3 = 01011000  (removed the 3 bits from left and shift the remaining bit
to the left and added the 3 0s to the right).
*
* -> (>>) right shift : X = 10100110, X>>3 = 11110100  (removed the 3 bits from right and append the MSB here MSB is 1 in the given
example to the left)
*
* -> (>>>)
*
* -> 2's Complement : X = -X or ~X+1
*
* -> ON bit: To make ON any bit always use "OR(|)" operator. X = 1011 0 101 we need to ON the 0 in b/w 1s, we have to create
* the maskBit whose length is equal to X and all the bits are zero except the bit which we need to make ON is set to 1.
* mask = 0000 1 000.
*  (X|mask) = ON bit result = (1011 0 101 | 0000 1 000)=  1011 1 101
*
*
* -> OFF bit: To make OFF any bit always use "AND(&)" operator. X = 101 1 0101 we need to OFF the bit. we have create the mask
* whose length is equal to X all the bits are 1 except the bit which we need to make OFF.
* mask = 111 0 1111
* (X|mask) = OFF bit result = (101 1 0101 & 111 0 1111) = 101 0 0101
*
*
* -> TOGGLE bit: To make TOGGLE any bit always use "XOR(^)" operator mask will be same as | operator and use ^
*
* -> CHECK bit: To check any particular bit we can use either "OR(|)" operator or "AND(&)" Operator
*
*
*
* */
public class ON_OFF_TOGGLE_CHECK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();


        int onMask = (1<<i);// mask to ON ith bit in num  (binary of 1 in 8 bits will  be  00000001 now left shift by i )
        int offMask = ~(1<<j);// mask to OFF jth bit in num
        int toggleMask = (1<<k);//mask to Toggle kth bit in num
        int checkMask = (1<<l);//mask to check the lth bit in num

        System.out.println((num | onMask));
        System.out.println((num & offMask));
        System.out.println((num ^ toggleMask));
        System.out.println((num & checkMask) == 0 ? false : true);
    }
}
