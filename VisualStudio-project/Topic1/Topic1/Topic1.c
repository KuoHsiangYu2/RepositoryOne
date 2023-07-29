// https://www.facebook.com/groups/1403852566495675/posts/3496018010612443/
// 大嘎好！我是一個C語言的萌新！最近收到了一個新的題目：
// 隨機輸入10個數字，將這些數字由大排到小排列。
// 到底要怎麼用啊，我真的想不到！煩請各位大大提供想法！

#define _CRT_SECURE_NO_WARNINGS
#define TRUE 1
#define FALSE 0

#include <stdio.h>
#include <stdlib.h>

void sort(int data[], int length);
void reverse(int data[], int length);

int main(int argc, char *argv) {
    int data[10] = { 0 };

    // 隨機輸入10個數字.
    for (int i = 0; i < 10; ++i) {
        printf("%02d. ", (i + 1));
        scanf("%d", &data[i]);
    }

    // 將這些數字由小排到大排列.
    sort(data, 10);

    // 陣列反轉，變成由大排到小.
    reverse(data, 10);

    // 輸出結果.
    for (int i = 0; i < 10; ++i) {
        printf("%2d ", data[i]);
    }
    printf("\n");

    return 0;
}

void sort(int data[], int length) {
    int temp = 0;
    for (int i = 0; i < (length - 1); i++) {
        for (int j = i + 1; j < length; j++) {
            if (data[i] > data[j]) {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
    }
}

void reverse(int data[], int length) {
    int i = 0, temp = 0;
    for (i = 0; i < length / 2; i++) {
        temp = data[i];
        data[i] = data[length - 1 - i];
        data[length - 1 - i] = temp;
    }
}
