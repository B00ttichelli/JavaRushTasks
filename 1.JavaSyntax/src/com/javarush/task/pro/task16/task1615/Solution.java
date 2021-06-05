package com.javarush.task.pro.task16.task1615;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/*
Ой как много методов!


В классе Solution реализуй шесть методов:
- в методе plusMinutes нужно увеличить параметр instant на minutes минут и вернуть результат;
 - в методе plusHours нужно увеличить параметр instant на hours часов и вернуть результат;
 - в методе plusDays нужно увеличить параметр instant на days дней и вернуть результат;
 - в методе minusMinutes нужно уменьшить параметр instant на minutes минут и вернуть результат;
 - в методе minusHours нужно уменьшить параметр instant на hours часов и вернуть результат;
  - в методе minusDays нужно уменьшить параметр instant на days дней и вернуть результат;

Requirements:
1. Метод plusMinutes нужно реализовать согласно условию.
2. Метод plusHours нужно реализовать согласно условию.
3. Метод plusDays нужно реализовать согласно условию.
4. Метод minusMinutes нужно реализовать согласно условию.
5. Метод minusHours нужно реализовать согласно условию.
6. Метод plusDays нужно реализовать согласно условию.


*/

public class Solution {

    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(10);
        System.out.println(instant);
        System.out.println(plusMinutes(instant, 2));
        System.out.println(plusHours(instant, 2));
        System.out.println(plusDays(instant, 2));
        System.out.println(minusMinutes(instant, 2));
        System.out.println(minusHours(instant, 2));
        System.out.println(minusDays(instant, 2));
    }

    static public Instant plusMinutes(Instant instant, long minutes) {
        //напишите тут ваш код

        return instant.plusSeconds(minutes*60);
    }

    static public Instant plusHours(Instant instant, long hours) {
        //напишите тут ваш код

        return instant.plusSeconds(hours*3600);
    }

    static public Instant plusDays(Instant instant, long days) {
        //напишите тут ваш код

        return instant.plusSeconds(days*86400);
    }

    static public Instant minusMinutes(Instant instant, long minutes) {
        //напишите тут ваш код

        return instant.minusSeconds(minutes*60);
    }

    static public Instant minusHours(Instant instant, long hours) {
        //напишите тут ваш код

        return instant.minusSeconds(hours*3600);
    }

    static public Instant minusDays(Instant instant, long days) {
        //напишите тут ваш код

        return instant.minusSeconds(days*86400);
    }
}
