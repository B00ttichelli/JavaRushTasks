package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
Напиши программу, которая считывает из консоли имя текстового файла, далее читает символы из этого файла
(используй метод readAllLines(Path) класса Files) и выводит на экран все, за исключением точки, запятой и пробела.


Requirements:
1. Программа должна считать с консоли путь к файлу.
2. Программа должна вывести в консоль содержимое файла согласно условию.
3. Для чтения строк из файла должен быть использован метод readAllLines(Path) класса Files.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
       try {
           List<String> input = Files.readAllLines(Paths.get(path));
           for (String s:input
                ) {

               System.out.println(s.replaceAll("[., ]",""));
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}

