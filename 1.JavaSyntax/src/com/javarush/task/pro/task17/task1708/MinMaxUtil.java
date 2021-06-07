package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное

Минимальное и максимальное
В этой задаче тебе предстоит создать универсальный инструмент для поиска минимальных и максимальных чисел.
В классе MinMaxUtil создай публичные статические методы min() и max(), которые в качестве аргументов принимают целочисленные
 (тип int) значения и возвращают минимальное и максимальное из них соответственно.

Каждый из методов должен быть перегружен так, чтобы была возможность вызвать метод с двумя, тремя, четырьмя и пятью параметрами.
В общем, необходимо создать 8 методов, — 4 для min() и 4 для max().
Все аргументы методов должны быть типа int.


Requirements:
1. В классе MinMaxUtil должно быть создано 4 перегруженных метода min() в соответствии с условием задания.
2. В классе MinMaxUtil должно быть создано 4 перегруженных метода max() в соответствии с условием задания.
3. Методы min() должны возвращать минимальное из переданных чисел.
4. Методы max() должны возвращать максимальное из переданных чисел.

*/

public class MinMaxUtil {
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int min(int a, int b, int c) {
        return min(c, min(a, b));
    }

    public static int min(int a, int b, int c, int d) {
        return min(min(c, d), min(a, b));
    }

    public static int min(int a, int b, int c, int d, int e) {
        return min(e, min(min(c, d), min(a, b)));
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c) {
        return max(c, max(a, b));
    }

    public static int max(int a, int b, int c, int d) {
        return max(max(c, d), max(a, b));
    }

    public static int max(int a, int b, int c, int d, int e) {
        return max(e, max(max(c, d), max(a, b)));
    }
}