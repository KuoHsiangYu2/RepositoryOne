package com.test3;

import static com.util.Output.println;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ScanFileOneLayer {

    public static void main(String[] args) {
        // Path targetPath = Paths.get("D:", "mydir");
        Path targetPath = Paths.get("C:", "mydir");
        Stream<Path> stream = null;
        try {
            // 只能掃一層資料夾.
            stream = Files.list(targetPath);
            stream.forEach((Path path) -> println(path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
                stream = null;
            }
        }
    }

}
