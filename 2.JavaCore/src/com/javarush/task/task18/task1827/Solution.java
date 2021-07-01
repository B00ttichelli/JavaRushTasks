package com.javarush.task.task18.task1827;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Прайсы


Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Requirements:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length != 0){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename  =  bufferedReader.readLine();
            BufferedReader filerw = new BufferedReader(new FileReader(filename));
            List<String> collect = filerw.lines().collect(Collectors.toList());
            String s = collect.get(0);
            Integer currentId = Integer.parseInt(s.substring(0,8).trim());
            for (String each:collect
                 ) {

                if (Integer.parseInt(each.substring(0,8).trim())>currentId){
                    currentId = Integer.parseInt(each.substring(0,8).trim());

                }
            }

            currentId++;
            StringBuilder newline = new StringBuilder();
            newline.append(currentId.toString());
            for (int i = currentId.toString().length(); i < 8  ; i++) {
                newline.append(" ");

            }
            if(args[1].length()>30){
                newline.append(args[1].substring(0,20));
            }else {
                newline.append(args[1]);
                for (int i = args[1].length(); i <30 ; i++) {
                    newline.append(" ");
                }
            }

            if (args[2].length()>8){
                newline.append(args[2].substring(0,8));
            }else {
                newline.append(args[2]);
                for (int i = args[2].length(); i <8 ; i++) {
                    newline.append(" ");
                }
            }
            newline.append(args[3]);

            for (int i = args[3].length(); i <4  ; i++) {
                newline.append(" ");
            }


            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            for (String x:collect
                 ) {
                bufferedWriter.write(x);
                bufferedWriter.write("\n");

            }

            bufferedWriter.write(newline.toString());
            bufferedWriter.close();
            bufferedReader.close();
            filerw.close();

        }
    }
}
