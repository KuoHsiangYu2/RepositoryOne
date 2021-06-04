package com.sample2;

import static java.lang.System.out;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

public class TestHomework0508_2 {
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
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < 51; i++) {
            Student unit = new Student();
            unit.setId(String.format("s%02d", i));
            unit.setScore(getRandomNumber(0, 100));
            studentList.add(unit);
            unit = null;
            out.printf("學生學號：%s, 學生成績：%d%n", studentList.get(i).getId(), studentList.get(i).getScore());
        }
        showDivider(20);

        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -(o1.getScore() - o2.getScore());
            }
        });

        out.println("開始排序後");
        showDivider(20);

        int studentListLength = studentList.size();
        for (int i = 0; i < studentListLength; i++) {
            out.printf("學生學號：%s, 學生成績：%d%n", studentList.get(i).getId(), studentList.get(i).getScore());
        }
    } // end of main method
}