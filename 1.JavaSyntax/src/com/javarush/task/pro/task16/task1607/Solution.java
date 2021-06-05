package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API

В классе Solution реализуй 4 метода: - метод nowExample должен вернуть текущую дату; -
остальные методы должны вернуть дату 12 сентября 2020 года, но разными способами.

Requirements:
1. Метод nowExample должен вернуть текущую дату.
2. Метод ofExample должен вернуть дату 12 сентября 2020 года с помощью метода LocalDate.of.
3. Метод ofYearDayExample должен вернуть дату 12 сентября 2020 года с помощью метода LocalDate.ofYearDay.
4. Метод ofEpochDayExample должен вернуть дату 12 сентября 2020 года с помощью метода LocalDate.ofEpochDay.
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код


        return LocalDate.now();
    }

    static LocalDate ofExample() {
        //напишите тут ваш код

        return LocalDate.of(2020,9,12);
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код

        return LocalDate.ofYearDay(2020,ofExample().getDayOfYear());
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код

        return LocalDate.ofEpochDay(ofExample().toEpochDay());
    }
}
