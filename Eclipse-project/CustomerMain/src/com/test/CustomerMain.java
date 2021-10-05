/* https://www.facebook.com/groups/108375436301355/posts/1240391066433114/ */
package com.test;

import static java.lang.System.out;

import com.util.MaskName;

public class CustomerMain {

    public CustomerMain() {
        super();
    }

    public static void main(String[] args) {
        MaskName maskName = new MaskName();
        out.println(maskName.getCustomerMaskName("關羽")); /* 關X */
        out.println(maskName.getCustomerMaskName("關雲長")); /* 關X長 */
        out.println(maskName.getCustomerMaskName("歐陽菲菲")); /* 歐XX菲 */
        out.println(maskName.getCustomerMaskName("常山趙子龍")); /* 常XXX龍 */
    }

}
