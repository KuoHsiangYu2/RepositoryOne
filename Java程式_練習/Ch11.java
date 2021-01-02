package ch11_6;

import static java.lang.System.out;

import java.util.Scanner;

abstract class SchoolMember {

    public void showInformation(String member) {
        String[] name = new String[10];
        int[][] data = new int[10][4];
        int num = 0;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        out.printf("請輸入%s人數：", member);
        num = scanner.nextInt();
        try {
            
            // 陣列索引值必須從0開始
            for (int j = 0; j < num; j++) {
                out.printf("請輸入第%d位%s的名字：", (j + 1), member);
                name[j] = scanner.next();
                out.printf("請輸入第%d位%s的年齡：", (j + 1), member);
                data[j][0] = scanner.nextInt();
                out.printf("請輸入第%d位%s的學號：", (j + 1), member);
                data[j][1] = scanner.nextInt();
                out.printf("請輸入第%d位%s的年級：", (j + 1), member);
                data[j][2] = scanner.nextInt();
                out.printf("請輸入第%d位%s的總平均：", (j + 1), member);
                data[j][3] = scanner.nextInt();
                out.printf("%n");
            }

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            out.println("你的索引值超出陣列範圍！");
            out.println("錯誤訊息：" + e);
        } finally {
            out.println("謝謝使用，再見。");
            out.printf("%n");
        }

    }// end of showInformation method

    public abstract void processShowInformation();
    // end of processShowInformation [abstract method]

}// end of SchoolMember class

class Student extends SchoolMember {

    @Override
    public void processShowInformation() {
        super.showInformation("學生");
    }// end of processShowInformation method

}// end of Student class

class Teacher extends SchoolMember {

    @Override
    public void processShowInformation() {
        super.showInformation("老師");
    }// end of processShowInformation method

}// end of Teacher class

public class Ch11 {

    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.processShowInformation();
        teacher.processShowInformation();
    }// end of main method

}// end of Ch11 class

//陳禮杰
//14 分鐘
//現在有點鬼打牆...(java)
//他說static要放最上層,但放完之後又出現
//類別無法解析
//請問有什麼處理方法嘛？
//code:https://ideone.com/fork/vwMeqq
//https://www.facebook.com/groups/1403852566495675/permalink/2557379531142967/

//https://ideone.com/fork/sIReHL
