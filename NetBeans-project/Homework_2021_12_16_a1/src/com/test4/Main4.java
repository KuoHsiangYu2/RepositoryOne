// https://www.facebook.com/groups/1403852566495675/posts/3061823734031875/
// https://www.facebook.com/permalink.php?story_fbid=1289089774931036&id=100014900775688
// https://www.youtube.com/watch?v=R4AjNBkPbF4
// https://www.runoob.com/java/java8-streams.html
// https://magiclen.org/java-8-lambda/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test4;

import static com.util.Output.printf;
import static com.util.Output.println;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author asus
 */
public class Main4 {

    private static int countKeyNum(Integer elementKey, List<Integer> list) {
        int count = 0;
        for (int element : list) {
            if (element == elementKey) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        println("#4 請輸入一連串介於1~50之整數資料(以0作為結束)：");
        Scanner scanner = new Scanner(System.in, "UTF-8");
        List<Integer> list = new ArrayList<Integer>();

        // 把使用者輸入的數字儲存進 list裡面，讀到0就停止輸入。.
        while (true == scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            } else if (num < 1 || num > 50) {
                // 只允許 1 ~ 50範圍的數字輸入，超出範圍的數字則略過不加進去。.
                continue;
            }
            list.add(num);
        }

        Map<Integer, Integer> numberFrequencyMap = new TreeMap<Integer, Integer>(
                (Integer i1, Integer i2) -> {
                    return (i1 - i2);
                });

        // Charge Lee
        // 我不知道你是不是用java8
        // Stream一口氣可以解決
        // 1：List input= [5,5,6,6,7,7....你的輸入]
        // 2：List distinct =input.stream.distinct
        // 3：distinct.foreach(x=>
        // print(x出現 input.where(y=>y==x).長度）次）
        // 第一行讓你輸入
        // 第二行distinct可以獨立出input的元素 不會重複
        // 第三行distinct跑for回圈 然後從原本的input過濾一樣的數字 然後算數量
        // 簡單來說java8 你不用再寫一堆for loop了
        // 學java dart c# 等高階語言
        // 就要學更進階的語法 for 其實用的次數會減少
        list.stream().distinct().forEach((Integer elementKey) -> {
            int elementValue = countKeyNum(elementKey, list);
            numberFrequencyMap.put(elementKey, elementValue);
        });

        numberFrequencyMap
                .entrySet()
                .forEach((entry) -> {
                    printf("%d 出現 %d 次%n", entry.getKey(), entry.getValue());
                });

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
