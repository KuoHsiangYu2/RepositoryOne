/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sort;

import com.type.OrderType;

/**
 *
 * @author hsiang-yu
 */
public class BubbleSort {

    public static void sort(int[] inputArray, OrderType orderType) {
        int length = inputArray.length;
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < length - 1; i++) {
            flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    flag = true;
                    temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
            }
            if (flag == false) {
                break;
            }
        }

        if (orderType == OrderType.ASC) {
            // 如果是 ASC 從小排到大，
            // 程式執行到這邊就結束。
            return;
        }

        // 如果是 DESC
        int startPoint = 0;
        int endPoint = length - 1;
        // 陣列逆轉
        while (startPoint < endPoint) {
            temp = inputArray[startPoint];
            inputArray[startPoint] = inputArray[endPoint];
            inputArray[endPoint] = temp;
            startPoint = startPoint + 1;
            endPoint = endPoint - 1;
        }
    }// end of sort method
}
