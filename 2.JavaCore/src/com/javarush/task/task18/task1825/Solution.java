package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл



Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Requirements:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<>();
        while (bufferedReader.ready()){
            String filename = bufferedReader.readLine();
            if (filename.equals("end")){
                break;
            }else {
                files.add(filename);
            }
        }

        String fileToWrite = files.get(0).split("\\.")[0]+"."+files.get(0).split("\\.")[1];
        Collections.sort(files);
        BufferedOutputStream endFile = new BufferedOutputStream(new FileOutputStream(fileToWrite));
        for (String filename:files
             ) {
            FileInputStream fis = new FileInputStream(filename);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            endFile.write(bytes);
            fis.close();
        }
        bufferedReader.close();
        endFile.close();

    }
}
