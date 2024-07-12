package com.testcmd;

public class TestCmd {

    public static void main(String[] args) {
        /* 嘗試用Java程式輸入指令在 命令提示字元 */
        String osName = System.getProperty("os.name");
        System.out.println("osName [" + osName + "]");
    }

}

// https://www.baeldung.com/run-shell-command-in-java
// https://blog.csdn.net/u010376788/article/details/51337312
// https://blog.csdn.net/cyan20115/article/details/106551449