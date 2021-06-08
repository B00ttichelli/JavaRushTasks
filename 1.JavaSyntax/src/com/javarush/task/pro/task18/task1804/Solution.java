package com.javarush.task.pro.task18.task1804;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Знакомство с лямбда-выражением


Перед тобой программа, которая сортирует список чисел по возрастанию.
Метод sortNumbers(ArrayList<Integer>) принимает список, элементы которого необходимо отсортировать.
 Для сортировки используется метод Collections.sort(ArrayList<Integer>, Comparator<Integer>), параметрами которого являются список чисел и компаратор.

Твоя задача — переписать реализацию метода sortNumbers(ArrayList<Integer>),
чтобы вместо использования внутреннего анонимного класса Comparator<Integer> использовалось лямбда-выражение.

Метод main() не принимает участие в тестировании.


Requirements:
1. Замени внутренний анонимный класс Comparator<Integer> на лямбда-выражение.
2. В методе sortNumbers(ArrayList<Integer>) нужно сортировать список чисел по возрастанию.
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        Collections.addAll(numbers, 123, -6, 12, 0, 44, 5678, -350);

        sortNumbers(numbers);

        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    public static void sortNumbers(ArrayList<Integer> numbers) {

        Collections.sort(numbers, (obj1,obj2)->obj1-obj2);
    }
}
