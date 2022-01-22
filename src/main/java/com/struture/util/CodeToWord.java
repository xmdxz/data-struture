package com.struture.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author xpdxz
 * @ClassName CodeToWord
 * @Description TODO
 * @Date 2021/12/24 10:09
 */
public class CodeToWord {

    private static FileChannel toWordFile;

    private static final List<String> excludedPath = Arrays.asList(".idea", "target", "test", ".git", "css", "images", "fonts", ".hbuilderx", "common", "components", "node_modules", "static", "store", "unpackage", "uview-ui");

    private static final List<String> toWordType = Arrays.asList("java", "properties", "vue", "html");

    public static void transfer(File from, File to) {
        if (from.isDirectory()) {
            File[] files = from.listFiles(e -> !excludedPath.contains(e.getName()));
            if (files == null || files.length == 0) {
                return;
            }
            for (File file : files) {
                transfer(file, to);
            }
        } else {
            String fileName = from.getName();
            if (toWordType.contains(fileName.substring(fileName.lastIndexOf(".") + 1))) {
                try (Scanner scanner = new Scanner(from)) {
                    while (scanner.hasNextLine()) {
                        String message = scanner.nextLine();
                        if (!"".equals(message) && !message.contains("@Author") && !message.contains("@author")) {
                            message = message + "\n";
                            ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
                            toWordFile.write(byteBuffer);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void transfer(String fromProject, String toWordPath) {
        File fromFile = new File(fromProject);
        toWordPath = toWordPath + "\\" + fromFile.getName() + ".txt";
        File toFile = new File(toWordPath);
        try {
            if (!toFile.createNewFile()) {
                System.out.println("文件已存在");
                return;
            }
            toWordFile = new FileOutputStream(toFile, true).getChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        transfer(fromFile, new File(toWordPath));
    }

    public static void main(String[] args) throws FileNotFoundException {
//        transfer("D:\\xpdxz\\项目\\cycling-ssm", "D:\\Users\\xpdxz\\Desktop");
//        try {
//            if (toWordFile != null) {
//                toWordFile.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        transfer("D:\\vue_project\\cycling-uni-app", "D:\\Users\\xpdxz\\Desktop");
//        try {
//            if (toWordFile != null) {
//                toWordFile.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Scanner scanner = new Scanner(new File("D:\\Users\\xpdxz\\Desktop\\1.txt"));
        while (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            System.out.println("".equals(message) + ":" + message);
        }
        scanner.close();
    }

}
