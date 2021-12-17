// https://www.facebook.com/groups/1403852566495675/posts/3061823734031875/
// https://www.facebook.com/permalink.php?story_fbid=1289089774931036&id=100014900775688
// https://www.youtube.com/watch?v=R4AjNBkPbF4
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test1;

import static com.util.Output.printf;
import static com.util.Output.println;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Main1 {

    public static void main(String[] args) {
        println("#1 請輸入一連串介於1~50之整數資料(以0作為結束)：");
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

        // 使用一個陣列來儲存各個數字的出現頻率。.
        int[] numberFrequency = new int[51];
        for (int i = 0, len = numberFrequency.length; i < len; i++) {
            // 陣列初始化
            numberFrequency[i] = 0;
        }

        Iterator<Integer> iterator = list.iterator();
        while (true == iterator.hasNext()) {
            int num = iterator.next();
            numberFrequency[num] = numberFrequency[num] + 1;
        }

        for (int i = 0, len = numberFrequency.length; i < len; i++) {
            if (numberFrequency[i] != 0) {
                printf("%d 出現 %d 次%n", i, numberFrequency[i]);
            }
        }

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

}
// sample input
// 5 6 5 2 43 23 43 2 2 2 43 0

// sample output
// 2 出現 4 次
// 5 出現 2 次
// 6 出現 1 次
// 23 出現 1 次
// 43 出現 3 次