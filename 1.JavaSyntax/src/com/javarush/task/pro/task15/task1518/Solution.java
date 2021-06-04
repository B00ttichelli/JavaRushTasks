package com.javarush.task.pro.task15.task1518;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
А что же внутри папки?

А что же внутри папки?
Напиши программу, которая будет считывать с клавиатуры путь к директории, получать список файлов и
директорий в заданной директории и выводить в консоли информацию о них в виде:
"<путь к файлу> - это файл", если это файл,
"<путь к директории> - это директория", если это директория.
Треугольные скобки и кавычки выводить не нужно.
Используй соответствующие методы класса Files: newDirectoryStream(Path), isRegularFile(Path) и isDirectory(Path).

Ввод:
C:\javarush\

Вывод:
C:\javarush\test.txt - это файл
C:\javarush\tasks - это директория
...


Requirements:
1. Программа должна считать из консоли путь к директории.
2. В программе должны быть использованы соответствующие методы класса
Files: newDirectoryStream(Path), isRegularFile(Path) и isDirectory(Path).
3. Программа должна получать список файлов и директорий в заданной директории и выводить в консоли информацию согласно условию.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {

    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path directory = Paths.get(scanner.nextLine());
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(directory)){
            for (Path path:dir
                 ) {
                if(Files.isRegularFile(path)){
                    System.out.println(path + THIS_IS_FILE);
                }
                if(Files.isDirectory(path)){
                    System.out.println(path + THIS_IS_DIR);

                }

            }
        } catch (IOException e) {


        }

    }
}

