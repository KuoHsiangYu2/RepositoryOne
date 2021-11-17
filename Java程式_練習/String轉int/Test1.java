package com.test1;

public class Test1 {
    private static int myPow(int base, int pow) {
        int result = 1;
        for (int i = 1; i <= pow; i++) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "123";

        // 把字串拆解成一個一個字元 
        char[] charArray = new char[str1.length()];
        for (int i = 0; i < str1.length(); i++) {
            charArray[i] = str1.charAt(i);
        }
        int sum = 0;
        for (int i = (str1.length() - 1), pow = 0; i >= 0; i--, pow++) {
            int n = (int) (charArray[i] - '0');
            n = n * myPow(10, pow);
            sum = sum + n;
        }
        System.out.printf("sum = %d%n", sum); // sum = 123
    }

}
