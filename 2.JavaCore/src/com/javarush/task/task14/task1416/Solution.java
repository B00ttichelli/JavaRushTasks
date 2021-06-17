package com.javarush.task.task14.task1416;

/* 
Исправление ошибок Ӏ Java Core: 4 уровень, 8 лекция


Давай напишем программу, которая определит, что умеют делать жители океана:
Подумай, как связаны интерфейсы Swimmable (способен плавать) и Walkable (способен ходить) с классом OceanAnimal (животное океана).
Правильно расставь наследование интерфейсов и класса OceanAnimal.
Подумай, как могут быть связаны классы Orca (Косатка), Whale (Кит), Otter (Выдра) с классом OceanAnimal.
Расставь правильно наследование между классами Orca, Whale, Otter и классом OceanAnimal.
Подумай, какой класс должен реализовать интерфейс Walkable и добавить интерфейс этому классу.
Подумай, какое животное еще не умеет плавать и добавить ему интерфейс Swimmable.

Requirements:
1. Косатка (Orca) является животным океана (потомком OceanAnimal) и умеет плавать (поддерживает интерфейс Swimmable).
2. Кит (Whale) является животным океана (потомком OceanAnimal) и умеет плавать (поддерживает интерфейс Swimmable).
3. Выдра (Otter) умеет ходить (поддерживает интерфейс Walkable) и плавать (поддерживает интерфейс Swimmable).
4. Выдра (Otter) НЕ является животным океана (потомком OceanAnimal).
5. Кит (Whale) и Косатка (Orca) НЕ умеют ходить (не поддерживают интерфейс Walkable).
*/

public class Solution {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    interface Walkable {
        void walk();
    }

    interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.displaySwim();
        }

        private void displaySwim() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal implements Swimmable{
        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Whale extends OceanAnimal implements Swimmable {

        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Otter implements Swimmable,Walkable {

        @Override
        public void walk() {

        }

        @Override
        public void swim() {

        }
    }
}
