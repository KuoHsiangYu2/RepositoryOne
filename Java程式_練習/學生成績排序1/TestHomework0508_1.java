package com.sample1;

import static java.lang.System.out;

import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private int score;

    public Student() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

public class TestHomework0508_1 {
    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static void showDivider(int num) {
        for (int i = 1; i <= num; i++) {
            out.print("-");
        }
        out.printf("%n");
    }

    public static void main(String[] args) {
        Student[] studentList = new Student[51];
        for (int i = 0; i < 51; i++) {
            Student unitStudent = new Student();
            unitStudent.setId(String.format("s%02d", i));
            unitStudent.setScore(getRandomNumber(0, 100));
            studentList[i] = unitStudent;
            unitStudent = null;
            out.printf("學生學號：%s, 學生成績：%d%n", studentList[i].getId(), studentList[i].getScore());
        }
        showDivider(20);

        int studentListLength = studentList.length;
        boolean flag = false;
        for (int i = 0; i < studentListLength - 1; i++) {
            flag = false;
            for (int j = 0; j < studentListLength - i - 1; j++) {
                if (studentList[j].getScore() < studentList[j + 1].getScore()) {
                    flag = true;
                    Student temp = studentList[j];
                    studentList[j] = studentList[j + 1];
                    studentList[j + 1] = temp;
                }
            }
            if (false == flag) {
                break;
            }
        }

        out.println("開始排序後");
        showDivider(20);

        for (int i = 0; i < 51; i++) {
            out.printf("學生學號：%s, 學生成績：%d%n", studentList[i].getId(), studentList[i].getScore());
        }
    } // end of main method
}