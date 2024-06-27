package com.testloop;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class Example1 {

    public Example1() {
        super();
    }

    public static void main(String[] args) {
        // 給 林春志 寫的範例.
        // 傳統 for迴圈 去處理東西。.
        /* banana 替換成 x */
        List<String> testList = new ArrayList<String>();
        testList.add("apple");
        testList.add("banana");
        testList.add("kiwi");
        testList.add("orange");
        testList.add("guava");

        List<String> testList02 = new ArrayList<String>();
        for (int i = 0; i < testList.size(); i++) {
            String temp = testList.get(i);
            if ("banana".equals(temp)) {
                testList02.add("x");
            } else {
                testList02.add(temp);
            }
        }

        out.println(testList02.toString());
        out.println("finish");
    }

}
