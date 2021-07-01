package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном

Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Requirements:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String file1 = bufferedReader.readLine();
    String file2 = bufferedReader.readLine();
    String file3 = bufferedReader.readLine();

    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
    BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file2));
    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file3));

   while (bufferedReader1.ready()){
       bufferedWriter.write(bufferedReader1.readLine());
   }
   while (bufferedReader2.ready()){
       bufferedWriter.write(bufferedReader2.readLine());
   }
   bufferedReader1.close();
   bufferedReader.close();
   bufferedWriter.close();
   bufferedReader2.close();
    }
}
