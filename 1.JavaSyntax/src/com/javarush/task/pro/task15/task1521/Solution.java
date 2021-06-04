package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
Временное сохранение файла
Временное сохранение файла
Напиши код, который будет считывать с клавиатуры ссылку на файл в интернете, скачивать его и сохранять во временный файл.
Используй методы createTempFile(null, null) и write(Path, byte[]) класса Files, а также метод openStream() класса URL.


Requirements:
1. Программа должна считать из консоли ссылку на файл в интернете (строку).
2. Программа должна скачать файл по ссылке и сохранить его во временный файл.
3. В программе должны быть использованы методы классов Files и URL согласно условию.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //напишите тут ваш код
        URL url = new URL(line);
        try (InputStream inputStream = url.openStream()) {
            byte[] buffer = new byte[1024];
            int res = 0;
            String filename = (Paths.get(url.getFile())).getFileName().toString();
            Path pathTemp = Files.createTempFile(null, null);
            while (true) {
                res = inputStream.read(buffer);
                if (res == 1024) {
                    Files.write(pathTemp, buffer);
                } else if (res != -1 ) {
                    byte[] byteEndBuffer = Arrays.copyOf(buffer, res);
                    Files.write(pathTemp, byteEndBuffer);
                } else {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}