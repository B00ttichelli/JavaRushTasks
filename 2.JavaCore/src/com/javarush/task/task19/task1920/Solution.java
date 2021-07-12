package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый

Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Requirements:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.

*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String,Double> table = new TreeMap<>();

        while (bufferedReader.ready()) {
            String tmp = bufferedReader.readLine();
            String[] split = tmp.split(" ");
            if (table.containsKey(split[0])) {
                Double salary = table.get(split[0]);
                table.put(split[0], salary + Double.parseDouble(split[1]));
            } else {
                table.put(split[0], Double.parseDouble(split[1]));
            }
        }

            Double max = Collections.max(table.values());
            bufferedReader.close();
            for (Map.Entry<String,Double> entry: table.entrySet()
                 ) {
                if(entry.getValue().equals(max)){
                    System.out.println(entry.getKey());
                }
            }


    }
}
