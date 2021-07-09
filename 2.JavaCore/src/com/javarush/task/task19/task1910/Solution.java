package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Пунктуация

Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

Закрыть потоки.


Requirements:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

public class Solution {
    public static final Pattern PUNCT = Pattern.compile("\\p{Punct}+") ;
    public static final  Pattern ENDLINE = Pattern.compile("\\n");
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();

        while (bufferedFileReader.ready()){
            bufferedWriter.write(cleanString(bufferedFileReader.readLine()));
        }
        bufferedFileReader.close();
        bufferedWriter.close();
    }

    public static String cleanString(String str){
        return ENDLINE.matcher(PUNCT.matcher(str).replaceAll("")).replaceAll("");
    }
}
