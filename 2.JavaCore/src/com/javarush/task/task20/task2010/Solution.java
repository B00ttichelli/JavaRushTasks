package com.javarush.task.task20.task2010;

import java.io.Serializable;

/* 
Как сериализовать что-то свое?


Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной.
Подсказка: для сериализации объекта нужно, чтобы все его поля поддерживали сериализацию.
Для многих класов из JRE это уже сделано. Но если класс написан тобой, то нужно это свойство добавить вручную.


Requirements:
1. Класс Object должен существовать внутри класса Solution.
2. Класс Solution.Object должен быть статическим.
3. Класс Solution.Object должен быть публичным.
4. Класс Solution.Object должен поддерживать интерфейс Serializable.
5. Класс Solution.String должен поддерживать интерфейс Serializable.
*/

public class Solution {
    public static class Object implements Serializable{
        public String string1;
        public String string2;
    }

    public static int stringCount;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++stringCount;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) {

    }
}
