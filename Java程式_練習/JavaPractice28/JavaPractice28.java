// package com.test2;

import static java.lang.System.out;

import java.util.Scanner;

public class JavaPractice28 {

    private static boolean isInRange(int inputNum) {
        /* 判斷數字是否在 9 ~ 15 之間 */
        if (9 <= inputNum && inputNum <= 15) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean idOddNum(int inputNum) {
        /* 判斷是不是 奇數 */
        if ((inputNum % 2) == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean shouldPrintSpace(int row, int column, int inputNum) {
        /* 這個函式判斷是否要印出空格，只要超過 中間row以下的列數，以每往下一列就多顯示一個數字的邏輯來做判斷。 */
        /* 從中間列數往下一列顯示 左邊1個數字 跟 右邊1個數字 */
        /* 從中間列數往下二列顯示 左邊2個數字 跟 右邊2個數字，其餘依此類推 */
        /* true 應該印出空格 */
        /* false 應該印出乘法表數字 */

        int mid = (inputNum + 1) / 2;
        boolean isOutRangeMidRow = (row >= mid);
        boolean isStartCol = (column > (row - mid));
        boolean isEndCol = (column < (inputNum - (row - mid) + 1));

        return (isOutRangeMidRow && isStartCol && isEndCol);
    }

    public static void main(String[] args) {
        /* jdk 11 */

        Scanner scanner = new Scanner(System.in);
        int inputNum = 0;

        while (true) {
            /* 讓使用者輸入一個介於 9 ~ 15 之間的奇數， */
            /* 若不符合規則，便反覆詢問直到正確為止。 */
            out.print("請輸入一個9~15之間的奇數(n)：");
            inputNum = scanner.nextInt();
            if (isInRange(inputNum) && idOddNum(inputNum)) {
                break;
            }
            out.printf("你輸入了 %d - 輸入錯誤%n", inputNum);
        }

        /* 印出乘法表表頭 */
        out.printf("%4s", "");
        for (int i = 1; i <= inputNum; i++) {
            out.printf("%4d", i);
        }
        out.println();

        /* 印出乘法表表身 */
        for (int row = 1; row <= inputNum; row++) {
            out.printf("%4d", row);
            for (int column = 1; column <= inputNum; column++) {
                if (shouldPrintSpace(row, column, inputNum)) {
                    out.printf("%4s", "");
                } else {
                    out.printf("%4d", (row * column));
                }
            }
            out.println();
        }

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

}
