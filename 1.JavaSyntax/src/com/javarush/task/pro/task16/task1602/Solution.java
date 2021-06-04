package com.javarush.task.pro.task16.task1602;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Подчищаем хвосты
Метод fixDate принимает в качестве параметра список дат. Некоторые из них содержат две типичные ошибки:
неправильно сохраняются (и, следовательно, выводятся в консоли) год и месяц.
 То есть, неправильная дата содержит всегда две ошибки (год и месяц), которые тебе нужно исправить в методе fixDate, учитывая эти условия:
1. Если дата больше текущей, в ней нужно исправить эти две ошибки (год и месяц)
с помощью методов setYear, setMonth. Год задается с 1900, а месяцы нумеруются с нуля.
2. Если дата меньше текущей, в ней ничего исправлять не нужно.

Пример даты с ошибками:
Должно быть 25 декабря 2015 года, но на самом деле это другая дата.
Можно посмотреть вывод в консоль для этой даты - new Date(2015, 12, 25, 20, 40).


Requirements:
1. Если дата больше текущей, метод fixDate должен исправить ее год и месяц.
2. Если дата меньше текущей, метод fixDate не должен ее изменять.
3. Метод fixDate должен проверять и исправлять все даты из списка brokenDates.
*/

public class Solution {

    public static void main(String[] args) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(new Date(2015, 12, 25, 20, 40));
        dateList.add(new Date("July 20, 1969"));
        dateList.add(new Date(1989, 11, 9));
        dateList.add(new Date("January 1, 2000"));

        System.out.println("before fixes:");
        dateList.forEach(System.out::println);

        fixDate(dateList);

        System.out.println("after fixes:");
        dateList.forEach(System.out::println);
    }

    static void fixDate(List<Date> brokenDates) {
        Date current = new Date();
        for (Date brokenDate : brokenDates) {
            if (brokenDate.after(current)) {
                brokenDate.setYear(brokenDate.getYear() - 1900);
                brokenDate.setMonth(brokenDate.getMonth() - 1);
            }
        }
    }
}
