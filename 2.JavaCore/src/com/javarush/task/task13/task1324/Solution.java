package com.javarush.task.task13.task1324;

import java.awt.*;

/* 
Один метод в классе


Один метод в классе
Унаследуй Fox от интерфейса Animal.
Поменяй код так, чтобы в классе Fox был только один метод - getName.
Учти, что методы удалять нельзя.


Requirements:
1. Интерфейс Animal должен быть реализован в классе Fox.
2. В классе Fox должен быть реализован только один метод — getName.
3. В интерфейсе Animal должен быть объявлен метод getColor.
4. Дополнительные классы или интерфейсы создавать нельзя.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();

        Integer getAge();
    }

    public abstract static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}
