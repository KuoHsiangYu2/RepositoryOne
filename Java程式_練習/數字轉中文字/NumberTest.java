/*
jdk 版本：11.0.22
IDE：Apache NetBeans IDE 21
電腦環境：Windows 11 專業版 (23H2)
檔案名稱：NumberTest.java
檔案編碼：UTF-8 檔首無BOM
命令提示字元編碼：MS950
編譯指令：javac -encoding UTF-8 NumberTest.java
執行指令：java NumberTest

https://www.facebook.com/groups/1403852566495675/posts/3790381254509449/
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package com.test.num1;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *
 * @author hsiangyu
 */
public class NumberTest {

    private static final String[] units = new String[]{"", "十", "百", "千"};
    private static final String[] digits = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, Charset.forName("Big5"));
        System.out.print("Please enter 0 ~ 999 number : ");
        int number = scanner.nextInt();
        System.out.println("result : " + convertToChinese(number));

        if (scanner != null) {
            scanner.close();
        }
    }

    private static String convertToChinese(int inputNumber) {
        if (inputNumber < 0) {
            System.err.println("input number cannot be less than 0");
            return "[error input number]";
        }
        if (inputNumber > 9999) {
            System.err.println("input number cannot be greater than 9999");
            return "[error input number]";
        }

        if (inputNumber == 0) {
            return digits[0];
        }

        StringBuilder chineseNumber = new StringBuilder();
        int unitPos = 0;
        boolean needZero = false;

        while (inputNumber > 0) {
            int digit = inputNumber % 10;
            if (digit != 0) {
                if (needZero) {
                    chineseNumber.insert(0, digits[0]);
                    needZero = false;
                }
                chineseNumber.insert(0, (digits[digit] + units[unitPos]));
            } else {
                needZero = true;
            }
            inputNumber = inputNumber / 10;
            unitPos++;
        }

        String resultStr = chineseNumber.toString();

        if (resultStr.startsWith("一十")) {
            /* 刪除前面1個字元 */
            resultStr = resultStr.substring(1, resultStr.length());
        }

        if (resultStr.endsWith("零")) {
            /* 刪除後面1個字元 */
            resultStr = resultStr.substring(0, (resultStr.length() - 1));
        }

        return resultStr;
    }

}
