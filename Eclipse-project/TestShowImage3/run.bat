color f0
::chcp 65001
::chcp 950
::set path=.\javaLib\jdk1.8\bin;%path%
::javac -version
::java -version
rmdir .\bin\ /s/q
mkdir .\bin
javac -encoding UTF-8 .\src\com\sample\Output.java .\src\com\sample\Form2.java .\src\com\sample\TestShowImage3.java -d bin
java -classpath bin com.sample.TestShowImage3
::pause

::[CMD] 目錄與檔案管理常用指令
::https://edisonx.pixnet.net/blog/post/57090736
