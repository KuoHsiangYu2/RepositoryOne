// package com.test1;

import static java.lang.System.out;

/* 計算數字質因數分解 */
public class MainFinal {

    // 輸入的數字.
    private static final int INPUT_NUM = 25872;

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int input = INPUT_NUM;
        int primeNumber = 2; // 定義一個最小的質因數.
        int exponent = 0; // 定義次方.

        if (input == 1) {
            out.println(input + " = 1^1");
            return;
        } else if (input < 1) {
            out.printf("[%d] error number %n", input);
            return;
        }

        out.print(input + " = ");
        for (;;) {
            if (input == 1) {
                out.printf("%d^%d", primeNumber, exponent);
                break;
            } else if ((input % primeNumber) == 0) {
                input = (input / primeNumber);
                exponent++;
            } else if (exponent != 0) {
                out.printf("%d^%d * ", primeNumber, exponent);
                primeNumber++;
                exponent = 0;
            } else {
                primeNumber++;
                exponent = 0;
            }
        }

        out.println();
        long t2 = System.currentTimeMillis();
        out.print("程式執行花費：");
        out.print((t2 - t1));
        out.println(" 豪秒");
        out.println();
        out.println("finish");
    }
}