package com.javarush.task.pro.task18.task1807;

import java.util.ArrayList;
import java.util.Collections;

/* 
Прощание с foreach
Прощание с foreach
В классе Solution публичный метод print(ArrayList<String>) выводит в консоли все элементы списка по порядку.
Сейчас метод реализован с использованием метода списка forEach(). Необходимо переписать реализацию метода print(ArrayList<String>),
 используя оператор for, не меняя логику работы метода.

Метод main() не принимает участие в тестировании.


Requirements:
1. В методе print(ArrayList<String>) нужно использовать оператор for.
2. В методе print(ArrayList<String>) не нужно использовать метод списка forEach().
3. В методе print(ArrayList<String>) нужно выводить в консоли все элементы полученного списка по порядку.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        Collections.addAll(strings, "Hello", "Amigo", "JavaRush", "CodeGym");

        print(strings);
    }

    public static void print(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));

        }
    }
}
