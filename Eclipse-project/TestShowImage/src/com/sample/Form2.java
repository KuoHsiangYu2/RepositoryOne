package com.sample;

import static com.sample.Output.println;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author 郭翔宇
 */
public class Form2 {

    private File file = null;
    private BufferedImage bufferedImage = null;
    private JFrame form2 = null;
    private ImageIcon imageIcon = null;
    private JLabel jLabel = null;

    public void initialize() {
        /* 這段程式碼讀取圖片資料 */
        try {
            println("載入圖片 ... ");
            file = new File("./res/image/SetonAcademy_JoinThePack_1.jpg");
            bufferedImage = ImageIO.read(file);
            println("載入圖片成功");
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

        imageIcon = new ImageIcon(bufferedImage);
        jLabel = new JLabel(imageIcon);
        form2.add(jLabel);
        
        form2.pack();
        form2.setLocationRelativeTo(null);
        form2.setVisible(true);
        form2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }// end of display method

}// end of Form2 class
