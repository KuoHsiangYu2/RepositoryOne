/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.method;

import static java.lang.System.out;

/**
 *
 * @author acer
 */
public class Division implements IMethod {

    @Override
    public int caculate(int a, int b) {
        out.println("執行除法運算");
        int ans = a / b;
        return ans;
    }

}
