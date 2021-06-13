package com.javarush.task.task13.task1309;

/* 
Всё, что движется

Всё, что движется
В этой задаче тебе нужно:
Создать интерфейс CanMove с методом speed.
Сделать так, чтобы speed возвращал значение типа Double и ничего не принимал в качестве аргументов.
Создать и унаследовать интерфейс CanFly от интерфейса CanMove.
Добавить в интерфейс CanFly метод speed.
Убедиться, что speed возвращает значение типа Double и принимает один параметр типа CanFly.

Requirements:
1. В классе Solution должен быть объявлен интерфейс CanMove.
2. В классе Solution должен быть объявлен интерфейс CanFly.
3. Интерфейс CanFly должен наследоваться от интерфейса CanMove.
4. В интерфейсе CanMove должен быть объявлен метод speed без параметров и с типом возвращаемого значения Double.
5. В интерфейсе CanFly должен быть объявлен метод speed c одним аргументом типа CanFly и с типом возвращаемого значения Double.

*/

public class Solution {
    public static void main(String[] args) throws Exception {

    }

    interface CanMove {
        Double speed ();
    }
    interface CanFly extends CanMove{
        Double speed(CanFly o);
    }
}