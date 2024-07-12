package com.test01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        // jdk version 17.0.2
        // jre version 17.0.2
        // Class<GreetingAndBye> GreetingAndByeClass = GreetingAndBye.class;

        Method[] methodArray = GreetingAndBye.class.getDeclaredMethods();
        for (Method method : methodArray) {
            // 顯示權限修飾，像是public、protected、private
            System.out.println("$1 getModifiers = " + Modifier.toString(method.getModifiers()));

            // 顯示返回值型態名稱
            System.out.println("$1.2 getReturnType().getName() = " + method.getReturnType().getName());

            // 顯示方法名稱
            System.out.println("$1.3 getName() = " + method.getName() + ";");

            method.setAccessible(true);
            if ("goodBye".equals(method.getName())) {
                System.out.println("123321");
                String result = (String) method.invoke(null, "Eric10");
                System.out.println("result");
                System.out.println(result);
            }
        }

        Class<GreetingAndBye> GreetingAndByeClass = GreetingAndBye.class;
        //Method method = GreetingAndByeClass.getMethod("goodBye", String.class);
        Method method = GreetingAndByeClass.getMethod("greeting", String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, "Eric3");
        System.out.println("result");
        System.out.println(result);

        System.out.println("------------------------------");

        GreetingAndBye obj1 = new GreetingAndBye();
        Method test04Method = GreetingAndBye.class.getMethod("test04", String.class);
        test04Method.invoke(obj1, "obj-123");
    }

}
