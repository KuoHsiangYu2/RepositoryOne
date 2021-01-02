/*  
file encoding="UTF-8 with no BOM"
file name: FileOutputOne2.java
Java jdk version: 1.8.0_171
Java jre version: 1.8.0_171
IDE: Eclipse IDE for Enterprise Java Developers
IDE version: 2019-03(4.11.0)
operating system: Windows 8.1
*/
package com.sample;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileOutputOne2 {
	public static void main(String[] args) {
		System.out.println("start");
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			/* 如果沒有 data.txt檔案，就自動建立data.txt檔案，如果有 data.txt檔案，程式執行時的輸出的資料會從檔案內容結尾處繼續新增，不會覆蓋掉檔案原始資料。 */
			fileOutputStream = new FileOutputStream("data.txt", true);
			
			/* 設定輸出的檔案編碼格式為big5 */
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "big5");
			
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedWriter.write("line one");
			bufferedWriter.newLine();
			bufferedWriter.write("第二行");
			bufferedWriter.newLine();
			bufferedWriter.write("line three");
			bufferedWriter.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();// 關閉串流
					bufferedWriter = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStreamWriter != null) {
				try {
					outputStreamWriter.close();// 關閉串流
					outputStreamWriter = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();// 關閉串流
					fileOutputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // end of finally
		System.out.println("finish");
	}// end of main method
}// end of FileOutputOne2 class
