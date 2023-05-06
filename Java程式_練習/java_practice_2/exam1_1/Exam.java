package com.exam1;

import java.util.Scanner;

// https://www.facebook.com/groups/108375436301355/posts/1339528449852708
public class Exam {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0, num2 = 0, answer = 0;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        String operator = scanner.next();
        String str1 = "";
        String str2 = "";
        switch (num1) {
            case 1:
                str1 = "one";
                break;
            case 2:
                str1 = "two";
                break;
            case 3:
                str1 = "three";
                break;
            case 4:
                str1 = "four";
                break;
            case 5:
                str1 = "five";
                break;
            case 6:
                str1 = "six";
                break;
            case 7:
                str1 = "seven";
                break;
            case 8:
                str1 = "eight";
                break;
            case 9:
                str1 = "nine";
                break;
            default:
                throw new RuntimeException("Error number.");
        }
        switch (num2) {
            case 1:
                str2 = "one";
                break;
            case 2:
                str2 = "two";
                break;
            case 3:
                str2 = "three";
                break;
            case 4:
                str2 = "four";
                break;
            case 5:
                str2 = "five";
                break;
            case 6:
                str2 = "six";
                break;
            case 7:
                str2 = "seven";
                break;
            case 8:
                str2 = "eight";
                break;
            case 9:
                str2 = "nine";
                break;
            default:
                throw new RuntimeException("Error number.");
        }
        switch (operator) {
            case "+":
                answer = num1 + num2;
                if (num1 > 9 || num2 > 9) {
                    System.out.println("invalid number");
                } else {
                    System.out.println(str1 + " plus " + str2 + " is " + (answer));
                }
                break;
            case "-":
                answer = num1 - num2;
                if (num1 < 10 && num2 < 10) {
                    System.out.println(answer);
                } else {
                    System.out.println("invalid number");
                }
                break;
        }
        scanner.close();
    }
}

//錯誤訊息:Exception in thread "main" java.lang.Error: Unresolved compilation problems:
//The local variable str1 may not have been initialized
//The local variable str2 may not have been initialized
//說明:我希望輸入測資ex.1 5 + 時能夠output one plus five is 6
//但我對於如何將數字轉化成字串輸出不太了解，求教學
//.
