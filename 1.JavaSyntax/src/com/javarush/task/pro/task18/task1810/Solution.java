package com.javarush.task.pro.task18.task1810;

import java.util.ArrayList;
import java.util.Collections;

/* 
Преобразование списка в массив

Преобразование списка в массив
В классе Solution есть два публичных статических метода:

String[] toStringArray(ArrayList<String>), в котором нужно преобразовать список строк в массив строк и вернуть его;
Integer[] toIntegerArray(ArrayList<Integer>), в котором нужно преобразовать список чисел в массив чисел и вернуть его.
Для преобразования списка в массив используй метод списка toArray(), в который нужно передать ссылку на конструктор массива,
тип которого соответствует типу списка.
Метод main() не принимает участие в тестировании.


Requirements:
1. В методе toStringArray(ArrayList<String>) у полученного в качестве аргумента списка нужно вызывать метод toArray(),
 в который передается ссылка на конструктор массива, тип которого соответствует типу списка.
2. Нужно, чтобы метод toStringArray(ArrayList<String>) возвращал массив строк с теми же элементами и в том же порядке,
что и в полученном списке.
3. В методе toIntegerArray(ArrayList<Integer>) у полученного в качестве аргумента списка нужно вызывать метод toArray(),
в который передается ссылка на конструктор массива, тип которого соответствует типу списка.
4. Нужно, чтобы метод toIntegerArray(ArrayList<Integer>) возвращал массив чисел с теми же элементами и в том же порядке,
 что и в полученном списке.
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        Collections.addAll(strings, "Ты", "ж", "программист");

        ArrayList<Integer> integers = new ArrayList<Integer>();
        Collections.addAll(integers, 1000, 2000, 3000);

/*
        String[] stringArray = toStringArray(strings);
        for (String string : stringArray) {
            System.out.println(string);
        }

        Integer[] integerArray = toIntegerArray(integers);
        for (Integer integer : integerArray) {
            System.out.println(integer);
        }*/
    }
    // Раскоментировать при здаче
   /* public static String[] toStringArray(ArrayList<String> strings) {
        return strings.toArray(String[]::new);
    }

    public static Integer[] toIntegerArray(ArrayList<Integer> integers) {
        return integers.toArray(Integer[]::new);
    }*/
}
