package com.javarush.task.task14.task1403;

/* 
Building и School


Building и School
В этой задаче тебе нужно:
Правильно расставить наследование между Building (здание) и School (здание школы).
Подумать, объект какого класса должны возвращать методы getSchool и getBuilding.
Изменить null на объект класса Building или School.
Сигнатуры методов getSchool() и getBuilding() не меняй.


Requirements:
1. Класс School должен наследоваться от класса Building.
2. Метод getSchool() должен возвращать новую школу (School).
3. Метод getBuilding() должен возвращать новое здание (Building).
4. Класс School должен быть статическим.
5. Класс Building должен быть статическим.
*/

public class Solution {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return new School();
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return new Building();
    }

    static class School extends Building/*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "Building";
        }
    }
}
