package com.javarush.task.pro.task16.task1619;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* 
Простой шаблон

В методе main выведи на экран переменную localDateTime в таком виде: 19.03.2020г. 5ч.4мин
*/

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.now();

    public static void main(String[] args) {
        System.out.println(DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mмин").format(localDateTime));
    }
}
