package com.javarush.task.pro.task18.task1805;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Прощание с лямбда-выражением
Перед тобой программа, которая сортирует список строк по их длине по возрастанию.
Это делает метод sortStringsByLength(ArrayList<String>). Для сортировки строк используется метод Collections.sort(ArrayList<String>, Comparator<String>),
который принимает список строк и компаратор в виде лямбда-выражения.

Твоя задача — переписать реализацию метода sortStringsByLength(ArrayList<String>), чтобы вместо лямбда-выражения использовался
класс StringComparator, который реализует интерфейс Comparator<String>, не меняя логику работы метода sortStringsByLength(ArrayList<String>).

То есть нужно, чтобы в классе StringComparator метод int compare(String s1, String s2) возвращал числовое значение согласно этим условиям:

отрицательное число, если длина строки s1 меньше длины строки s2;
положительное число, если длина строки s1 больше длины строки s2;
0, если длины строк s1 и s2 одинаковы.
Метод main() не принимает участие в тестировании.


Requirements:
1. В отдельном файле нужно создать публичный класс StringComparator, который реализует интерфейс Comparator<String>.
2. В классе StringComparator нужно создать публичный метод int compare(String s1, String s2).
3. Метод compare(String s1, String s2) нужно реализовать согласно условию.
4. В методе sortStringsByLength(ArrayList<String>) нужно сортировать список строк по возрастанию их длины.
5. В методе sortStringsByLength(ArrayList<String>) для сортировки списка строк по возрастанию их длины нужно использовать
собственный компаратор (объект типа StringComparator).
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();

        Collections.addAll(strings, "JavaRush", "Amigo", "Java Developer", "CodeGym");

        sortStringsByLength(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void sortStringsByLength(ArrayList<String> strings) {
        Comparator<String> comparator = new StringComparator();
        Collections.sort(strings, comparator);
    }
}
