package com.diamond;

public class TestDiamond {

	public static void main(String[] args) {
		int count = 5;
		TestDiamond.drawDiamond(count);
	}

	private static void drawDiamond(int count) {
		// 印菱形的上半身-start
		for (int i = 1; i <= count; i++) {
			for (int j = (count - i); j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		// 印菱形的上半身-end

		// 印菱形的下半身-start
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = (count - i); j >= 1; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		// 印菱形的下半身-end
	}

}
