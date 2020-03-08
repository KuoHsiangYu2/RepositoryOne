#define PI 3.14159265358979323846

#include <iostream>
#include <cmath>

using namespace std;

class Calculation {
public:

	int getCubeVolume(int sideLength) {
		//A. 輸入1個非零值時，計算正方體體積(邊長×邊長×邊長)
		int answer = 0;
		// pow(2, 4); 代表計算 2 的 4次方。
		answer = (int)pow(sideLength, 3);
		return answer;
	}

	int getCylinderVolume(int radius, int height) {
		//B.輸入2個非零值時，計算圓柱體體積(半徑×半徑×3.14×高)
		int answer = 0;
		answer = (int)pow(radius, 2) * (int)PI * height;
		return answer;
	}

	int getCuboidVolume(int length, int width, int height) {
		//C. 輸入3個非零值時，計算長方體體積(長×寬×高)
		int answer = 0;
		answer = length * width * height;
		return answer;
	}
};

int main(int argc, char *argv[]) {
	int num1 = 0;
	int num2 = 0;
	int num3 = 0;
	Calculation calculation;

	cout << "請輸入三個數：";
	cin >> num1 >> num2 >> num3;

	if (num1 != 0 && num2 == 0 && num3 == 0) {
		//A. 輸入1個非零值時，計算正方體體積(邊長×邊長×邊長)
		cout << "正方體體積：" << calculation.getCubeVolume(num1) << endl;
	}
	if (num1 != 0 && num2 != 0 && num3 == 0) {
		//B.輸入2個非零值時，計算圓柱體體積(半徑×半徑×3.14×高)
		cout << "圓柱體體積：" << calculation.getCylinderVolume(num1, num2) << endl;
	}
	if (num1 != 0 && num2 != 0 && num3 != 0) {
		//C. 輸入3個非零值時，計算長方體體積(長×寬×高)
		cout << "長方體體積：" << calculation.getCuboidVolume(num1, num2, num3) << endl;
	}

	return 0;
}

/*
張益誠
1 小時
抱歉又來問問題

最近剛在上手C++，屬於完全新手的狀態

需要撰寫主程式並帶有三個多載函數，內容包含:

A. 輸入1個非零值時，計算正方體體積(邊長×邊長×邊長)

B. 輸入2個非零值時，計算圓柱體體積(半徑×半徑×3.14×高)

C. 輸入3個非零值時，計算長方體體積(長×寬×高)

由於手邊正好沒有C++的開發軟體，寫出來的程式碼不知道為什麼丟到線上編譯器時顯示錯誤。

想問各位前輩我有哪邊寫錯了QQ

(程式碼在回覆處)
https://www.facebook.com/groups/1403852566495675/permalink/2568086066738980/
*/