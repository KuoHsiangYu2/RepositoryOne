// https://www.facebook.com/groups/1403852566495675/posts/3061823734031875/
// https://www.facebook.com/permalink.php?story_fbid=1289089774931036&id=100014900775688
// https://www.youtube.com/watch?v=R4AjNBkPbF4
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test2;

import static com.util.Output.printf;
import static com.util.Output.println;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author asus
 */
public class Main2 {

    public static void main(String[] args) {
        println("#2 請輸入一連串介於1~50之整數資料(以0作為結束)：");
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
        // println("list = " + list.toString());

        // 使用一個Map來儲存各個數字的出現頻率。.
        Map<Integer, Integer> numberFrequencyMap = new HashMap<Integer, Integer>();

        Iterator<Integer> iterator = list.iterator();
        while (true == iterator.hasNext()) {
            int num = iterator.next();
            if (false == numberFrequencyMap.containsKey(num)) {
                // 如果是第 1 次輸入該 key值 給 map ，就設定 value值 為 1。.
                numberFrequencyMap.put(num, 1);
            } else {
                // 第 2 次 第 n 次的值，則是先從 map裡面取出 對應 value舊值，更新後再+1設定回去。.
                int numFreqValue = numberFrequencyMap.get(num);
                numFreqValue = numFreqValue + 1;
                numberFrequencyMap.put(num, numFreqValue);
            }
        }

        Set<Integer> keySet = numberFrequencyMap.keySet();
        List<Integer> keySetList = new ArrayList<Integer>();
        keySet.forEach((elements) -> {
            keySetList.add(elements);
        });

        // 把 KeySet 取出來然後排序。
        keySetList.sort((Integer o1, Integer o2) -> {
            return (o1 - o2);
        });
        // println("keySetList = " + keySetList);

        for (int i = 0, len = keySetList.size(); i < len; i++) {
            int key = keySetList.get(i);
            printf("%d 出現 %d 次%n", key, numberFrequencyMap.get(key));
        }

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
