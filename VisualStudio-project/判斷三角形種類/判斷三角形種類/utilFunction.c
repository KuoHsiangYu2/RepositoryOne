#include <stdio.h>
#include <stdlib.h>
#include "utilFunction.h"

int power(int base, int pow) {
	//計算數字次方函數
	//base 底數
	//pow 次方 
	int sum = 1;
	for (int i = 1; i <= pow; i++) {
		sum = sum * base;
	}
	return sum;
}

void sort(int *array, int length) {
	// 實作氣泡排序法的函數
	int flag = FALSE;
	for (int i = 0; i < length - 1; i++) {
		flag = FALSE;
		for (int j = 0; j < length - i - 1; j++) {
			// > 是由小排到大
			// < 是由大排到小
			if (array[j] > array[j + 1]) {
				flag = TRUE;
				int temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
		if (FALSE == flag) {
			break;
		}
	}
}

int triangleType(int side1, int side2, int side3) {
	//判斷三角形是[銳角三角形][直角三角形][鈍角三角形]
	if ((power(side1, 2) + power(side2, 2)) > power(side3, 2)) {
		//#0 銳角三角形
		return 0;
	}
	else if ((power(side1, 2) + power(side2, 2)) == power(side3, 2)) {
		//#1 直角三角形
		return 1;
	}
	else {
		//#2 鈍角三角形
		return 2;
	}
}

void showTriangle(int side1, int side2, int side3) {
	//影印三角形資料
	printf("%d %d %d can form a triangle三邊長可以構成三角形\n", side1, side2, side3);
}

int isIsoscelesTriangle(int side1, int side2, int side3) {
	//是否是等腰三角形
	if ((side1 == side2) || (side2 == side3) || (side3 == side1)) {
		return TRUE;
	}
	else {
		return FALSE;
	}
}

int isRegularTriangle(int side1, int side2, int side3) {
	//是否是正三角形
	if ((side1 == side2) && (side2 == side3) && (side3 == side1)) {
		return TRUE;
	}
	else {
		return FALSE;
	}
}