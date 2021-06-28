package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты

Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        int i ;
        Map<Integer,Integer> map =  new HashMap<>();
        while (fileInputStream.available()>0){
            i = fileInputStream.read();
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
                }else {
                map.put(i,1);
            }
        }
        fileInputStream.close();
        bufferedReader.close();
        Integer min = Collections.min(map.values());
        for (Map.Entry<Integer,Integer> kv :map.entrySet()
             ) {
            if(kv.getValue().equals(min)){
                System.out.print(kv.getKey()+" ");
            }
        }
    }
}
