package com.javarush.task.pro.task16.task1616;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

/* 
Тренировка временных зон

Тренировка временных зон
Что общего у всех временных зон и Пекина? Правильно! Они позволят нам потренироваться в
использовании классов ZoneId и ZonedDateTime :) Реализуй два метода: - в методе getSortedZones верни множество TreeSet всех временных зон;
 - в методе getBeijingTime верни текущее время в Пекине (временная зона для него — "Asia/Shanghai").

Requirements:
1. Метод getSortedZones должен вернуть множество всех временных зон.
2. Метод getBeijingTime должен вернуть текущее время в Пекине.
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingTime());
    }

    static TreeSet<String> getSortedZones() {
        Set<String> set  = ZoneId.getAvailableZoneIds();
        TreeSet<String> result = new TreeSet<>(set);
        return result ;
    }

    static ZonedDateTime getBeijingTime() {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime result = ZonedDateTime.now(zoneId);
        return result ;
    }
}
