package com.javarush.task.task22.task2213;


/*Нам понадобится еще 4 метода в классе Field:
а) void print() - объект будет отрисовывать на экран свое текущее состояние;
б) void removeFullLines() - будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз;
в) Integer getValue(int x, int y) - возвращает значение которое находится в матрице с координатами x и y; Реализацию метода мы напишем позже, а сейчас для того, чтобы программа скомпилировалась, верни в методе какое-нибудь значение, например, null.
г) void setValue(int x, int y, int value) - устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y.


Requirements:
1. В классе Field должен быть создан метод print без параметров.
2. В классе Field должен быть создан метод removeFullLines без параметров.
3. В классе Field должен быть создан метод getValue с двумя параметрами типа int.
4. В классе Field должен быть создан метод setValue c тремя параметрами типа int.
5. Метод print не должен возвращать значение.
6. Метод removeFullLines не должен возвращать значение.
7. Метод getValue должен возвращать значение типа Integer.
8. Метод setValue не должен возвращать значение..*/

public class Field {
    private int width;
    private int height;

    private int[][] matrix;

    public void print(){

    }
    public void removeFullLines(){

    }
    public Integer getValue(int x,int y){
        return null;

    }

    public void setValue(int x, int y, int value){
        matrix[x][y] = value;
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
