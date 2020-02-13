package com.sample;

import static java.lang.System.out;

public class Warrior {
    private String name = "";// 姓名
    private int health = 0;// 生命值
    private int attack = 0;// 攻擊力
    private int heal = 0;// 治癒力

    public Warrior(String name) {
        // constructor 戰士生成時完成的事
        this.name = name;
        health = 100;// 生命值
        attack = 20;// 攻擊力
        heal = 10;// 治癒力
    }

    public int doAttack() {
        // 戰士可以發動攻擊
        // (1)攻擊對手
        out.printf("%s 發動攻擊%n", name);
        return attack;
    }

    public void beAttacked(int attackValue) {
        // 戰士可以被攻擊
        // (1)對手被攻擊
        health = health - attackValue;
        if (health > 0) {
            out.printf("%s 受到 %d 點傷害，生命值：%d%n", name, attackValue, health);
        } else {
            out.printf("%s 受到 %d 點傷害，生命值：%d，%s勇者 陣亡。%n", name, attackValue, health, name);
            Main.breakFlag = true;
        }
    }

    public void doHeal() {
        // 戰士可以發動治療
        // (2)回復生命
        health = health + heal;
        out.printf("%s 使用補血技能（補血量）：%d，生命值：%d%n", name, heal, health);
    }

    public void addAttack() {
        // 戰士可以增加攻擊力
        // (3)劍舞
        /* 固定亂數種子 */
        int random = 0;
        // random = (int) (Math.random() * (15 - 5 + 1)) + 5;// 5 ~ 15
        random = (int) (Math.random() * 11) + 5;// 5 ~ 15
        attack = attack + random;
        out.printf("%s：劍舞！提升 %d 點攻擊力（5 ~ 15）%n", name, random);
        out.printf("目前攻擊力：%d 點，生命值：%d%n", attack, health);
    }

    public String getName() {
        // 可以回傳戰士的姓名
        return name;
    }

    public int getHealth() {
        // 可以回傳戰士的生命值
        return health;
    }

    public int getAttack() {
        // 可以回傳戰士的攻擊力
        return attack;
    }

    public int getHeal() {
        // 可以回傳戰士的治癒力
        return heal;
    }
}
