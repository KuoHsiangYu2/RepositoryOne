package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

class Food {
    final int chickLeg = 30;
    final int chickRib = 50;
    final int can = 100;
}

public class P02Restaurant {
    private static PrintWriter pw = null;

    public static void main(String[] args) {
        File file = new File("food.csv");
        System.out.println("file.exists() -> " + file.exists());

        if (false == file.exists()) {
            try {
                System.out.println("#1 檔案不存在，創建新檔案。");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("#2 檔案已存在。");
        }

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        pw = null;
        try {
            fos = new FileOutputStream(file, false);// false 代表從新開始覆寫檔案
            osw = new OutputStreamWriter(fos, "UTF-8");// setting utf-8 encoding
            pw = new PrintWriter(osw);

            // Windows 作業系統電腦 換行符號 \r\n
            pw.write("Chicken Leg" + "," + "Chicken Rib" + "," + "Can" + "\r\n");

            P02Restaurant.order();

            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
                pw = null;
            }
            if (osw != null) {
                try {
                    osw.close();
                    osw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("finish");
    }

    @SuppressWarnings("unused")
    public static void order() {
        Food food = new Food();
        Random random = new Random();
        int sumChickLeg = 0;// 變數要設定初始值給他。
        int sumChickRib = 0;
        int sumCan = 0;
        sumChickLeg = random.nextInt(11);
        sumChickRib = random.nextInt(11);
        sumCan = random.nextInt(11);

        // 必須轉成 String字串 才能印出正常的數字與文字。
        pw.write(String.valueOf(sumChickLeg) + "\r\n");
    }
}

//https://www.facebook.com/groups/1403852566495675/permalink/2569952293219024/
//https://pastebin.com/TxatbhfG
