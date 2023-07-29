// https://www.facebook.com/groups/1403852566495675/posts/3496018010612443/
// 大嘎好！我是一個C語言的萌新！最近收到了一個新的題目：
// 隨機輸入10個數字，將這些數字由大排到小排列。
// 到底要怎麼用啊，我真的想不到！煩請各位大大提供想法！
package com.topic1;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Topic1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();

        // 隨機輸入10個數字.
        for (int i = 1; i <= 10; ++i) {
            out.printf("%02d. ", i);
            int n = scanner.nextInt();
            list.add(n);
        }

        // 將這些數字由大排到小排列.
        List<Integer> resultList = list.stream().sorted((Integer i1, Integer i2) -> {
            return (-1) * (i1 - i2);
        }).collect(Collectors.toList());

        out.println("輸出結果");
        out.println(resultList);

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

}
