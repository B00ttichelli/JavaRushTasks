package com.javarush.task.pro.task17.task1710;

/* 
От абстракции к реальности

Класс Person объявлен как абстрактный. Это значит, что мы не можем создавать его экземпляры.
Сделай из данного класса обычный, допиши недостающую логику, которая отвечает общепринятым подходам к инкапсуляции:
геттеры должны возвращать, а сеттеры — устанавливать значения соответствующим полям.


Requirements:
1. Класс Person не должен быть абстрактным.
2. Метод getName() должен возвращать значение поля name.
3. Метод setName(String) должен устанавливать переданное значение полю name.
4. Метод getAge() должен возвращать значение поля age.
5. Метод setAge(int) должен устанавливать переданное значение полю age.
*/

public  class Person {
    private String name;
    private int age;

    public  String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public  void setAge(int age){
        this.age = age;
    }
}
