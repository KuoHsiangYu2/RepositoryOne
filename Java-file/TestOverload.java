package com.overload;

import static java.lang.System.out;

public class TestOverload {

	public static void main(String[] args) {
		int a1 = 10;
		int a2 = 24;
		int sum1 = 0;
		sum1 = addNumber(a1, a2);
		out.printf("%d + %d = %d%n", a1, a2, sum1);

		float b1 = 10.2F;
		float b2 = 34.5F;
		float sum2 = 0.0F;
		sum2 = addNumber(b1, b2);
		out.printf("%.2f + %.2f = %.2f%n", b1, b2, sum2);

		double c1 = 12.4;
		double c2 = 45.6;
		double sum3 = 0.0;
		sum3 = addNumber(c1, c2);
		out.printf("%.2f + %.2f = %.2f%n", c1, c2, sum3);

		String d1 = "12";
		String d2 = "45";
		String sum4 = "";
		sum4 = addNumber(d1, d2);
		out.printf("%s + %s = %s%n", d1, d2, sum4);
	}

	private static String addNumber(String d1, String d2) {
		String sumStr = "";
		int i1 = 0;
		int i2 = 0;
		int sumInt = 0;
		try {
			i1 = Integer.parseInt(d1);
			i2 = Integer.parseInt(d2);
			sumInt = i1 + i2;
			sumStr = String.valueOf(sumInt);
		} catch (Throwable e) {
			out.println(e);
		}
		return sumStr;
	}

	private static double addNumber(double c1, double c2) {
		double sum = 0.0;
		sum = c1 + c2;
		return sum;
	}

	private static float addNumber(float b1, float b2) {
		float sum = 0.0F;
		sum = b1 + b2;
		return sum;
	}

	private static int addNumber(int a1, int a2) {
		int sum = 0;
		sum = a1 + a2;
		return sum;
	}

}
