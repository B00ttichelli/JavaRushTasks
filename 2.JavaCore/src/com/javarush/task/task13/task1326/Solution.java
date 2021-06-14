package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/* 
Сортировка четных чисел из файла


Сортировка четных чисел из файла
В этой задаче тебе нужно:
Ввести имя файла с консоли.
Прочитать из него набор чисел.
Вывести в консоли только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Requirements:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа, считанные из файла, отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла — FileInputStream.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        BufferedReader filerader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String line;
        ArrayList<Integer> integers = new ArrayList<>();
        while ((line = filerader.readLine()) != null){
            integers.add(Integer.parseInt(line));

        }
        integers.removeIf(x->x%2!=0);
        Collections.sort(integers);
        integers.forEach(System.out::println);
        filerader.close();

     /* Это решение работает но не принимаетса валидатором
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(filename);
        byte [] buff = new byte[10];
        StringBuilder stringBuilder = new StringBuilder();
        while (fileInputStream.read(buff)!=-1){
            stringBuilder.append(new String(buff));
            buff = new byte[10];

        }
        String[] split = stringBuilder.toString().split("\n");
        List<String> list = Arrays.asList(split);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {

                return Integer.compare(Integer.parseInt(s),Integer.parseInt(t1));
            }
        });
        ArrayList<String> arr = new ArrayList<>(list);
        arr.removeIf((x)->Integer.parseInt(x)%2!=0);
        arr.forEach(System.out::println);
        fileInputStream.close();
*/

    }
}
