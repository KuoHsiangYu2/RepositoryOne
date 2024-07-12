package com.test01;

public class GreetingAndBye {

    public static String greeting(String name) {
        return String.format("Hey %s, nice to meet you!", name);
    }

    private static String goodBye(String name) {
        return String.format("[xxx] Bye %s, see you next time.", name);
    }

    public String test03(String name) {
        return String.format("Bye %s, see you next time.", name);
    }

    public void test04(String name) {
        String test04 = String.format("Bye %s, see you next time.", name);
        System.out.println("test04");
        System.out.println(test04);
        System.out.println();
    }

}
