package com.util;

import java.io.PrintStream;
import java.util.Locale;

public class Output {
    public Output() {
        super();
    }

    public static void print(boolean b) {
        System.out.print(b);
    }

    public static void print(char c) {
        System.out.print(c);
    }

    public static void print(int i) {
        System.out.print(i);
    }

    public static void print(long l) {
        System.out.print(l);
    }

    public static void print(float f) {
        System.out.print(f);
    }

    public static void print(double d) {
        System.out.print(d);
    }

    public static void print(char charArray[]) {
        System.out.print(charArray);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(boolean b) {
        System.out.println(b);
    }

    public static void println(char c) {
        System.out.println(c);
    }

    public static void println(int i) {
        System.out.println(i);
    }

    public static void println(long l) {
        System.out.println(l);
    }

    public static void println(float f) {
        System.out.println(f);
    }

    public static void println(double d) {
        System.out.println(d);
    }

    public static void println(char charArray[]) {
        System.out.println(charArray);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }

    public static PrintStream printf(Locale locale, String format, Object... args) {
        return System.out.printf(locale, format, args);
    }
}
