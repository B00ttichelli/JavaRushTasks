package com.javarush.task.pro.task16.task1618;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* 
Лишь бы не запутаться


Можно ли, зная время в одном часовом поясе, определить время в другом? Реши эту задачу в методе changeZone.
Его параметры: fromTime - известное время; fromZone - временная зона, в которой известно время;
toZone - временная зона, в которой нужно определить время.

Requirements:
1. Метод changeZone должен вернуть LocalDateTime во временной зоне toZone.
*/

public class Solution {

    public static void main(String[] args) {
        ZoneId zone1 = ZoneId.of("Zulu");
        ZoneId zone2 = ZoneId.of("Etc/GMT+8");
        System.out.println(ZonedDateTime.now(zone1));
        System.out.println(ZonedDateTime.now(zone2));

        LocalDateTime time = changeZone(LocalDateTime.of(2020, 3, 19, 1, 40), zone1, zone2);
        System.out.println(time);
    }

    static LocalDateTime changeZone(LocalDateTime fromDateTime, ZoneId fromZone, ZoneId toZone) {
        //напишите тут ваш код
        ZonedDateTime  from = fromDateTime.atZone(fromZone);
        ZonedDateTime  to = from.withZoneSameInstant(toZone);

        return to.toLocalDateTime();
    }
}
