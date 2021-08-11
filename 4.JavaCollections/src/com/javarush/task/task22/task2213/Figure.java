package com.javarush.task.task22.task2213;


/*Также нам понадобятся методы для управления фигуркой.

Добавь в класс Figure методы:
left() - для движения фигурки влево.
right() - для движения фигурки вправо.
down() - для движения фигурки вниз.
up() - для движения фигурки вверх.
rotate() - для поворота фигурки вокруг главной диагонали.
downMaximum() - падение фигурки вниз до дна.
boolean isCurrentPositionAvailable() - проверка - может ли фигурка быть помещена в текущую позицию. Для теста захардкодь результат в true, пока мы не реализовали логику.
landed() - вызывается, когда фигурка достигла дна или уперлась в другую фигурку
Все ее занятые клетки теперь должны добавиться в Field.


Requirements:
1. В классе Figure должен быть создан метод left без параметров.
2. В классе Figure должен быть создан метод right без параметров.
3. В классе Figure должен быть создан метод down без параметров.
4. В классе Figure должен быть создан метод up без параметров.
5. В классе Figure должен быть создан метод rotate без параметров.
6. В классе Figure должен быть создан метод downMaximum без параметров.
7. В классе Figure должен быть создан метод isCurrentPositionAvailable без параметров.
8. В классе Figure должен быть создан метод landed без параметров.
9. Метод isCurrentPositionAvailable должен возвращать true.*/

public class Figure {

    private int x;
    private int y;
    private int[][] matrix;


    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public void left() {

    }

    public void right() {

    }

    public void down() {

    }

    public void up() {

    }

    public void rotate() {

    }

    public void downMaximum(){

    }

    public boolean isCurrentPositionAvailable(){
        return true;
    }

    public void landed(){
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
