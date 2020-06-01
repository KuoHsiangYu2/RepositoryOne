/*  
file encoding="UTF-8 with no BOM"
file name: FileInputTwo.java
Java jdk version: 1.8.0_171
Java jre version: 1.8.0_171
IDE: Eclipse IDE for Enterprise Java Developers
IDE version: 2019-03(4.11.0)
operating system: Windows 8.1
*/
package com.sample;

import java.io.File;
import java.util.Scanner;

public class FileInputTwo {
	public static void main(String[] args) {
		File file = null;
		Scanner scanner = null;
		String input = "";
		try {
			file = new File("data.txt");
			scanner = new Scanner(file, "big5");/* 設定讀取 big5編碼格式的文字檔案 */
			while (scanner.hasNext()) {
				input = scanner.nextLine();
				System.out.println(input);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
				scanner = null;
			}
		}
		System.out.println("finish");
	}// end of main method
}// end of FileInputTwo class
