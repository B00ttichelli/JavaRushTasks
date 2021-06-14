package com.javarush.task.task13.task1311;

/* 
Нанимаем переводчика


В этой задаче нужно:
Создать класс EnglishTranslator, который наследуется от Translator.
Реализовать все абстрактные методы.
Подумай, что должен возвращать метод getLanguage.
Сделать так, чтобы программа выводила: "Я переводчик с английского" путем вызова метода translate у объекта типа EnglishTranslator.

Requirements:
1. Класс EnglishTranslator нужно объявить внутри класса Solution.
2. Класс EnglishTranslator должен наследоваться от класса Translator.
3. В классе EnglishTranslator должны быть реализованы все унаследованные от класса Translator абстрактные методы.
4. Метод getLanguage должен возвращать строку, которая позволит выполнить условие задачи.
5. Метод main должен выводить на экран строку: "Я переводчик с английского" путем вызова метода translate у объекта типа EnglishTranslator.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        EnglishTranslator englishTranslator = new EnglishTranslator();
        System.out.println(englishTranslator.translate());
    }

    public static abstract class Translator {
        public abstract String getLanguage();

        public String translate() {
            return "Я переводчик с " + getLanguage();
        }
    }
    public static class EnglishTranslator extends Translator{
        @Override
        public String getLanguage() {
            return "английского";
        }
    }

}