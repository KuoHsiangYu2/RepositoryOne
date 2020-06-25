// 原始題目
// https://www.facebook.com/permalink.php?story_fbid=2579423612321988&id=2242200042711015&__tn__=-R

package com.sample;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListToMap {

	public static void main(String[] args) {
		// 初始輸入 ArrayList
		List<String> items = Arrays.asList("蘋果", "蘋果", "香蕉", "蘋果", "柳丁", "香蕉", "椰子");

		// 第一個 HashMap【itemsMap】統計一個詞彙出現幾次
		Map<String, Integer> itemsMap = new HashMap<String, Integer>();

		for (int i = 0, length = items.size(); i < length; i++) {
			if (false == itemsMap.containsKey(items.get(i))) {
				// 如果是第一次出現的值，預設給他 1
				itemsMap.put(items.get(i), 1);
			} else {
				// 如果是已經儲存的值，取出 value + 1 後再設回去
				int n = itemsMap.get(items.get(i));
				n = n + 1;
				itemsMap.put(items.get(i), n);
			}
		}

		// 第二個 HashMap【itemsMapResult】 儲存 數字-字串
		Map<Integer, String> itemsMapResult = new HashMap<Integer, String>();

		Iterator<Map.Entry<String, Integer>> itemsMapIterator = itemsMap.entrySet().iterator();
		while (itemsMapIterator.hasNext()) {
			Map.Entry<String, Integer> entry = itemsMapIterator.next();
			if (false == itemsMapResult.containsKey(entry.getValue())) {
				// 如果是第一次出現的數字，塞 itemsMap 的 key值 給他。
				itemsMapResult.put(entry.getValue(), entry.getKey());
			} else {
				// 如果是第二次 ... 第n次出現的數字，依序",xxx,xxx"設值
				String resultValue = itemsMapResult.get(entry.getValue());
				resultValue = resultValue + "," + entry.getKey();
				itemsMapResult.put(entry.getValue(), resultValue);
			}
		}

		Iterator<Map.Entry<Integer, String>> itemsMapResultIterator = itemsMapResult.entrySet().iterator();
		while (itemsMapResultIterator.hasNext()) {
			Map.Entry<Integer, String> entry = itemsMapResultIterator.next();
			// 進行修飾把 value值前後加上[]中括號。
			String result = entry.getValue();
			itemsMapResult.put(entry.getKey(), "[" + result + "]");
		}

		// 最後印出結果
		out.println(itemsMapResult.toString());
	}

}
