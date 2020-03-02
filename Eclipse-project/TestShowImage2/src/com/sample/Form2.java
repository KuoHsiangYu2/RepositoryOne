package com.sample;

import static com.sample.Output.println;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author 郭翔宇
 */
public class Form2 {

    public static final int PICTURES_NUMBER = 6;
    public static boolean runLoop = true;
    public static BufferedImage[] bufferedImage = null;
    public static String[] filePath = null;
    public static JFrame form2 = null;
    public static ImageIcon imageIcon = null;
    public static JLabel jLabel = null;

    public void initialize() {
        File file = null;
        bufferedImage = new BufferedImage[PICTURES_NUMBER];
        filePath = new String[PICTURES_NUMBER];
        for (int i = 0, j = 1; i < PICTURES_NUMBER; i++, j++) {
            filePath[i] = "./res/image/picture" + j + ".jpg";
        }

        /* 這段程式碼讀取圖片資料 */
        try {
            println("載入圖片 ... ");
            for (int i = 0; i < bufferedImage.length; i++) {
                file = new File(filePath[i]);
                bufferedImage[i] = ImageIO.read(file);
                file = null;
            }
            println("所有圖片載入成功");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            println("#1 載入圖片失敗，停止程式。");
            e.printStackTrace();
            System.exit(0);
        }
    }// end of initialize method

    public void display() {
        /* 這段程式碼生成JFrame視窗出來 */

        form2 = new JFrame("顯示圖片");

        /* Settings can adjust the window size. */
        form2.setResizable(true);

        imageIcon = new ImageIcon(bufferedImage[0]);
        jLabel = new JLabel(imageIcon);
        form2.add(jLabel);

        form2.pack();
        form2.setLocationRelativeTo(null);
        // form2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        form2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                runLoop = false;
                System.exit(0);
            }
        });
        form2.setVisible(true);

        DisplayLoop displayLoop = new DisplayLoop();
        displayLoop.start();

    }// end of display method

}// end of Form2 class
