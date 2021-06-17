package com.javarush.task.task14.task1419;




import javax.xml.datatype.DatatypeConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.instrument.UnmodifiableClassException;
import java.rmi.AlreadyBoundException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;


/* 
Нашествие исключений

Нашествие исключений
Заполни список exceptions десятью различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Requirements:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями (потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }

    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        //так проще наверное
        exceptions.add(new InvalidKeyException());
        exceptions.add(new UnmodifiableClassException());
        exceptions.add(new RuntimeException());
        exceptions.add(new IllegalAccessException());
        exceptions.add(new DatatypeConfigurationException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new TooManyListenersException());
        exceptions.add(new IOException());
        exceptions.add(new AlreadyBoundException());




    }
}
