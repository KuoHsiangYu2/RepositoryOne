package com.hsiangyu.test1;

import static java.lang.System.out;

public class PrintTriangle1 {
    public static void main(String[] args) {
        int maxHight = 5;
        for (int i = 1; i <= maxHight; ++i) {
            for (int j = 1; j <= (maxHight - i); ++j) {
                out.print(" "); /* 印空格 */
            }
            for (int k = 1; k <= i; ++k) {
                out.print("*"); /* 印星星 */
            }
            out.println(); /* 換下一行 */
        }
    }
}

// https://www.facebook.com/groups/108375436301355/posts/1557609164711301/
