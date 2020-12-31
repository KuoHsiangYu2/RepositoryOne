/*
題目：印出九九乘法表
*/

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    int i = 0;
    int j = 0;
    for (i = 1; i <= 9; i++) {
        for (j = 2; j <= 9; j++) {
            printf("%d*%d=%-2d ", j, i, (j * i));
        }
        printf("\n");
    }
    printf("\n");
    return 0;
}
