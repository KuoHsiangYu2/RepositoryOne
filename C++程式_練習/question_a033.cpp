#define _CRT_SECURE_NO_WARNINGS

//a033
//https://github.com/cute18943/tcgs.tc
//http://www.tcgs.tc.edu.tw:1218/ShowProblem?problemid=a033
//https://www.facebook.com/groups/1403852566495675/permalink/2540297076184546/

#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char *argv[]) {
	int input1 = 0;
	string input2 = "";
	string buff = "________";
	cin >> input1;
	//input2 = to_string(input1);//舊版本編譯器不支援。

	char intStr[20] = "";
	//_itoa(input1, intStr, 10);//台中女中程式解題系統-舊版本編譯器不支援。
	sprintf(intStr, "%d", input1);
	input2 = string(intStr);

	int inputLength = input2.length();
	switch (inputLength) {
		case 1:
		case 2:
		case 3:
		case 4:
			cout << "|" << buff.substr(0, 8 - inputLength) << input2 << "|\n";
			break;
		case 5:
		case 6:
		case 7:
		case 8:
			cout << "|____" << input2.substr(inputLength - 4, inputLength) << "|\n";
			break;
		default:
			break;
	}

	return 0;
}
