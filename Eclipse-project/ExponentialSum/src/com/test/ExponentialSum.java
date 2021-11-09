/*
廖國丞
請問我這個迴圈要如何更改才可符合題目
https://www.facebook.com/groups/108375436301355/posts/1264182490720638/
*/
package com.test;

import static com.util.Output.print;
import static com.util.Output.println;

import java.util.Scanner;

public class ExponentialSum {

    public ExponentialSum() {
        super();
    }

    private static int myPow(int base, int power) {
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb1 = new StringBuffer();
        int inputNum = 0;/* 使用者輸入的數字 */
        int answerNum = 0;/* 這個變數用於累加許多 2的N次方 加總的和 */
        println("2的指數和計算程式");
        println("=====================");

        print("請輸入最終值(>=1)：");
        inputNum = scanner.nextInt();

        println("結果為");

        for (int i = 1; i <= inputNum; i++) {
            int tempNum = ExponentialSum.myPow(2, i);
            sb1.append(tempNum);
            sb1.append(" + ");
            answerNum = answerNum + tempNum;
        }

        /* 字串切割，把後面額外的 +號 移除掉 */
        String result = sb1.substring(0, sb1.length() - 3);
        StringBuffer sb2 = new StringBuffer(result);
        sb2.append(" = ");
        sb2.append(answerNum);

        println(sb2.toString());

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

}

/*
2的指數和計算程式
=====================
請輸入最終值(>=1)：7
結果為
2 + 4 + 8 + 16 + 32 + 64 + 128 = 254
*/
