package com.testcmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TestCMD {

    public static void main(String[] args) {
        // String osName = System.getProperty("os.name");
        // System.out.printf("osName [%s]%n", osName);
        // System.out.println("Charset.forName(\"Big5\")");
        // System.out.println(Charset.forName("UTF-8"));

        String cmd = "cmd.exe /c dir";
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        // String[] cmd = new String[] { "cmd", "/c", "dir", "/a:-d" };
        // String[] cmd = new String[] { "cmd", "/c", "dir" };
        // String[] cmd = new String[] { "cmd", "/c", "python", "--version" };
        // String[] cmd = new String[] { "cmd", "/c", "gcc", "-v" };
        // cmd = "cmd.exe /c gcc -v";
        // cmd = "cmd.exe /c dir";

        // cmd = "ls"; // Charset.forName("UTF-8");

        cmd = "cmd.exe /c dir /b /s";
        // cmd = "cmd.exe /c dir /a /b /s";
        // cmd = "cmd.exe /c dir /a";
        // cmd = "cmd.exe /c dir /a:-d"; // 只看檔案
        // cmd = "cmd.exe /c dir /a:d"; // 只看資料夾
        // cmd = "dir -a"; // 只看資料夾

        // cmd = "grep -r -n 'TestCMD' ."; // Charset.forName("UTF-8");

        // cmd = "cmd.exe dir";
        // cmd = "cmd.exe /c ping www.google.com";
        // cmd = "cmd.exe /c python --version";
        // cmd = "cmd.exe /c gcc --version";
        // cmd = "cmd.exe /c java -version";
        Charset charsetSetting = null;
        charsetSetting = Charset.forName("Big5");
        // charsetSetting = Charset.forName("UTF-8");
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            inputStreamReader = new InputStreamReader(process.getInputStream(), charsetSetting);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("#1 Success");
                closeResource(inputStreamReader, bufferedReader);
                System.exit(0);
            } else {
                System.out.println("exitVal [" + exitVal + "]");
                System.out.println("#2 error");
                closeResource(inputStreamReader, bufferedReader);
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish");
    }

    private static void closeResource(InputStreamReader inputStreamReader, BufferedReader bufferedReader) {
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
                inputStreamReader = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                bufferedReader = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// https://www.baeldung.com/java-invoke-dynamic
// https://www.baeldung.com/java-invoke-static-method-reflection
// https://www.baeldung.com/java-method-reflection
// https://www.baeldung.com/run-shell-command-in-java
// https://www.tutorialspoint.com/java-program-to-open-the-command-prompt-and-insert-commands

// https://www.baeldung.com/run-shell-command-in-java
// https://blog.csdn.net/u010376788/article/details/51337312
// https://blog.csdn.net/cyan20115/article/details/106551449
// https://www.cnblogs.com/Tenfei/articles/16801667.html
// https://blog.csdn.net/YHKKun/article/details/136223876
// https://blog.csdn.net/spy2000/article/details/119675394
// https://blog.csdn.net/jacke121/article/details/73647971
// https://blog.csdn.net/jacke121/article/details/73647971
// https://blog.csdn.net/spy2000/article/details/119675394
// https://www.cnblogs.com/Tenfei/articles/16801667.html
// https://blog.csdn.net/cyan20115/article/details/106551449
// https://blog.csdn.net/YHKKun/article/details/136223876
