package com.javarush.task.task12.task1207;

/* 
Int и Integer

1. Класс Solution должен содержать статический метод main().
2. Класс Solution должен содержать статический void метод print() с параметром типа int.
3. Класс Solution должен содержать статический void метод print() с параметром типа Integer.
4. Метод main() должен вызывать метод print() с параметром типа int.
5. Метод main() должен вызывать метод print() с параметром типа Integer.
*/

public class Solution {
    public static void main(String[] args) {
        Integer x =1030940294;
        print(x);
        print((int)x);
    }

    //Напишите тут ваши методы
    static void print(Integer x){
        System.out.println(x);
    }
    static void print (int x){
        System.out.println(x);
    }
}
