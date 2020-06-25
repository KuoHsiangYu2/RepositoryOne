// 原始題目
// https://www.facebook.com/permalink.php?story_fbid=2579423612321988&id=2242200042711015&__tn__=-R

// 參考資料
// https://www.itread01.com/content/1548600131.html
// https://mkyong.com/java8/java-8-convert-map-to-list/
// https://blog.csdn.net/HD243608836/article/details/85258565
// https://dotblogs.com.tw/duke/2019/11/22/223546

package com.sample2;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Fruit {
	private String name;
	private Long count;

	public Fruit() {
		super();
	}

	public Fruit(String name, Long count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
}

public class ListToMap2 {

	public static void main(String[] args) {
		// 初始輸入 ArrayList
		List<String> items = Arrays.asList("蘋果", "蘋果", "香蕉", "蘋果", "柳丁", "香蕉", "椰子");

		// 1. HashMap【itemsMap】統計一個詞彙出現幾次
		Map<String, Long> itemsMap = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// 2. List【fruitList】 儲存 字串-數字
		List<Fruit> fruitList = new ArrayList<Fruit>();
		itemsMap.forEach((keyName, valueCount) -> {
			fruitList.add(new Fruit(keyName, valueCount));
		});

		// 3. Map【resultMap】把 字串-數字 統計結果彙總
		Map<Long, List<String>> resultMap = fruitList.stream().collect(
				Collectors.groupingBy(Fruit::getCount, Collectors.mapping(Fruit::getName, Collectors.toList())));

		// 最後印出結果
		out.println(resultMap.toString());
	}

}
