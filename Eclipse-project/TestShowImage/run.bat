color f0
rmdir .\bin\ /s/q
mkdir .\bin
javac -encoding UTF-8 .\src\com\sample\Form2.java .\src\com\sample\Output.java .\src\com\sample\TestShowImage.java -d bin
java -classpath bin com.sample.TestShowImage
pause

::[CMD] 目錄與檔案管理常用指令
::https://edisonx.pixnet.net/blog/post/57090736