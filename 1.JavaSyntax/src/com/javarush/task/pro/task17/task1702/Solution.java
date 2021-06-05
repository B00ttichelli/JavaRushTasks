package com.javarush.task.pro.task17.task1702;

/* 
Геометрия для чайников


Классы Triangle, Rectangle и Circle — геометрические фигуры, поэтому они и унаследованы от класса Shape.
Переопредели в них метод printInfo(), чтобы в консоли выводилось название конкретной фигуры:
Для Triangle — "Треугольник";
Rectangle — "Прямоугольник";
Circle — "Круг".

Метод main() в тестировании участия не принимает.


Requirements:
1. Класс Shape не изменяй.
2. Классы геометрических фигур должны быть унаследованы от Shape.
3. В классах геометрических фигур должен быть переопределен метод printInfo().
4. Вызов метода printInfo() у объекта геометрической фигуры должен выводить в консоли ее название.


*/

public class Solution {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        shape.printInfo();
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
