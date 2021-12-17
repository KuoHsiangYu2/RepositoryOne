// https://www.facebook.com/groups/1403852566495675/posts/3061823734031875/
// https://www.facebook.com/permalink.php?story_fbid=1289089774931036&id=100014900775688
// https://www.youtube.com/watch?v=R4AjNBkPbF4
// https://blog.csdn.net/lijingjingchn/article/details/103404417
// https://stackoverflow.com/questions/27867598/java-hashmap-put-in-an-enhanced-for-loop-just-like-an-arraylist/27867626
// https://howtodoinjava.com/java/sort/java-sort-map-by-key/
// https://www.callicoder.com/java-treemap/
// https://magiclen.org/java-8-lambda/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test3;

import static com.util.Output.printf;
import static com.util.Output.println;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author asus
 */
public class Main3 {

    public static void main(String[] args) {
        println("#3 請輸入一連串介於1~50之整數資料(以0作為結束)：");
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

        Map<Integer, Long> tempMap = (Map<Integer, Long>) list
                .stream()
                .collect(Collectors.groupingBy((Integer element) -> {
                    return element;
                }, Collectors.counting()));

        Map<Integer, Long> numberFrequencyMap = new TreeMap<Integer, Long>(
                (Integer i1, Integer i2) -> {
                    return (i1 - i2);
                });

        numberFrequencyMap.putAll(tempMap);

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
