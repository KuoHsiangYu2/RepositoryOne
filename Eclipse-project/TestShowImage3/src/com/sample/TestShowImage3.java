package com.sample;

import static com.sample.Output.println;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author 郭翔宇
 */
public class TestShowImage3 {
    private static JButton buttonExit = new JButton("結束");
    private static JButton buttonShow = new JButton("秀輪播牆圖片");
    private static Action2 action2 = new Action2();

    public static void main(String[] args) {
        // Ctrl + Alt + 下 複製該行程式碼並自動貼上
        // Alt + / 自動補完程式碼
        // Alt + [上/下] 移動程式碼
        // Ctrl + D 刪除該行程式碼

        JFrame mainFrame = new JFrame("主視窗");
        mainFrame.setSize(500, 500);
        mainFrame.setLocation(600, 300);
        mainFrame.setLayout(null);

        Font font = new Font("標楷體", Font.PLAIN, 50);

        buttonExit.setBounds(0, 0, 500, 200);
        buttonExit.addActionListener(action2);
        buttonExit.setFont(font);
        mainFrame.add(buttonExit);

        buttonShow.setBounds(0, 200, 500, 200);
        buttonShow.addActionListener(action2);
        buttonShow.setFont(font);
        mainFrame.add(buttonShow);

        /* 禁止修改視窗大小 */
        mainFrame.setResizable(false);

        // mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Form2.runLoop = false;
                println("結束程式");
                System.exit(0);
            }
        });
        mainFrame.setVisible(true);
    }// end of main method

    private static class Action2 implements ActionListener {

        private Form2 form2 = new Form2();

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButton = (JButton) e.getSource();
            if (jButton == buttonExit) {
                Form2.runLoop = false;
                println("結束程式");
                System.exit(0);
            } else if (jButton == buttonShow) {
                println("秀輪播牆圖片");
                form2.initialize();
                form2.display();
            } else {
            }
        }// end of actionPerformed method
    }// end of Action2 [inner class]

}// end of TestShowImage3 class
