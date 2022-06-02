package com.test.magic.code;

import static java.lang.System.out;

public class NumberAddingTest {

    public void output(byte v) {
        out.println("Byte value is " + v);
    }

    public void output(short v) {
        out.println("Short value is " + v);
    }

    public void output(Object v) {
        out.println("Object value is " + v);
    }

    public static void main(String[] args) {
        byte x = 14;
        short y = 13;
        new NumberAddingTest().output(x + y); // line 1
    }
}

// What is line 1 output?
// A. Short value is 27
// B. The compilation fails due to an error in line 1.
// C. Byte value is 27
// D. Object value is 27
