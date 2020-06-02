package com.right.triangle;

public class TestTriangle {

	public static void main(String[] args) {
		int count = 5;// 設定三角形影印數目
		TestTriangle.drawTriangleOne(count);
		System.out.println();
		TestTriangle.drawTriangleTwo(count);
	}

	private static void drawTriangleTwo(int count) {
		/** 第二種直角三角形 */
		// 影印第二種三角形的關鍵就在於，
		// 左邊要加印空格，
		// 最上面一行空格數最多，
		// 在往下一行減少一個空格，其餘依此類推。
		for (int i = 1; i <= count; i++) {
			for (int j = (count - i); j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void drawTriangleOne(int count) {
		/** 第一種直角三角形 */
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
