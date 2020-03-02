//https://stackoverflow.com/questions/7628121/how-can-i-refresh-or-reload-the-jframe
//https://blog.csdn.net/xu__cg/article/details/52831127
//https://blog.csdn.net/dreamzuora/article/details/82664379
package com.sample;

import static com.sample.Output.println;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 郭翔宇
 */
public class DisplayLoop extends Thread {
    @Override
    public void run() {
        super.run();
        int count = 1;
        while (true == Form2.runLoop) {
            try {
                // TimeUnit.SECONDS.sleep(2);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Form2.form2.remove(Form2.jLabel);
            Form2.jLabel = null;
            Form2.imageIcon = null;
            println("count -> " + count);
            Form2.imageIcon = new ImageIcon(Form2.bufferedImage[count]);
            Form2.jLabel = new JLabel(Form2.imageIcon);
            Form2.form2.add(Form2.jLabel);

            /* 刷新頁面-start */
            Form2.form2.invalidate();
            Form2.form2.validate();
            Form2.form2.repaint();
            /* 刷新頁面-end */

            count = count + 1;
            if (count == Form2.PICTURES_NUMBER) {
                count = 0;
            }
        }
    }// end of run [Override method]

}// end of DisplayLoop class
