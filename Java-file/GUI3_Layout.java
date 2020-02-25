package com.sample2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI3_Layout {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Frame frame2 = new Frame();
        frame2.setLocationRelativeTo(null);
        frame2.setLayout(null);
        frame2.setSize(500, 500);
        Button button2 = new Button("ok");
        button2.setLocation(225, 50);
        button2.setSize(50, 50);
        frame2.add(button2);
        frame2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame2.setVisible(true);
    }

}
