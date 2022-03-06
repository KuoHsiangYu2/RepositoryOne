package com.sample1;

import static java.lang.System.out;

public class TestStringReverse1 {

    public static void main(String[] args) {
        String inputStr = "123456789";

        /* 字串轉成 char[]陣列 */
        char[] inputArray = inputStr.toCharArray();

        /* 反轉字串： */
        /* 你把字串前面跟後面的字元依序對調就行了。 */

        int startIndex = 0; /* 前頭索引值 */
        int endIndex = inputArray.length - 1; /* 尾巴索引值 */
        while (startIndex < endIndex) {
            /* 三元交換，透過第三方暫存器變數，來對調 start索引 與 end索引 處的資料 */
            /* 前頭的資料 與 尾巴的資料 互相對調 */
            /* 陣列資料交換到陣列長度一半時即停止，並退出迴圈。 */
            char temp = inputArray[startIndex];
            inputArray[startIndex] = inputArray[endIndex];
            inputArray[endIndex] = temp;

            /* 更新 前頭索引值 */
            startIndex++;

            /* 更新 尾巴索引值 */
            endIndex--;
        }

        /* char[]陣列 重新轉換回 String字串 */
        String output = new String(inputArray);

        out.println(String.format("output = [%s]", output));
        out.println("finish");
    }

}
