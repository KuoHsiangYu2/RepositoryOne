package com.stream.test;

import static java.lang.System.out;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {
        List<String> result = Stream.of("1", "2-", "3--", "4---", "5----")
            .peek((String v) -> out.println("p1 : " + v))
            .filter((String v) -> v.length() > 2)
            .peek((String v) -> out.println("p2 : " + v))
            .collect(Collectors.toList());
        out.println("result : " + result);
        out.println("finish3");
    }

}
