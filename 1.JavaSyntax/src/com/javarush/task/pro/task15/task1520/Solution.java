package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перемещение файлов
Напиши программу, которая будет считывать с клавиатуры пути к двум директориям и перемещать файлы из
 одной директории в другую (только файлы, директории игнорируй). Используй
 соответствующие методы класса Files: newDirectoryStream(), isRegularFile() или isDirectory(), move().


Requirements:
1. Программа должна считать из консоли пути к директориям.
2. В программе должны быть использованы соответствующие методы класса Path согласно условию.
3. Программа должна перемещать файлы из одной директории в другую согласно условию.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Paths.get(scanner.nextLine());
        Path targetDirectory = Paths.get(scanner.nextLine());
        //напишите тут ваш код
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(sourceDirectory)) {
            for (Path filepath :dirs
                 ) {
                if(Files.isRegularFile(filepath)){
                    Files.move(filepath,targetDirectory.resolve(filepath.getFileName()));
                }

            }
        }

    }
}

