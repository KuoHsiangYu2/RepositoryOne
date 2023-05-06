/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam2;

import static java.lang.System.out;
import static java.lang.System.err;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author hsiang-yu
 */
// https://www.facebook.com/groups/108375436301355/posts/1339528449852708
public class Exam2 {

    private static final HashMap<Integer, String> numToStrMap = new HashMap<Integer, String>();

    static {
        numToStrMap.put(1, "one");
        numToStrMap.put(2, "two");
        numToStrMap.put(3, "three");
        numToStrMap.put(4, "four");
        numToStrMap.put(5, "five");
        numToStrMap.put(6, "six");
        numToStrMap.put(7, "seven");
        numToStrMap.put(8, "eight");
        numToStrMap.put(9, "nine");
    }

    private static String numToStr(int num) {
        String resultStr = numToStrMap.get(num);
        if (resultStr != null) {
            return resultStr;
        }
        throw new RuntimeException("numToStrMap error number.");
    }

    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            int answer = 0;
            out.print("enter num1 : ");
            int num1 = scanner.nextInt();
            out.print("enter num2 : ");
            int num2 = scanner.nextInt();
            out.print("enter operator : ");
            String operator = scanner.next();
            String str1 = numToStr(num1);
            String str2 = numToStr(num2);
            switch (operator) {
                case "+":
                    answer = num1 + num2;
                    if (num1 > 9 || num2 > 9) {
                        err.println("invalid number");
                    } else {
                        out.printf("%s plus %s is %d %n", str1, str2, answer);
                    }
                    break;
                case "-":
                    answer = num1 - num2;
                    if (num1 < 10 && num2 < 10) {
                        out.printf("%s minus %s is %d %n", str1, str2, answer);
                    } else {
                        err.println("invalid number");
                    }
                    break;
                default:
                    err.println("invalid operator");
                    break;
            }
        }
    }
}
