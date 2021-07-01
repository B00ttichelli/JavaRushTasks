package com.javarush.task.task18.task1828;

import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/* 
Прайсы 2


CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Requirements:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        List<String> collect = fileReader.lines().collect(Collectors.toList());
        fileReader.close();


        /*где id - 8 символов
        productName - название товара, 30 символов
        price - цена, 8 символов
        quantity - количество, 4 символа*/
        if (args.length > 0) {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename, false));

            if (args[0].equals("-u")) {

                for (String str : collect
                ) {
                    if (Integer.parseInt(str.substring(0, 8).trim()) == (Integer.parseInt(args[1]))) {
                        fileWriter.write(String.format("%-8d%-30s%-8s%-4s", Integer.parseInt(args[1]), args[2], args[3], args[4]));
                        fileWriter.write("\n");
                    } else {
                        fileWriter.write(str + "\n");
                    }

                }


            } else if (args[0].equals("-d")) {

                for (String str : collect
                ) {
                    if (Integer.parseInt(str.substring(0, 8).trim()) != Integer.parseInt(args[1])) {
                        fileWriter.write(str + "\n");
                    }
                }
                ;
            } else {
                System.out.println("Wrong params ");

            }
            fileWriter.close();
        }

    }
}
