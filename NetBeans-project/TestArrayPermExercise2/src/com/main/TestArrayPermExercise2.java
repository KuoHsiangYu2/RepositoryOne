/*
line群組「Java 讀書會」
金元：
請教一下
{1, 2, 3, 4, 5} 單數時要排成 {2, 4, 5, 3, 1}，
最大的排中間，其次排佐再其次排右，依次排序 {1, 2, 3, 4, 5, 6} 
雙數時要排成 {1, 3, 5, 6, 4, 2} 
類似這種題型 思維方向要怎麼走
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.sort.BubbleSort;
import com.type.OrderType;
import static java.lang.System.out;

/**
 *
 * @author hsiang-yu
 */
public class TestArrayPermExercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] inputArray = new int[]{1, 2, 3, 4, 5};

        // 由大排到小
        BubbleSort.sort(inputArray, OrderType.DESC);

        // out.println(Arrays.toString(inputArray));
        int middlePoint = inputArray.length / 2;
        int leftPoint = middlePoint;
        int rightPoint = middlePoint;
        boolean isLeft = true;
        int[] result = new int[inputArray.length];
        result[middlePoint] = inputArray[0];
        for (int i = 1, len = result.length; i < len; i++) {
            if (true == isLeft) {
                // 從左邊插入
                leftPoint = leftPoint - 1;
                result[leftPoint] = inputArray[i];
            } else {
                // 從右邊插入
                rightPoint = rightPoint + 1;
                result[rightPoint] = inputArray[i];
            }
            isLeft = !isLeft;// true 變 false。false 變 true
        }

        // 最後印出結果
        int index = 0;
        int len2 = 0;
        for (index = 0, len2 = (result.length - 1); index < len2; index++) {
            out.print(result[index] + ", ");
        }
        out.println(result[index]);
    }// end of main method

}
