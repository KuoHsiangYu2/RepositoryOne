package com.sample;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI2_Layout {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setSize(500, 500);

        JButton button = new JButton("ok");
        // button.setBounds(225, 0, 50, 50);
        button.setLocation(225, 0);
        button.setSize(50, 50);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

//https://www.facebook.com/groups/1403852566495675/permalink/2558632797684307/
