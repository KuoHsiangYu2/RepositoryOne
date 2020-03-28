#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include "utilFunction.h"

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	system("color f0");

	int side1 = 0;
	int side2 = 0;
	int side3 = 0;
	int temp[3];

	for (int i = 0; i < 3; i++) {
		//設定初始值
		temp[i] = 0;
	}

	while (TRUE) {

		printf("請輸入三角形三邊長度：");
		scanf("%d %d %d", &side1, &side2, &side3);

		if ((side1 == -1) || (side2 == -1) || (side3 == -1)) {
			//輸入-1退出迴圈
			break;
		}

		temp[0] = side1;
		temp[1] = side2;
		temp[2] = side3;

		//排序，由小排到大。
		sort(temp, 3);

		side1 = temp[0];
		side2 = temp[1];
		side3 = temp[2];

		if (side1 + side2 > side3) {
			//判斷三邊長是否能構成合法三角形

			int trianType = triangleType(side1, side2, side3);

			switch (trianType) {
			case 0:
				//銳角三角形
				showTriangle(side1, side2, side3);
				printf("#0 acute triangle銳角三角形\n");
				if (isRegularTriangle(side1, side2, side3)) {
					printf("regular triangle正三角形\n");
				}
				else if (isIsoscelesTriangle(side1, side2, side3)) {
					printf("Isosceles triangle等腰三角形\n");
				}
				else {
					//pass
				}
				break;

			case 1:
				//直角三角形
				showTriangle(side1, side2, side3);
				printf("#1 right triangle直角三角形\n");
				if (isIsoscelesTriangle(side1, side2, side3)) {
					printf("Isosceles triangle等腰三角形\n");
				}
				break;

			case 2:
				//鈍角三角形
				showTriangle(side1, side2, side3);
				printf("#2 obtuse triangle鈍角三角形\n");
				if (isIsoscelesTriangle(side1, side2, side3)) {
					printf("Isosceles triangle等腰三角形\n");
				}
				break;

			default:
				break;

			}
		}
		else {
			printf("can not be a triangle.三邊長無法形成三角形。\n");
		}

	}// end of while-loop

	printf("\n");
	system("pause");
	return 0;
}