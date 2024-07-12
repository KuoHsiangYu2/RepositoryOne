package com.test2;

import static com.util.Output.println;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ScanFile2 {
    public static void main(String[] args) {
        // Path targetPath = Paths.get("D:", "mydir");
        Path targetPath = Paths.get("C:", "mydir");
        List<Path> fileList = null;
        try {
            // 走訪整個資料夾，並把結果彙總成List.
            fileList = Files.walk(targetPath).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileList.forEach((Path path) -> println(path));
    }
}
