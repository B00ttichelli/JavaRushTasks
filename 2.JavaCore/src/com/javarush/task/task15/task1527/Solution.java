package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

/* 
Парсер реквестов

Считать с консоли URL-ссылку.
Вывести на экран список всех параметров через пробел (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert():
alert(double value) - для чисел (дробные числа разделяются точкой);
alert(String value) - для строк.
Обрати внимание на то, что метод alert() необходимо вызывать после вывода списка всех параметров на экран.
Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14


Requirements:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert() с параметром double, если значение параметра obj можно корректно преобразовать в число типа double.
5. Программа должна вызывать метод alert() с параметром String, если значение параметра obj нельзя корректно преобразовать в число типа double.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String url = bufferedReader.readLine();
        String[] split1 = url.split("\\?");
        String[] split2 = split1[1].split("&");
        for (String s:split2
             ) {
            System.out.print(s.split("=")[0]+" ");

        }

        System.out.println();
        for (String s:split2){
            try {
                if(s.split("=")[0].equals("obj")){
                    alert(Double.parseDouble(s.split("=")[1]));
                }
            } catch (NumberFormatException e) {
                alert(s.split("=")[1]);
            }

        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
