package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharInput {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        //Take size of array from user.
        System.out.println("Please enter size of array");
        int n = Integer.parseInt(br.readLine());
        //Declare a character array
        char arr[] = new char[n];
        //loop to take input of array elements
        for(int i = 0; i < n; i++){
            arr[i] = (char)br.read();
        }

        for(int j = 0; j < arr.length; j++){
            System.out.println(arr[j]);
        }

    }
}
