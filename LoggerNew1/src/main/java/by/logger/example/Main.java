package by.logger.example;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Main { //Не читает поток и не перименовывает файлы. Почему?
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(Main.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw e;
        }
        File oldFile1 = new File("D:/Projects_Lab_UpSkill/LoggerNew/src/main/resources/configs/old_file1.json");
        File oldFile2 = new File("D:/Projects_Lab_UpSkill/LoggerNew/src/main/resources/configs/old_file2.json");
        String suffix = properties.getProperty("suffix");
        String path = properties.getProperty("path");


        String file1 = properties.getProperty("file1");
        if (oldFile1.canRead() && file1.equals(oldFile1.getAbsolutePath())) {
            System.out.println(file1 + " - " + true);
        } else {
            System.out.println(file1 + " - " + false);
        }
        oldFile1.renameTo(new File(path + suffix + "_file1.json"));


        String file2 = properties.getProperty("file2");
        if (oldFile2.canRead() && file2.equals(oldFile2.getAbsolutePath())) {
            System.out.println(file2 + " - " + true);
        } else {
            System.out.println(file2 + " - " + false);
        }
        oldFile2.renameTo(new File(path + suffix + "_file2.json"));

        //File files = new File("D:/Projects_Lab_UpSkill/LoggerNew/src/main/resources/configs");
        System.out.println(file1);
    }
}
