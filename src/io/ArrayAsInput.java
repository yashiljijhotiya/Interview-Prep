package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ArrayAsInput {

    public static void main(String[] args) throws IOException {
        //********************** Using Scanner
        Scanner sc  = new Scanner(System.in);
        System.out.println("enter the length of the array");
        int len = sc.nextInt();
        int arr[] = new int[len];
        System.out.println("enter the elements in the array:");
        for (int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 0; i < len ; i++){
            sum += arr[i];
        }
        System.out.println("sum of arr is : " + sum);
        System.out.println(Arrays.toString(arr));
//************************ Using buffer reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the length of the array using bufferreader of fixed length");
        int num = Integer.parseInt(br.readLine()); //Length of Array
        String s= br.readLine(); //Input the number seperated by space
        int[] ar= new int[num];
        String[] s1 = s.split(" ");
        System.out.println("enter the elements in the array:");
        for(int i=0;i<num;i++)
        {
            ar[i]=Integer.parseInt(s1[i]);
        }
        System.out.println(Arrays.toString(ar));

        //****************************************************** for unknown length of string
        System.out.println("for unknown length");
        String[] integersInString = br.readLine().split(" ");
        int a[] = new int[integersInString.length];
        System.out.println("enter elem");
        for (int i = 0; i < integersInString.length; i++) {
            a[i] = Integer.parseInt(integersInString[i]);
        }
        System.out.println(Arrays.toString(a));
    }
}
