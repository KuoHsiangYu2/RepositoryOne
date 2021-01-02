// 說明 Java多型語法
package com.sample;

import static java.lang.System.out;

//Super class
//父類別
class Cat {
	public void eat() {
		out.println("Cat eat");
	}
}

//Sub class
//子類別
class Tiger extends Cat {
	public void run() {
		out.println("Tiger run");
	}
}

public class TestPolymorphism {
	public static void main(String[] args) {
		Cat cat = new Tiger();
		cat.eat();
		// cat.run();// compilation error、編譯時期發生錯誤
		
		//強制向下轉型，
		//現在cat物件是以Tiger的視野在操作，所以才能使用 Tiger類別 定義的run() method
		((Tiger) cat).run();
	}
}

/*
Tony Lee
1 小時
抱歉，我想問一個有點基本的問題

Monster monster=new Slime();

那monster 是Slime還是monster ?
https://www.facebook.com/groups/1403852566495675/permalink/2347153172165605/
*/