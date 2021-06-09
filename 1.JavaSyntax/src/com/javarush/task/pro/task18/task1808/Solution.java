package com.javarush.task.pro.task18.task1808;

import java.util.ArrayList;
import java.util.Collections;

/* 
Знакомство со ссылками на методы

В классе Solution публичный метод print(ArrayList<String>) выводит в консоли все элементы списка по порядку.
Сейчас метод реализован с использованием метода списка forEach(), который принимает лямбда-выражение.
Необходимо переписать реализацию метода print(ArrayList<String>), чтобы метод списка forEach() вместо лямбда-выражения принимал ссылку на метод.

Метод main() не принимает участие в тестировании.


Requirements:
1. В методе print(ArrayList<String>) нужно использовать метод списка forEach(), принимающий ссылку на метод.
2. В методе print(ArrayList<String>) нужно выводить в консоли все элементы полученного списка по порядку.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        Collections.addAll(strings, "Hello", "Amigo", "JavaRush", "CodeGym");

        print(strings);
    }

    public static void print(ArrayList<String> strings) {
        strings.forEach(System.out::println);
    }
}
