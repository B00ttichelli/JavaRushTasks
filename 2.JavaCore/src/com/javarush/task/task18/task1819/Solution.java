package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/* 
Объединение файлов

Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
        List<String> collect = bufferedReader2.lines().collect(Collectors.toList());
        collect.addAll(bufferedReader1.lines().collect(Collectors.toList()));
        bufferedReader1.close();
        bufferedReader2.close();

        for (String str : collect
        ) {
            bufferedWriter.write(str);
        }
        bufferedWriter.close();

    }
}
