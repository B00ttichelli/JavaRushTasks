package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton


Найти пример паттерна Singleton с ленивой реализацией (lazy initialization).
По образу и подобию в отдельных файлах создать в отдельных файлах три класса синглтона — Sun, Moon, Earth.
Реализовать интерфейс Planet в классах Sun, Moon, Earth.
В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet().
Реализовать функционал метода readKeyFromConsoleAndInitPlanet():
для этого считай с консоли один параметр типа String.
если он равен одной из констант интерфейса Planet, создай соответствующий объект и присвой его Planet thePlanet, иначе — обнули Planet thePlanet.

Requirements:
1. Класс Sun не должен позволять создавать объекты своего типа за пределами класса.
2. Класс Sun должен содержать приватное статическое поле instance типа Sun.
3. В классе Sun должен быть реализован публичный статический метод getInstance(), возвращающий значение поля instance.
4. Метод getInstance() в классе Sun должен всегда возвращать один и тот же объект.
5. Поле instance должно быть инициализировано только после первого обращения к методу getInstance().
6. Класс Moon не должен позволять создавать объекты своего типа за пределами класса.
7. Класс Moon должен содержать приватное статическое поле instance типа Moon.
8. В классе Moon должен быть реализован публичный статический метод getInstance(), возвращающий значение поля instance.
9. Метод getInstance() в классе Moon должен всегда возвращать один и тот же объект.
10. Поле instance должно быть инициализировано только после первого обращения к методу getInstance().
11. Класс Earth не должен позволять создавать объекты своего типа за пределами класса.
12. Класс Earth должен содержать приватное статическое поле instance типа Earth.
13. В классе Earth должен быть реализован публичный статический метод getInstance(), возвращающий значение поля instance.
14. Метод getInstance в классе Earth должен всегда возвращать один и тот же объект.
15. Поле instance должно быть инициализировано только после первого обращения к методу getInstance().
16. Метод readKeyFromConsoleAndInitPlanet() должен быть вызван в статическом блоке класса Solution.
17. Метод readKeyFromConsoleAndInitPlanet() должен считывать одну строку с клавиатуры.
18. Метод readKeyFromConsoleAndInitPlanet() должен корректно обновлять значение переменной thePlanet в соответствии с условием задачи.
19. Классы Sun, Moon и Earth должны быть созданы в отдельных файлах.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String in = bufferedReader.readLine();
        switch (in){
            case "earth":
                thePlanet = Earth.getInstance();
                break;
            case "moon":
                thePlanet = Moon.getInstance();
                break;
            case "sun":
                thePlanet = Sun.getInstance();
                break;
            default:
                thePlanet = null;
        }

    }
}
