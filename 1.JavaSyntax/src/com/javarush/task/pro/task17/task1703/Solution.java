package com.javarush.task.pro.task17.task1703;

import java.util.ArrayList;

/* 
Космическая одиссея ч.1

Космическая одиссея ч.1
Перед тем, как космический корабль отправится бороздить просторы Вселенной,
необходимо пригласить на борт экипаж, который будет состоять из 2 людей, 1 собаки и 1 кота.
В методе createCrew() добавь необходимое количество экземпляров соответствующих классов в список astronauts.

Подсказка:
Чтобы добавить объекты разных классов в один список,
им нужен общий предок. Унаследуй интересующие тебя классы от Astronaut. Кто угодно может стать исследователем космоса :)


Requirements:
1. Классы Human, Dog и Cat должны наследоваться от Astronaut.
2. В список astronauts должно быть добавлено два объекта типа Human.
3. В список astronauts должен быть добавлен один объект типа Dog.
4. В список astronauts должен быть добавлен один объект типа Cat.
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
    }

    public static void createCrew(){
        //напишите тут ваш код
        Astronaut cat = new Cat();
        Astronaut dog = new Dog();
        Astronaut human1 = new Human();
        Astronaut human2 = new Human();
        astronauts.add(cat);
        astronauts.add(dog);
        astronauts.add(human1);
        astronauts.add(human2);
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}
