package com.javarush.task.pro.task13.task1321;

import java.util.Locale;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getTranslationForDayOfWeek("Вторник"));
        System.out.println(getTranslationForDayOfWeek("Пятница"));
        System.out.println(getTranslationForDayOfWeek("Высплюсенье"));
    }

    public static String getTranslationForDayOfWeek(String ru) {
        String en;
        String lowerinput = ru.toLowerCase();

        if (lowerinput.equals("понедельник")) {

            en = "Monday";
        } else if (lowerinput.equals("вторник")) {
            en = "Tuesday";
        } else if (lowerinput.equals("среда")) {
            en = "Wednesday";
        } else if (lowerinput.equals("четверг")) {
            en = "Thursday";
        } else if (lowerinput.equals("пятница")) {
            en = "Friday";
        } else if (lowerinput.equals("суббота")) {
            en = "Saturday";
        } else if (lowerinput.equals("воскресенье")) {
            en = "Sunday";
        } else {
            en = "Недействительный день недели";
        }

        return en;
    }



}