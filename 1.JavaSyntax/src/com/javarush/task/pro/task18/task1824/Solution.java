package com.javarush.task.pro.task18.task1824;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/* 
Из потока данных — в map

Необходимо, чтобы метод getMap(Stream<String>) преобразовывал входящий поток строк в карту (map), ключом которой является сама строка, а значением — её длинна.
Реализуй его, используя метод collect() объекта типа Stream<String>.
 В качестве параметра передай нужный коллектор (объект типа Collector<Map<String, Integer>>).
 Такой объект можно получить, вызвав статический метод toMap() класса Collectors.

Метод main() не принимает участие в тестировании.


Requirements:
1. В публичном статическом методе getMap(Stream<String>) нужно вызывать статический метод toMap() класса Collectors.
2. Метод getMap(Stream<String>) нужно реализовать согласно условию.
*/

public class Solution {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("JavaRush", "CodeGym", "Amigo", "Elly", "Kim", "Risha");

        getMap(stringStream).forEach((s, i) -> System.out.println(s + " - " + i));
    }

    public static Map<String, Integer> getMap(Stream<String> stringStream) {
        //напишите тут ваш код
        return stringStream.collect(toMap(x-> x,x->x.length()));
    }
}
