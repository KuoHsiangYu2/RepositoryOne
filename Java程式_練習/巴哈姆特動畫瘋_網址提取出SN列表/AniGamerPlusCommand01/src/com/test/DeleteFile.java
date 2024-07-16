package com.test;

import java.io.File;

public class DeleteFile {

    public static void main(String[] args) {
        // TODO Auto-generated method stub_outputData.txt
        File myObj = new File("outputData.txt");
        String fileName = myObj.getName();
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + fileName);
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

}
