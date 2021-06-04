package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Файл или директория


Файл или директория
Напиши программу, которая будет считывать с клавиатуры строки, и если данная строка — это путь
к существующему файлу, выводить в консоли "<введенная строка> - это файл". Если путь к существующей директории,
выводить в консоли "<введенная строка> - это директория".
Если строка не является путем к файлу или директории, то выходим из программы. Треугольные скобки и кавычки выводить не нужно.
Для проверки файлов и директорий используй методы isRegularFile() и isDirectory() класса Files.

Пример вывода:
C:\javarush\text.txt - это файл
C:\javarush\ - это директория


Requirements:
1. Программа должна считывать из консоли пути к файлам/директориям до тех пор, пока не будет введен некорректный путь.
2. Программа должна выводить в консоли информацию о введенном пути согласно условию.
3. Для проверки файлов и директорий должны быть использованы методы isRegularFile() и isDirectory() класса Files.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path  = scanner.nextLine();
        while (Files.exists(Paths.get(path))){
            if(Files.isDirectory(Paths.get(path))){
                System.out.println(path+THIS_IS_DIR);

            }
            if(Files.isRegularFile(Paths.get(path))){
                System.out.println(path+THIS_IS_FILE);
            }
            path = scanner.nextLine();
        }

    }
}

