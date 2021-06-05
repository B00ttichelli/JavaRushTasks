package com.javarush.task.pro.task16.task1611;

import java.time.LocalTime;

/* 
Нужно просто посчитать


Нужно просто посчитать
Цикл while в методе main должен отработать ровно четыре раза, чтобы на экран вывелись 4 строки. Изменения можно вносить только в метод amazingMethod.

Requirements:
1. Метод amazingMethod должен быть изменен так, чтобы при запуске программа вывела 4 строки.
*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        LocalTime localTime = LocalTime.MIDNIGHT;
        System.out.println("Localtime "+localTime);
        LocalTime next = amazingMethod(localTime);
        while (next.isAfter(localTime)) {
            System.out.println(next);
            next = amazingMethod(next);
            Thread.sleep(500);
        }
    }

    static LocalTime amazingMethod(LocalTime base) {

        return base.plusMinutes(288);
    }
}
