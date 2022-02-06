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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class GroupingBy2 {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("蘋果", "蘋果", "香蕉", "蘋果", "柳丁", "香蕉", "椰子");

        // 先把每個 item元素 出現過幾次統合成一個map。.
        Map<String, Long> itemsCountMap = items
                .stream()
                .collect(Collectors.groupingBy((String elementKey) -> {
                    return elementKey;
                }, Collectors.counting()));

        // out.println(itemsCountMap);

        // 從 itemsCountMap的key組裝到 groupingByMap的value。.
        // itemsCountMap的value組裝到 groupingByMap的key。.
        Map<Long, List<String>> groupingByMap = itemsCountMap
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        out.println(groupingByMap);
    }

}

// https://www.trinea.cn/android/hashmap-loop-performance/
// https://dotblogs.com.tw/duke/2019/11/22/223546
// https://beginnersbook.com/2013/12/how-to-loop-hashmap-in-java/
// https://www.baeldung.com/java-list-to-map
// https://stackoverflow.com/questions/505928/how-to-count-the-number-of-occurrences-of-an-element-in-a-list
// https://stackoverflow.com/questions/63160228/java-transform-arraylist-of-type-object-to-another-arraylist-of-type-object
// https://www.techiedelight.com/transform-hashmap-java-8/
// https://stackoverflow.com/questions/63160228/java-transform-arraylist-of-type-object-to-another-arraylist-of-type-object
// https://www.baeldung.com/java-groupingby-collector
// https://www.1ju.org/java-streams/java-groupingby-collector
// https://www.techiedelight.com/transform-hashmap-java-8/
// https://stackoverflow.com/questions/53986939/collectors-groupby-for-mapstring-liststring
// https://vimsky.com/zh-tw/examples/usage/collectors-groupingby-method-in-java-with-examples.html
// https://www.796t.com/article.php?id=86126
// https://www.techiedelight.com/transform-hashmap-java-8/
