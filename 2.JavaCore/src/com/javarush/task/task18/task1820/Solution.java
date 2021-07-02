package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Округление чисел


Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1  = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        List<String[]> collect = bufferedReader1.lines().map(a -> a.split(" ")).collect(Collectors.toList());
        ArrayList<Long> numbers = new ArrayList<>();
        for (String[] arr:collect
             ) {
            for (String str:arr
                 ) {
                numbers.add(Math.round(Double.parseDouble(str)));
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        for (Long number:numbers
             ) {
            bufferedWriter.write(number.toString()+" ");
        }

        bufferedReader.close();
        bufferedWriter.close();
        bufferedReader1.close();
    }
}
