/* file encoding="UTF-8 with no BOM" */
/* Project name: YeJiaXingListJava_2 */
/* Java jdk version: 1.8.0_171 */
/* Java jre version: 1.8.0_171 */
/* IDE: Eclipse IDE for Enterprise Java Developers */
/* IDE version: 2019-03(4.11.0) */
/* operating system: Windows 8.1 */

package com.sample;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class YeJiaXingListJava_2 {

	public static void main(String[] args) {

		String name = "";
		String isInsert = "";
		int age = 0;
		int count = 0;

		Scanner scanner = new Scanner(System.in);// 建立 Scanner物件
		ArrayList<String> listName = new ArrayList<String>();// 建立 ArrayList物件，保存名稱
		ArrayList<Integer> listAge = new ArrayList<Integer>();// 建立 ArrayList物件，保存年齡

		// 使用 add method 把值設進 ArrayList物件 裡面。
		listName.add("葉先生");// 初始值
		listAge.add(23);// 初始值

		// 秀出初始名單
		displayList(listName, listAge);

		// 進入循環，設定輸入100筆資料進 ArrayList物件 就退出迴圈。
		while (count < 100) {

			out.print("是否新增名單（yes/no）：");
			isInsert = scanner.nextLine();// 所以如果沒清掉緩衝區裡面的內容的話，
			// nextLine() method 會讀到 '\n' 接著程式結束執行

			if ("yes".equals(isInsert)) {

				// 設置新增成員名單
				out.print("請輸入成員名稱：");
				name = scanner.nextLine();// 成員名稱
				listName.add(name);

				out.print("請輸入成員年齡：");
				age = scanner.nextInt();// 成員年齡
				listAge.add(age);

				scanner.nextLine();// 清空緩衝區
				// 當你使用 nextInt() 取值的時候，前面的數字被取走，後面的 '\n' 被留在緩衝區裡面
				// 接著當迴圈再執行下一回合時 '\n' 被第 40行 的scanner.nextLine();讀到
				// 於是退出迴圈。
				// Windows作業系統電腦裡的文件換行符號 '\r' '\n' 就是 CR LF 這2個字元
				// CR == 0D 【ASCII 16進位編碼】
				// LF == 0A 【ASCII 16進位編碼】

				// 秀出成員名單
				displayList(listName, listAge);
				count = count + 1;
			} else if ("no".equals(isInsert)) {
				out.println("輸出最終結果");
				displayList(listName, listAge);
				break;
			} else {
				out.println("error. 請輸入 yes 或 no");
				continue;
			}
		} // end of while-loop

		if (scanner != null) {
			scanner.close();
			scanner = null;
		}
		out.println("BUILD SUCCESSFUL (total time: 0 seconds)");
	}// end of main method

	private static void displayList(ArrayList<String> listName, ArrayList<Integer> listAge) {

		// listName.size() 相當於 陣列.length ，回傳 ArrayList物件 裡面儲存元素數量
		for (int i = 0; i < listName.size(); i++) {
			out.println("==================");
			// 使用 get method 把值從 ArrayList物件 裡面取出來。
			out.println("名稱：" + listName.get(i));
			out.println("年齡：" + listAge.get(i));
			out.println("==================");
		}
	}// end of displayList method

}// end of YeJiaXingListJava_2 class

//葉佳興
//22 小時
//又碰壁了...
//小弟想給自己做點複習，於是試著寫個可以自由新增名單的簡易程式...(只有新增...)
//
//程式裡有寫入一個迴圈while()，進入迴圈時會問是否新增名單(填入Yes or yes)。
//
//填入指定字串時會要求輸入新成員的名稱和年齡。
//
//然後一次新增一個，每新增一個成員，就會秀出當前的名單，
//然後在問一次是否新增，直到輸入了指定字串以外的內容。
//
//問題來了...他第二次詢問時直接略過了輸入的過程，然後直接秀出當前名單並退出迴圈！
//
//我想問題應該出在 #28 這段，但...該如何處理？
//https://www.facebook.com/groups/1403852566495675/permalink/2338167486397507/