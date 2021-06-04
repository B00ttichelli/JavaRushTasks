package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник:)

Проинициализируй переменную birthDate объектом Date с датой своего рождения.
Реализуй метод getDayOfWeek(Date date), чтобы он возвращал русское название дня недели аргумента date.

Requirements:
1. Переменная birthDate должна быть проинициализирована при объявлении.
2. Метод getDayOfWeek(Date date) должен возвращать русское название дня недели.
*/

public class Solution {

    static Date birthDate = new Date(76 ,03,15);

    public static void main(String[] args) {


        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        return new SimpleDateFormat("EEEE",new Locale("ru","RU")).format(date);
    }
}
