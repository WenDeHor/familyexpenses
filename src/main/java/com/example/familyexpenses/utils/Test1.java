package com.example.familyexpenses.utils;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter any Integer number:");
        n = s.nextInt();
        System.out.println("All the numbers from the 1st to  " + n + " :");
        naturalInteger(n, 1);
    }

    static int naturalInteger(int n, int i) {
        if (i <= n) {
            System.out.println(i + " ");
            return (naturalInteger(n, ++i));
        }
        return 1;
    }
}
