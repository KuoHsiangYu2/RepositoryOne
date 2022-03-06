package com.sample2;

import static java.lang.System.out;

public class TestStringReverse2 {

    public static void main(String[] args) {
        String inputStr = "123456789";

        /* 字串轉成 char[]陣列 */
        char[] inputArray = inputStr.toCharArray();

        int strLength = inputArray.length;

        /* 宣告第二個陣列用來儲存逆轉後的資料 */
        char[] outputArray = new char[strLength];

        for (int input = (strLength - 1), output = 0; input >= 0; input--, output++) {
            /* input值 依序從字串尾巴跑到前頭 */
            /* output值 依序從字串前頭跑到尾巴 */

            /* 換句話說就是從 輸入字元陣列 尾巴走訪到前頭， */
            /* 一邊走訪，一邊把字元一個一個儲存進新的 outputArray[]陣列 裡。 */
            outputArray[output] = inputArray[input];
        }

        /* char[]陣列 重新轉換回 String字串 */
        String output = new String(outputArray);

        out.println(String.format("output = [%s]", output));
        out.println("finish");
    }

}
