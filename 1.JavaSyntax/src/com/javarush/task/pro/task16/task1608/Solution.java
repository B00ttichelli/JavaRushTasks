package com.javarush.task.pro.task16.task1608;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Просто день недели

Реализуй метод getDayOfWeek(LocalDate date), чтобы он возвращал русское название дня недели аргумента date.
 Воспользуйся методами getDayOfWeek и getDisplayName. Пример параметров метода getDisplayName,
 чтобы получить русское название дня недели: getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"))

Requirements:
1. Метод getDayOfWeek(LocalDate date) должен возвращать день недели на русском.
2. Чтобы получить название дня недели, нужно использовать методы getDayOfWeek и getDisplayName.
*/

public class Solution {

    static LocalDate birthDate = LocalDate.of(2020, 3, 12);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(LocalDate date) {
        //напишите тут ваш код

        return date.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.forLanguageTag("ru"));




    }
}
