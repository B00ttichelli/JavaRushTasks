package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Напиши программу, которая считывает из консоли имя текстового файла, далее читает строки из этого файла
(используй метод readAllLines(Path) класса Files) и выводит их на экран через одну, начиная с первой.


Requirements:
1. Программа должна считать из консоли путь к файлу.
2. Программа должна вывести в консоли содержимое файла согласно условию.
3. Для чтения строк из файла нужно использовать метод readAllLines(Path) класса Files.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (int i = 0; i < lines.size(); i=i+2) {
                System.out.println(lines.get(i));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //напишите тут ваш код
    }
}

