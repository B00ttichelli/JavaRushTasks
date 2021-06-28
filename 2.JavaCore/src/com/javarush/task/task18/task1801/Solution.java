package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

/* 
Максимальный байт


Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream =  new FileInputStream(bufferedReader.readLine());
        int bigest = fileInputStream.read();
        int next ;
        while (fileInputStream.available()>0){
            next = fileInputStream.read();
            if(next>bigest){
                bigest=next;
            }
        }
        fileInputStream.close();
        bufferedReader.close();
        System.out.println((byte)bigest);






    }
}
