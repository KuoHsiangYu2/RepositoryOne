/* https://www.facebook.com/groups/108375436301355/posts/1240391066433114/ */
package com.util;

public class MaskName {

    public MaskName() {
        super();
    }

    public String getCustomerMaskName(String customerName) {
        String maskName = "";
        if (customerName == null) {
            return maskName;
        }

        int nameLength = customerName.length();
        char[] customerNameArray = customerName.toCharArray();
        if (nameLength <= 1) {
            maskName = customerName;
        } else if (nameLength == 2) {
            /* 1. 若顧客姓名為兩個字則隱碼第二個字 */
            customerNameArray[1] = 'X';
            maskName = new String(customerNameArray);
        } else {
            /* 2. 若顧客姓名為三個字則隱碼第二個字 */
            /* 3. 若顧客姓名為四個字則隱碼第二、第三個字 */
            /* 4. 若為四個字以上則一律隱碼中間的所有的字 */
            int startIndex = 1;
            int endIndex = nameLength - 1;
            for (int i = startIndex; i < endIndex; i++) {
                customerNameArray[i] = 'X';
            }
            maskName = new String(customerNameArray);
        }

        return maskName;
    }
}
