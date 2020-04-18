/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class FindPrimeNumbers1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 程式語言：Java
        // IDE：NetBeans IDE 8.2
        // jdk version：1.8.0_144
        // jre version：1.8.0_144
        // 電腦作業系統：Windows 10 家用版
        
        Scanner scanner = new Scanner(System.in, "big5");
        int input = 0;
        boolean isPrimeFlag = false;

        System.out.print("請輸入數字：");
        input = scanner.nextInt();// 使用者輸入數字
        isPrimeFlag = isPrime(input);// 取得是否是質數的判斷

        if (true == isPrimeFlag) {
            System.out.println("Yes. 你輸入的數字為 質數");
        } else {
            System.out.println("No. 你輸入的數字為 合成數");
        }

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }// end of main() method

    private static boolean isPrime(int input) {
        // 這個函式用來判斷輸入的數字是否是質數

        int divisor = 0;// 計算因數數量的計數器
        for (int j = 1; j <= input; j++) {
            if (input % j == 0) {
                // 如果 input 除 j 餘數為 0 ，則 j 整除 input
                // j 就是 input 的因數
                divisor = divisor + 1;
            }
        }

        if (divisor == 2) {
            // 如果一個數字的因數只有 1 跟 他自己本身 ，則該數字即為質數。
            // 質數的因數只有2個， 1 跟 質數 自己本身。
            // input 是 質數，所以回傳 true
            return true;
        } else {
            // input 不是 質數，所以回傳 false
            return false;
        }
    }// end of isPrime() method

}
