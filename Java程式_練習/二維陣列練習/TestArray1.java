package com.sample;

public class TestArray1 {
    public static void main(String[] args) {
        int array[][] = new int[][] {
                { 1, 50, 60, 70, 0, 0, 0 },
                { 2, 30, 40, 50, 0, 0, 0 },
                { 3, 70, 80, 90, 0, 0, 0 },
                { 4, 66, 77, 88, 0, 0, 0 },
                { 5, 22, 33, 44, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 }
        };

        System.out.println("先執行數列加總的動作-start");
        for (int i = 0; i <= 4; i++) {
            for (int j = 1; j <= 5; j++) {
                /* 先執行數列加總的動作。 */
                /* 第1行 = [50 + 30 + 70 + 66 + 22] */
                System.out.printf("array[5][%d] = array[5][%d] + array[%d][%d];%n", j, j, i, j);
                array[5][j] = array[5][j] + array[i][j];
            }
        }
        System.out.println("先執行數列加總的動作-end");

        for (int i = 1; i <= 5; i++) {
            /* 再把加總的數字除以5 */
            array[5][i] = array[5][i] / 5;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%02d, ", array[i][j]);
            }
            System.out.println();
        }
    }
}

/*
原始題目來源：
https://www.facebook.com/groups/1403852566495675/permalink/2836612329886351/

Sample Input: 
01, 50, 60, 70, 00, 00, 00, 
02, 30, 40, 50, 00, 00, 00, 
03, 70, 80, 90, 00, 00, 00, 
04, 66, 77, 88, 00, 00, 00, 
05, 22, 33, 44, 00, 00, 00, 
00, 00, 00, 00, 00, 00, 00, 

Sample Output: 
01, 50, 60, 70, 00, 00, 00, 
02, 30, 40, 50, 00, 00, 00, 
03, 70, 80, 90, 00, 00, 00, 
04, 66, 77, 88, 00, 00, 00, 
05, 22, 33, 44, 00, 00, 00, 
00, 47, 58, 68, 00, 00, 00, 

預期結果：
讓二維陣列 第 1 行 ~ 第 5 行 加總，
加總列數為 第 0 列 ~ 第 4 列。
array[5][1] = (array[0][1] + array[1][1] + array[2][1] + array[3][1] + array[4][1]) ÷ 5
其餘依此類推。
*/
