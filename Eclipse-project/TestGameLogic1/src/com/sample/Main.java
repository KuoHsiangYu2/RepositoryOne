package com.sample;

import static java.lang.System.out;

import java.util.Scanner;

//主類別
public class Main {
    public static boolean breakFlag = false;

    private static void checkWinner(Warrior warriorA, Warrior warriorB) {
        // 檢查誰的生命值歸0、找出贏家。
        if (warriorA.getHealth() <= 0) {
            out.printf("%s 獲勝！%n", warriorB.getName());
        }
        if (warriorB.getHealth() <= 0) {
            out.printf("%s 獲勝！%n", warriorA.getName());
        }
    }

    private static void takeAction(int select, Warrior userWarrior, Warrior enemyWarrior) {
        // 執行選項1, 2, 3其中一項操作。
        int attackValue = 0;
        switch (select) {
        case 1:
            attackValue = userWarrior.doAttack();
            enemyWarrior.beAttacked(attackValue);
            break;
        case 2:
            userWarrior.doHeal();
            break;
        case 3:
            userWarrior.addAttack();
            break;
        default:
            out.printf("error. 請輸入 1 ~ 3 之間的數字。%n");
            break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = "";
        String enemyName = "Monster";

        out.printf("勇者大亂鬥，請輸入勇者的名字：");
        userName = scanner.next();

        Warrior userWarrior = new Warrior(userName);
        Warrior enemyWarrior = new Warrior(enemyName);

        out.printf("勇者%s 華麗登場%n", userWarrior.getName());
        out.printf("生命值：%d 攻擊力：%d 治癒力：%d%n%n", userWarrior.getHealth(), userWarrior.getAttack(), userWarrior.getHeal());

        out.printf("你的對手 勇者%s 華麗登場%n", enemyWarrior.getName());
        out.printf("生命值：%d 攻擊力：%d 治癒力：%d%n%n", enemyWarrior.getHealth(), enemyWarrior.getAttack(),
                enemyWarrior.getHeal());

        out.printf("開始戰鬥%n%n");

        int count = 1;
        int userInput = 0;
        int enemyInput = 0;
        breakFlag = false;
        while (false == breakFlag) {
            out.printf("/******** Round%d ********/%n", count);

            out.printf("選擇 (1)攻擊對手 (2)回復生命 (3)劍舞%n");
            userInput = scanner.nextInt();
            takeAction(userInput, userWarrior, enemyWarrior);
            checkWinner(userWarrior, enemyWarrior);

            if (true == breakFlag) {
                break;
            }

            out.printf("%n");
            out.printf("對手的回合%n");
            // enemyInput = (int) (Math.random() * (3 - 1 + 1)) + 1;// 1 ~ 3
            enemyInput = (int) (Math.random() * 3) + 1;// 1 ~ 3
            takeAction(enemyInput, enemyWarrior, userWarrior);
            checkWinner(userWarrior, enemyWarrior);

            if (true == breakFlag) {
                break;
            }

            out.printf("************************%n%n");

            count = count + 1;
        }

        out.printf("%n");
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
        out.println("finish");
    }
}
