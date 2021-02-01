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
        for (int row = 0; row <= 4; row++) {
            for (int column = 1; column <= 5; column++) {
                /* 先執行數列加總的動作。 */
                /* 第1行 = [50 + 30 + 70 + 66 + 22] */
                System.out.printf("array[5][%d] = array[5][%d] + array[%d][%d];%n", column, column, row, column);
                array[5][column] = array[5][column] + array[row][column];
            }
        }
        System.out.println("先執行數列加總的動作-end");

        for (int column = 1; column <= 5; column++) {
            /* 再把加總的數字除以5 */
            array[5][column] = array[5][column] / 5;
        }
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.printf("%02d, ", array[row][column]);
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

程式執行結果：
先執行數列加總的動作-start
array[5][1] = array[5][1] + array[0][1];
array[5][2] = array[5][2] + array[0][2];
array[5][3] = array[5][3] + array[0][3];
array[5][4] = array[5][4] + array[0][4];
array[5][5] = array[5][5] + array[0][5];
array[5][1] = array[5][1] + array[1][1];
array[5][2] = array[5][2] + array[1][2];
array[5][3] = array[5][3] + array[1][3];
array[5][4] = array[5][4] + array[1][4];
array[5][5] = array[5][5] + array[1][5];
array[5][1] = array[5][1] + array[2][1];
array[5][2] = array[5][2] + array[2][2];
array[5][3] = array[5][3] + array[2][3];
array[5][4] = array[5][4] + array[2][4];
array[5][5] = array[5][5] + array[2][5];
array[5][1] = array[5][1] + array[3][1];
array[5][2] = array[5][2] + array[3][2];
array[5][3] = array[5][3] + array[3][3];
array[5][4] = array[5][4] + array[3][4];
array[5][5] = array[5][5] + array[3][5];
array[5][1] = array[5][1] + array[4][1];
array[5][2] = array[5][2] + array[4][2];
array[5][3] = array[5][3] + array[4][3];
array[5][4] = array[5][4] + array[4][4];
array[5][5] = array[5][5] + array[4][5];
先執行數列加總的動作-end
01, 50, 60, 70, 00, 00, 00, 
02, 30, 40, 50, 00, 00, 00, 
03, 70, 80, 90, 00, 00, 00, 
04, 66, 77, 88, 00, 00, 00, 
05, 22, 33, 44, 00, 00, 00, 
00, 47, 58, 68, 00, 00, 00, 

程式執行環境：
電腦作業系統：Windows 10 家用版
CPU：Intel(R) Core(TM) i5-8400 CPU @ 2.80GHz   2.81 GHz
RAM：12.0 GB
IDE：Eclipse IDE for Enterprise Java Developers 2020-09 (4.17.0)
jdk version：1.8.0_162
jre version：1.8.0_162
*/
