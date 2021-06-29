package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла


Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Requirements:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(bufferedReader.readLine());


        bufferedReader.close();
        int avbl = fileInputStream.available();
        byte[] buffer = new byte[10000];
        fileInputStream.read(buffer);
        int firstHalfLimiter = (avbl/2)+(avbl%2);
        int secondHalfLimiter = avbl - firstHalfLimiter;
        fileOutputStream1.write(buffer,0,firstHalfLimiter);
        fileOutputStream2.write(buffer,firstHalfLimiter,secondHalfLimiter);


        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }

}
