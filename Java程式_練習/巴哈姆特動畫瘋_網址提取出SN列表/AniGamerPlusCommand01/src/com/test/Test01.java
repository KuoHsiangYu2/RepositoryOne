package com.test;

public class Test01 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("12");
        sb.append("34");
        sb.append("56");
        int startNum = sb.length() - 1;
        int endNum = sb.length();
        sb.delete(startNum, endNum);
        System.out.println(sb.toString());
    }

}
