package com.testloop;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {

    public Example2() {
        super();
    }

    public static void main(String[] args) {
        // 使用 Stream API 去處理東西。.
        /* banana 替換成 x */
        List<String> testList = new ArrayList<String>();
        testList.add("apple");
        testList.add("banana");
        testList.add("kiwi");
        testList.add("orange");
        testList.add("guava");

        List<String> testList02 = testList.stream().map((String element) -> {
            if ("banana".equals(element)) {
                return "x";
            } else {
                return element;
            }
        }).collect(Collectors.toCollection(ArrayList::new));

        out.println(testList02.toString());
        out.println("finish");
    }

}
