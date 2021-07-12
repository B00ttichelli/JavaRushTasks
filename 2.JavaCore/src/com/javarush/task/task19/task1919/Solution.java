package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* 
Считаем зарплаты


Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Requirements:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String,Double> table = new TreeMap<>();
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String[] split = line.split(" ");
            if(table.containsKey(split[0])){
                Double salary = table.get(split[0])+Double.parseDouble(split[1]);
                table.replace(split[0],salary);

            }else {
                table.put(split[0],Double.parseDouble(split[1]));
            }
        }
        bufferedReader.close();
        for (Map.Entry<String, Double> entry :table.entrySet()
             ) {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }

    }
}
