package com.javarush.task.pro.task15.task1513;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Зри в корень
Зри в корень
Напиши программу, в которой пользователь вводит с клавиатуры путь к файлу или папке, после чего в
консоли выводится диск (корень для Unix-like), на котором находится этот файл (или папка).
Для решения задачи используй Path и его методы.


Requirements:
1. Программа должна считать из консоли путь к файлу/папке.
2. Программа должна выводить в консоли диск, на котором находится этот файл (или папка).
3. Для получения диска из пути нужно использовать метод getRoot() класса Path.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path path = Paths.get(str);

        System.out.println(path.getRoot());

    }
}


