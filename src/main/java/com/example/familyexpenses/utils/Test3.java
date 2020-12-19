package com.example.familyexpenses.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            float time;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the time in minutes: ");
            time = Float.parseFloat(br.readLine());
            timeColors(time);
        }
    }

    private static void timeColors(float f) {
        if (f >= 5) {
            f = f % 5;
        }
        if (f < 3) {
            System.out.println("green");
        } else if (f < 4) {
            System.out.println("yellow");
        } else if (f < 5) {
            System.out.println("red");
        }

    }
}
