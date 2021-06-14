package com.javarush.task.task13.task1319;

import java.io.*;
/*import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;*/
import java.util.Scanner;

/* 
Писатель в файл с консоли

В этой задаче тебе нужно:
Прочесть с консоли имя файла.
Считывать строки с консоли, пока пользователь не введет строку "exit".
Вывести абсолютно все введенные строки в файл, каждую строчку — с новой строки.

Requirements:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего считывать из файловой системы.
4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать все введенные строки (включая "exit") в файл: каждую строчку — с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.
7. Метод main не должен выводить данные на экран.
*/

/*

Мое решение но увы так незя, можно использовать ток старое говно
public class Solution {
    final  static String EXIT = "exit";
    public static void main(String[] args) throws IOException {
        // напишите тут ваш
        ArrayList<String> arrayList =  new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        arrayList.add(filename);
        String line = bufferedReader.readLine();
        while (!line.equals(EXIT)){
            arrayList.add(line);
            line = bufferedReader.readLine();
        }
        arrayList.add(EXIT);
        Files.write(Paths.get(filename),arrayList);

    }
}
*/


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destinationFileName = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName));

        StringBuilder builder = new StringBuilder();

        String s = "";
        while (!s.equals("exit")) {
            s = reader.readLine();
            builder.append(s).append("\n");
        }

        writer.write(builder.toString());
        writer.close();
    }
}
