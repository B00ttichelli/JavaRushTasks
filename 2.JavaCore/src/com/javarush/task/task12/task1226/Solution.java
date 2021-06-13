package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать

Лазать, летать и бегать
Вот что тебе нужно сделать в этой задаче:
Внутри класса Solution создай интерфейс public interface CanFly (летать) с методом void fly().
Внутри класса Solution создай интерфейс public interface CanClimb (лазить по деревьям) с методом void climb().
Внутри класса Solution создай интерфейс public interface CanRun (бегать) с методом void run().
Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
Добавь интерфейсы классам Cat (кот), Dog (собака), Tiger (тигр), Duck (Утка).

Requirements:
1. Класс Solution должен содержать интерфейс CanFly с методом void fly().
2. Класс Solution должен содержать интерфейс CanClimb с методом void climb().
3. Класс Solution должен содержать интерфейс CanRun с методом void run().
4. Объект класса Cat должен уметь бегать (поддерживать интерфейс CanRun) и лазить по деревьям (поддерживать интерфейс CanClimb).
5. Объект класса Dog должен уметь бегать (поддерживать интерфейс CanRun).
6. Класс Tiger должен быть котом.
7. Объект класса Duck должен уметь бегать (поддерживать интерфейс CanRun) и летать (поддерживать интерфейс CanFly).
*/

public class Solution {

    public static void main(String[] args) {

    }

    public class Cat implements CanRun,CanClimb{
        @Override
        public void run() {

        }

        @Override
        public void climb() {

        }
    }

    public class Dog implements CanRun {
        @Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
        @Override
        public void run() {
            super.run();
        }

        @Override
        public void climb() {
            super.climb();
        }
    }

    public class Duck implements CanRun,CanFly {
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }

    public interface CanFly{
        void fly();
    }
    public interface CanRun{
        void run();
    }
    public interface CanClimb{
        void climb();
    }
}
