package com.javarush.task.pro.task16.task1609;

import java.time.LocalDate;

/* 
С годами моложе


В 2010 году человеку исполнилось 40 лет. Мы попытались вычислить год, когда ему исполнилось 30 лет,
 и программа выдала 2020 год. Как такое возможно? Измени один символ в коде, чтобы программа вывела 2000 год.

Requirements:
1. В коде нужно изменить один символ, чтобы программа вывела 2000 год.
*/

public class Solution {

    public static void main(String[] args) {
        LocalDate jubilee40Years = LocalDate.of(2010, 3, 13);

        LocalDate jubilee30Years = jubilee40Years.minusYears(10);

        System.out.println(Math.abs(jubilee30Years.getYear()));
    }
}
