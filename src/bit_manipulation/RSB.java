package bit_manipulation;

import java.util.Scanner;

//Right most set bit mask X & 2s X compliment = X & (~X +1) or X & -X
public class RSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rsb = n & -n;
        System.out.println(Integer.toBinaryString(rsb));
    }
}
