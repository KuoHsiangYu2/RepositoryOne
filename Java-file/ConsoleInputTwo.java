/*  
file encoding="UTF-8 with no BOM"
file name: ConsoleInputTwo.java
Java jdk version: 1.8.0_171
Java jre version: 1.8.0_171
IDE: Eclipse IDE for Enterprise Java Developers
IDE version: 2019-03(4.11.0)
operating system: Windows 8.1
*/

package com.sample;

import java.util.Scanner;

public class ConsoleInputTwo {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in, "UTF-8");/* 設定編碼格式，這樣使用者用鍵盤輸入進去的中文字才不會變成亂碼 */
			String input = "";
			System.out.print("Please enter a sentence: ");
			input = scanner.next();
			System.out.println("Output = " + input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();// 關閉串流
				scanner = null;
			}
		}
		System.out.println("finish");
	}// end of main method
}// end of ConsoleInputTwo class
