// Main.java
// https://www.facebook.com/groups/1403852566495675/permalink/2733993013481617/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int age = 0;
        String name = "";
        System.out.print("How olld are you : ");
        age = scn.nextInt();
        scn.nextLine(); // clear buffer
        System.out.print("What is your name : ");
        name = scn.nextLine();
        System.out.println("Your age = " + age);
        System.out.println("Your name = " + name);
        if (scn != null) {
            scn.close();
            scn = null;
        }
    }
}

// 【Notepad++ 快捷鍵】
// Ctrl + D 複製一行
// Ctrl + L 迅速刪除
// Alt + Shift + 上/下 多列一起選取
