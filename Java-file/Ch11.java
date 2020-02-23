//尚未完成
package ch11_6;

import static java.lang.System.out;

import java.util.Scanner;

abstract class Parent {
    String[] name = new String[10];
    int[][] data = new int[10][5];
    String str1 = "";
    String str2 = "";

    public abstract void showInformation();
}

class Student extends Parent {
    private int num = 0;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void showInformation() {
        try {
            out.print("請輸入學生人數：");
            num = scanner.nextInt();

            // 陣列索引值必須從0開始
            for (int j = 0; j < num; j++) {
                out.printf("請輸入第 %d 學生的名字：", (j + 1));
                super.name[j] = scanner.next();
                out.printf("請輸入第 %d 學生的年齡：", (j + 1));
                super.data[j][0] = scanner.nextInt();
                out.printf("請輸入第 %d 學生的學號：", (j + 1));
                super.data[j][1] = scanner.nextInt();
                out.printf("請輸入第 %d 學生的年級：", (j + 1));
                super.data[j][2] = scanner.nextInt();
                out.printf("請輸入第 %d 學生的總平均：", (j + 1));
                super.data[j][3] = scanner.nextInt();
            }

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            out.println("你的索引值超出陣列範圍！");
            out.println("錯誤訊息：" + e);
        } finally {
            out.println("謝謝使用，再見。");
        }
    }
}

class Teacher extends Parent {
    private int num = 0;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void showInformation() {
        System.out.print("請輸入有老師人數：");
        num = scanner.nextInt();
        for (int j = 0; j < num; j++) {
            try {
                out.printf("請輸入第 %d 老師的名字：", (j + 1));
                super.name[j] = scanner.next();
                out.printf("請輸入第 %d 老師的年齡：", (j + 1));
                super.data[j][0] = scanner.nextInt();
                out.printf("請輸入第 %d 老師的學號：", (j + 1));
                super.data[j][1] = scanner.nextInt();
                out.printf("請輸入第 %d 老師的年級：", (j + 1));
                super.data[j][2] = scanner.nextInt();
                out.printf("請輸入第 %d 老師的總平均：", (j + 1));
                super.data[j][3] = scanner.nextInt();

            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                out.println("你的值超出陣列範圍！！");
                out.println("錯誤訊息：" + e);
            } finally {
                out.println("謝謝使用，再見。");
            }
        }

    }
}

public class Ch11 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.showInformation();
        teacher.showInformation();
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

//https://ideone.com/fork/sIReHL