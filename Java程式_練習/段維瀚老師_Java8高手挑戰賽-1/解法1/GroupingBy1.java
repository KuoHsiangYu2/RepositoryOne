/*
段維瀚
2020年5月22日
Java 8 高手挑戰賽動動腦時間
假設：
List<String> items = Arrays.asList("蘋果", "蘋果", "香蕉", "蘋果", "柳丁", "香蕉", "椰子");
如何撰寫一個根據數量作為key值得 groupingBy 群組程式，讓其分類結果變成一個 Map，其結果
如下：
{1=[柳丁, 椰子], 2=[香蕉], 3=[蘋果]}
歡迎將您的解答放在下方回應區
*/
package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class GroupingBy1 {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("蘋果", "蘋果", "香蕉", "蘋果", "柳丁", "香蕉", "椰子");

        // 統計每個字串出現次數的map.
        Map<String, Integer> itemsCount = new HashMap<String, Integer>();

        // 走訪整個items list.
        for (String element : items) {
            if (itemsCount.containsKey(element)) {
                // 如果是第n次設定key值，value值取出來加1，再設回去。.
                int num = itemsCount.get(element);
                num = num + 1;
                itemsCount.put(element, num);
            } else {
                // 如果是第一次設定key值，value初始值設定1。.
                itemsCount.put(element, 1);
            }
        }

        // out.println(itemsCount);

        // 以 items 出現次數為key值的map.
        Map<Integer, List<String>> resultMap = new HashMap<Integer, List<String>>();

        for (Map.Entry<String, Integer> element : itemsCount.entrySet()) {
            String icKey = element.getKey();
            int icValue = element.getValue();

            if (resultMap.containsKey(icValue)) {
                // 如果是第n次設入相同出現次數key值，就以原本的 List 為基底，繼續把 items往後加入。.
                List<String> groupingByValue = resultMap.get(icValue);
                groupingByValue.add(icKey);
                resultMap.put(icValue, groupingByValue);
            } else {
                // 如果是第一次設入出現次數為key值，就建立全新的 ArrayList 並把 items設定進去。.
                List<String> newArrayList = new ArrayList<String>();
                newArrayList.add(icKey);
                resultMap.put(icValue, newArrayList);
            }
        }

        out.println(resultMap);
    }

}

// https://www.trinea.cn/android/hashmap-loop-performance/
// https://dotblogs.com.tw/duke/2019/11/22/223546
// https://beginnersbook.com/2013/12/how-to-loop-hashmap-in-java/
