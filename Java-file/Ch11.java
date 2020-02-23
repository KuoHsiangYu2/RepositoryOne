//尚未完成
package ch11_6;

import java.util.Scanner;

abstract class Parent {
    String name[] = new String[10];
    int data[][] = new int[10][5];
    String str1, str2;
    int num;
}

class Student extends Parent {
    private int num;

    Scanner sc = new Scanner(System.in);

    void ShowInformation() {
        try {
            System.out.print("請輸入有幾位學生？：");
            num = sc.nextInt();
            // 陣列索引值必須從0開始
            // for(int j=1;j<=num;j++) {
            for (int j = 0; j < num; j++) {
                System.out.println("請輸入第" + j + "學生的名字");
                super.name[j] = sc.next();
                System.out.println("請輸入第" + j + "學生的年齡:");
                super.data[j][0] = sc.nextInt();
                System.out.println("請輸入第" + j + "學生的學號:");
                super.data[j][1] = sc.nextInt();
                System.out.println("請輸入第" + j + "學生的年級:");
                super.data[j][2] = sc.nextInt();
                System.out.println("請輸入第" + j + "學生的總平均:");
                super.data[j][3] = sc.nextInt();
            }

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("你的值超出陣列範圍！！");
            System.out.println("錯誤訊息" + e);
        } finally {
            System.out.println("謝謝使用 再見！！");
        }
    }
}

class Teacher extends Parent {
    private int num;
    Scanner sc = new Scanner(System.in);

    void ShowInformation() {
        System.out.print("請輸入有幾位老師？：");
        num = sc.nextInt();
        // for(int j=1;j<=num;j++) {
        for (int j = 0; j < num; j++) {
            try {
                System.out.println("請輸入第" + j + "老師的名字:");
                super.name[j] = sc.next();
                System.out.println("請輸入第" + j + "老師的年齡:");
                super.data[j][0] = sc.nextInt();
                System.out.println("請輸入第" + j + "老師的學號:");
                super.data[j][1] = sc.nextInt();
                System.out.println("請輸入第" + j + "老師的年級:");
                super.data[j][2] = sc.nextInt();
                System.out.println("請輸入第" + j + "老師的總平均:");
                super.data[j][3] = sc.nextInt();

            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println("你的值超出陣列範圍！！");
                System.out.println("錯誤訊息" + e);
            } finally {
                System.out.println("謝謝使用 再見！！");
            }
        }

    }
}

public class Ch11 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s = new Student();
        Teacher t = new Teacher();
        s.ShowInformation();
        t.ShowInformation();
    }

}

//陳禮杰
//14 分鐘
//現在有點鬼打牆...(java)
//他說static要放最上層,但放完之後又出現
//類別無法解析
//請問有什麼處理方法嘛？
//code:https://ideone.com/fork/vwMeqq
//https://www.facebook.com/groups/1403852566495675/permalink/2557379531142967/
