/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import com.method.Addition;
import com.method.Division;
import com.method.IMethod;
import com.method.Multiplication;
import com.method.Subtraction;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author acer
 */
public class Main {

    private static Map<String, IMethod> methodMap = new HashMap<String, IMethod>();

    static {
        methodMap.put("add", new Addition());//加法
        methodMap.put("sub", new Subtraction());//減法
        methodMap.put("multi", new Multiplication());//乘法
        methodMap.put("div", new Division());//除法
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 透過不同的 key值 去呼叫相對應的 函式
        out.println("1 + 6 = " + calc("add", 1, 6));
        out.println("6 - 2 = " + calc("sub", 6, 2));
        out.println("2 * 5 = " + calc("multi", 2, 5));
        out.println("10 / 5 = " + calc("div", 10, 5));
    }

    private static int calc(String methodType, int a, int b) {
        IMethod method = methodMap.get(methodType);
        if (method != null) {
            return method.caculate(a, b);
        } else {
            String result = "error methodType : [" + methodType + "]";
            throw new RuntimeException(result);
        }
    }

}
