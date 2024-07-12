package com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class AniGamerPlusCommand01 {

    private final static String INPUT_FILE = "./inputSN.txt";
    private final static String OUTPUT_FILE = "./outputData.txt";

    private static List<Integer> readListMethod() {
        List<Integer> readList = new ArrayList<Integer>();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String inputString = "";
        try {
            fileInputStream = new FileInputStream(INPUT_FILE);
            inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((inputString = bufferedReader.readLine()) != null) {
                if (inputString.trim().length() != 0) {
                    int findIndex = inputString.indexOf("sn=");
                    if (findIndex > -1) {
                        // System.out.println("findIndex" + findIndex);
                        int beginIndex = findIndex + 3;
                        int endIndex = inputString.length();
                        inputString = inputString.substring(beginIndex, endIndex);
                        int snNum = Integer.parseInt(inputString, 10);
                        // System.out.println("[" + snNum + "]");
                        readList.add(snNum);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    bufferedReader = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                    inputStreamReader = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    fileInputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("read input-file finish");
        return readList;
    }

    private static void writeOutputFile(String resultString) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            /* flase 表示每次都要全新寫入檔案，會蓋掉原檔案資料 */
            fileOutputStream = new FileOutputStream(OUTPUT_FILE, false);

            /* 設定輸出的檔案編碼格式為 UTF-8 */
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8"));

            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(resultString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                    bufferedWriter = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                    outputStreamWriter = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    fileOutputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("write output-file finish");
    }

    public static void main(String[] args) {
        System.out.println("test_AniGamerPlusCommand01");
        StringBuilder sb = new StringBuilder();
        List<Integer> readList = AniGamerPlusCommand01.readListMethod();

        for (int i = 0; i < readList.size(); i++) {
            sb.append("play.bat ");
            sb.append(readList.get(i));
            sb.append(" && ");
        }

        if (sb.toString().length() == 0) {
            System.out.println("查無SN清單資料，結束程式。");
            return;
        }

        int startDelNum = sb.length() - 3;
        int endDelNum = sb.length();
        sb.delete(startDelNum, endDelNum);
        String resultString = sb.toString();

        AniGamerPlusCommand01.writeOutputFile(resultString);
        System.out.println(resultString);
        System.out.println("main finish");
    }

}
