/*  
file encoding="UTF-8 with no BOM"
file name: ConsoleInputOne.java
Java jdk version: 1.8.0_171
Java jre version: 1.8.0_171
IDE: Eclipse IDE for Enterprise Java Developers
IDE version: 2019-03(4.11.0)
operating system: Windows 8.1
*/

package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ConsoleInputOne {
	public static void main(String[] args) {
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		String input = "";
		try {
			inputStreamReader = new InputStreamReader(System.in, "UTF-8");// 從這邊設定讀取的編碼格式
			bufferedReader = new BufferedReader(inputStreamReader);
			System.out.print("Please enter a sentence: ");
			input = bufferedReader.readLine();// 接收使用者從鍵盤輸入進Java程式的資料
			System.out.println("Output = " + input);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();// 關閉串流
					bufferedReader = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();// 關閉串流
					inputStreamReader = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("finish");
	}// end of main method
}// end of ConsoleInputOne class