package com.javarush.task.task13.task1325;

import java.awt.*;

/* 
Компиляция программы


Исправь классы Fox и BigFox так, чтобы программа компилировалась.
В решении этой задачи не нужно создавать экземпляры базового класса.
Метод main не изменяй.


Requirements:
1. Интерфейс Animal должен быть реализован в классе Fox.
2. В классе Fox должен быть реализован только один метод — getName().
3. В интерфейсе Animal должен быть объявлен метод getColor().
4. Класс BigFox должен быть потомком класса Fox.
5. Класс Fox должен быть абстрактным.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());
    }

    public interface Animal {
        Color getColor();
    }

    public abstract static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }

    public static class BigFox extends Fox{

        @Override
        public Color getColor() {
            return null;
        }
    }

}
