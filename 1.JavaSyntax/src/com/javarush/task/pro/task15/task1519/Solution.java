package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Поверхностное копирование

Поверхностное копирование
Напиши программу, которая будет считывать с клавиатуры пути к двум директориям и копировать файлы из одной директории
в другую (только файлы, директории игнорируй).
Используй соответствующие методы класса Files: newDirectoryStream(), isRegularFile() или isDirectory(), copy().


Requirements:
1. Программа должна считать из консоли путь к директории.
2. В программе должны быть использованы соответствующие методы класса Files: newDirectoryStream(), isRegularFile() или isDirectory(), copy().
3. Программа должна копировать файлы из одной директории в другую согласно условию.
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

                    Files.copy(filepath,targetDirectory.resolve(filepath.getFileName()));
                }

            }
        }

    }
}

