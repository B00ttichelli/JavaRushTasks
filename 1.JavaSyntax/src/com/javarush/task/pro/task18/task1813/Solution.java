package com.javarush.task.pro.task18.task1813;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/* 
Будущее за электрокарами

Будущее за электрокарами
Современный мир отказывается от двигателей внутреннего сгорания, и эра электрокаров не за горами. Нужно, чтобы наша программа могла отфильтровать электрокары от всех остальных автомобилей.
Для этих целей есть метод onlyElectricCars(ArrayList<Car>), который фильтрует список автомобилей, получаемых в качестве входящего параметра. Этот метод возвращает поток отфильтрованных данных, а именно — поток автомобилей, у которых поле isElectric равно true. В этом тебе поможет метод filter() объекта типа Stream<Car>.

Метод main() не принимает участие в тестировании.


Requirements:
1. В публичном статическом методе onlyElectricCars(ArrayList<Car>) нужно вызывать метод filter() объекта типа Stream<Car>.
2. Нужно, чтобы метод onlyElectricCars(ArrayList<Car>) возвращал поток электрокаров.
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();
        Collections.addAll(cars,
                new Car("Range Rover", false),
                new Car("Model S", true),
                new Car("Navigator", false),
                new Car("Model 3", true),
                new Car("Camaro", false),
                new Car("Escalade", false),
                new Car("Mustang", false),
                new Car("Model X", true),
                new Car("X5", false),
                new Car("Model Y", true));

        Stream<Car> carStream = onlyElectricCars(cars);
        carStream.forEach(System.out::println);
    }

    public static Stream<Car> onlyElectricCars(ArrayList<Car> cars) {
        //напишите тут ваш код
        return cars.stream().filter((s)-> s.isElectric());
    }
}
