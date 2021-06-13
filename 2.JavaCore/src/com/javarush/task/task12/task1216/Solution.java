package com.javarush.task.task12.task1216;

/* 
Летать охота

Напиши свой public интерфейс CanFly(летать).
Добавь в него два метода.


Requirements:
1. Класс Solution должен содержать интерфейс CanFly.
2. Интерфейс CanFly должен быть публичным.
3. Интерфейс CanFly должен содержать два метода.
4. У интерфейса CanFly не должно быть родителя.
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add an interface here - добавь интерфейс тут
    public interface CanFly{
        void fly();
        void land();
    }
}
