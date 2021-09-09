package com.javarush.task.task22.task2213;

import java.util.ArrayList;

/**
 * Класс Field описывает "поле клеток" игры Тетрис
 */


/*Напиши реализацию метода removeFullLines в классе Field.
        Надо:
        а) удалить все строки из матрицы, которые полностью заполнены (состоят из одних единиц);
        б) сместить оставшиеся строки вниз;
        в) создать новые строки взамен отсутствующих.

        ВАЖНО!
        matrix[y][x] содержит элемент с координатами (x,y).
        matrix[i] содержит i-ю строку.
        Мы можем:
        а) удалить стоку:
        matrix[i] = null
        б) скопировать [ссылку на] строку:
        matrix[i+1] = matrix[i];
        в) создать новую строку:
        matrix[i] = new int[width];


        Requirements:
        1. После выполнения метода removeFullLines в массиве matrix не должно остаться строк состоящих из одних единиц.
        2. Оставшиеся строки должны быть корректно перемещены, а вместо отсутствующих добавлены новые.*/

public class Field {
    //ширина и высота
    private int width;
    private int height;

    //матрица поля: 1 - клетка занята, 0 - свободна
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
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

    /**
     * Метод возвращает значение, которое содержится в матрице с координатами (x,y)
     * Если координаты за пределами матрицы, метод возвращает null.
     */
    public Integer getValue(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];

        return null;
    }

    /**
     * Метод устанавливает переданное значение(value) в ячейку матрицы с координатами (x,y)
     */
    public void setValue(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }

    /**
     * Метод печатает на экран текущее содержание матрицы
     */
    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] canvas = new int[height][width];

        //Копируем "матрицу поля" в массив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        //Копируем фигурку в массив, только непустые клетки
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }


        //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
    }

    /**
     * Удаляем заполненные линии
     */
    public void removeFullLines() {

        int[][] refresh = new int[height][width];
        int counter = height -1;
        for (int i = height-1; i >=0; i--) {
            boolean isFull = true;
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0){
                    isFull = false;
                    break;
                }

            }
            if(!isFull) {
                refresh[counter] = matrix[i];
                counter--;
            }
        }
        matrix = refresh;

    }
}
