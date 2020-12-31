#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

double recursive(int);

int main(int argc, char *argv[]) {
    int n = 4;
    printf("%f\n", recursive(n));
    return 0;
}

double recursive(int n) {
    if (n == 1) {
        /* f(1) = 1 */
        return 1.0;
    }
    else if (n == 2) {
        /* f(2) = 2 */
        return 2.0;
    }
    else if (n == 3) {
        /* f(3) = 3 */
        return 3.0;
    }
    else {
        /* f(n) = 0.5 * f(n - 1) + 0.3 * f(n - 2) + 0.2 * f(n - 3) */
        return 0.5 * recursive(n - 1) + 0.3 * recursive(n - 2) + 0.2 * recursive(n - 3);
    }
}