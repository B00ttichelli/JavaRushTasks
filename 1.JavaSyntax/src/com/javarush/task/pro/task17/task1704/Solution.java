package com.javarush.task.pro.task17.task1704;

import java.util.ArrayList;

/* 
Космическая одиссея ч.2

Все члены экипажа космического корабля находятся на борту, корабль успешно вышел в открытый космос.
Команде пора приступить к выполнению своих обязанностей:
Людям — пилотировать корабль, Собаке — заниматься навигацией, а Коту — исследовать открытый космос.

Распредели обязанности членов экипажа в методе runWorkingProcess().

Для этого достань из списка astronauts всех людей (ты знаешь, под какими индексами они находятся) и передай их в
 качестве аргументов методу pilot(Human human), собаку передай в метод createDirection(Dog dog), а кота — в метод research(Cat cat).
Другие методы не изменяй.

Подсказка:
Список astronauts содержит объекты типа Astronaut. Чтобы вызвать методы pilot(), createDirection() и research(),
сначала объект Astronaut нужно привести к правильному типу.


Requirements:
1. Метод runWorkingProcess() должен вызывать pilot(Human human) 2 раза. В качестве аргументов передать все объекты типа Human из списка astronauts.
2. Метод runWorkingProcess() должен вызывать createDirection(Dog dog) 1 раз. В качестве аргумента передать объект типа Dog из списка astronauts.
3. Метод runWorkingProcess() должен вызывать research(Cat cat) 1 раз. В качестве аргумента передать объект типа Cat из списка astronauts.
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
        runWorkingProcess();
    }

    public static void runWorkingProcess() {
        pilot((Human) astronauts.get(0));
        pilot((Human) astronauts.get(1));
        createDirection((Dog) astronauts.get(2));
        research((Cat) astronauts.get(3));
    }

    public static void pilot(Human human){
        System.out.println("Член экипажа " + human.getInfo() + " пилотирует корабль.");
    }

    public static void createDirection(Dog dog){
        System.out.println("Член экипажа " + dog.getInfo() + " занимается созданием навигационного маршрута.");
    }

    public static void research(Cat cat){
        System.out.println("Член экипажа " + cat.getInfo() + " исследует ближайшие планеты.");
    }

    public static void createCrew() {
        astronauts.add(new Human());
        astronauts.add(new Human());
        astronauts.add(new Dog());
        astronauts.add(new Cat());
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}
