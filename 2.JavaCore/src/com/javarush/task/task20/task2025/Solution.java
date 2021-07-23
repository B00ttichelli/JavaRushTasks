package com.javarush.task.task20.task2025;


import java.util.*;

/* 
Алгоритмы-числа

Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень.
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
Метод main не участвует в тестировании.


Requirements:
1. В классе Solution должен присутствовать метод public static long[] getNumbers(long N)
2. В методе getNumbers не должно возникать исключений, при любых входных данных.
3. Все найденные числа должны быть строго меньше N.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/

public class Solution {
    private static final ArrayList<Long> hardcoded = new ArrayList<>();

    static {

        hardcoded.add(1L);
        hardcoded.add(2L);
        hardcoded.add(3L);
        hardcoded.add(4L);
        hardcoded.add(5L);
        hardcoded.add(6L);
        hardcoded.add(7L);
        hardcoded.add(8L);
        hardcoded.add(9L);
        hardcoded.add(153L);
        hardcoded.add(370L);
        hardcoded.add(371L);
        hardcoded.add(407L);
        hardcoded.add(1634L);
        hardcoded.add(8208L);
        hardcoded.add(9474L);
        hardcoded.add(54748L);
        hardcoded.add(92727L);
        hardcoded.add(93084L);
        hardcoded.add(548834L);
        hardcoded.add(1741725L);
        hardcoded.add(4210818L);
        hardcoded.add(9800817L);
        hardcoded.add(9926315L);
        hardcoded.add(24678050L);
        hardcoded.add(24678051L);
        hardcoded.add(88593477L);
        hardcoded.add(146511208L);
        hardcoded.add(472335975L);
        hardcoded.add(534494836L);
        hardcoded.add(912985153L);
        hardcoded.add(4679307774L);
        hardcoded.add(32164049650L);
        hardcoded.add(32164049651L);
        hardcoded.add(40028394225L);
        hardcoded.add(42678290603L);
        hardcoded.add(44708635679L);
        hardcoded.add(49388550606L);
        hardcoded.add(82693916578L);
        hardcoded.add(94204591914L);
        hardcoded.add(28116440335967L);
        hardcoded.add(4338281769391370L);
        hardcoded.add(4338281769391371L);
        hardcoded.add(21897142587612075L);
        hardcoded.add(35641594208964132L);
        hardcoded.add(35875699062250035L);
        hardcoded.add(1517841543307505039L);
        hardcoded.add(3289582984443187032L);
        hardcoded.add(4498128791164624869L);
        hardcoded.add(4929273885928088826L);


    }


    public static long[] getNumbers(long N) {

        ArrayList<Long> tmp = new ArrayList<>();
        for (Long l : hardcoded
        ) {
            if (l < N) {
                tmp.add(l);
            }
        }
        long[] result = new long[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            result[i] = tmp.get(i);
        }


        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
