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
package com.sample;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hsiang-yu
 */
public class TestArrayPermExercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] inputArray = new int[]{1, 2, 3, 4, 5};

        Integer[] integerArray = new Integer[inputArray.length];

        for (int i = 0, len = inputArray.length; i < len; i++) {
            integerArray[i] = Integer.valueOf(inputArray[i]);
        }

        // 由大排到小
        Arrays.sort(integerArray, (x, y) -> {
            return -(x - y);
        });

        // out.println(Arrays.toString(integerArray));
        List<Integer> result = new ArrayList<Integer>();
        boolean isLeft = true;
        result.add(integerArray[0]);// 先插入中間的最大值
        for (int i = 1, len = integerArray.length; i < len; i++) {
            if (true == isLeft) {
                // 從前面插入
                result.add(0, integerArray[i]);
            } else {
                // 從後面插入
                result.add(integerArray[i]);
            }
            isLeft = !isLeft;// true 變 false。false 變 true
        }

        // 最後印出結果
        out.println(result.toString());
    }// end of main method

}
