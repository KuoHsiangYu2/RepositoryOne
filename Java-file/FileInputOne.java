/*  
file encoding="UTF-8 with no BOM"
file name: FileInputOne.java
Java jdk version: 1.8.0_171
Java jre version: 1.8.0_171
IDE: Eclipse IDE for Enterprise Java Developers
IDE version: 2019-03(4.11.0)
operating system: Windows 8.1
*/
package com.sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileInputOne {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		String input = "";
		try {
			fileInputStream = new FileInputStream("data.txt");
			
			/* 設定讀取 big5編碼格式的文字檔案 */
			/* 如果沒設編碼，讀出來的繁體中文字會變成亂碼。 */
			inputStreamReader = new InputStreamReader(fileInputStream, "big5");
			
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((input = bufferedReader.readLine()) != null) {
				System.out.println(input);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
			if (fileInputStream != null) {
				try {
					fileInputStream.close();// 關閉串流
					fileInputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("finish");
	}// end of main method
}// end of FileInputOne class
