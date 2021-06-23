package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию

В этой задаче тебе нужно:
Создать 7 public полей класса:
intVar типа int
doubleVar типа double
DoubleVar типа Double
booleanVar типа boolean
ObjectVar типа Object
ExceptionVar типа Exception
StringVar типа String
Убедиться, что они инициализируются дефолтными значениями.
Вывести их значения в заданном порядке в методе main()

Requirements:
1. В классе Solution должно быть объявлено поле intVar типа int.
2. В классе Solution должно быть объявлено поле doubleVar типа double.
3. В классе Solution должно быть объявлено поле DoubleVar типа Double.
4. В классе Solution должно быть объявлено поле booleanVar типа boolean.
5. В классе Solution должно быть объявлено поле ObjectVar типа Object.
6. В классе Solution должно быть объявлено поле ExceptionVar типа Exception.
7. В классе Solution должно быть объявлено поле StringVar типа String.
8. Метод main должен выводить значения полей на экран (каждое — с новой строки или через пробел)
 в заданном порядке. Инициализировать переменные не нужно.

*/



public class Solution {

   /* intVar типа int
    doubleVar типа double
    DoubleVar типа Double
    booleanVar типа boolean
    ObjectVar типа Object
    ExceptionVar типа Exception
    StringVar типа String*/


    public  int intVar ;
    public  double doubleVar;
    public  Double DoubleVar;
    public  boolean booleanVar;
    public  Object ObjectVar;
    public  Exception ExceptionVar;
    public  String StringVar;

    public static void main(String[] args) {
        printAll(new Solution());
    }
    public static void printAll(Solution o){
        System.out.print(o.intVar+" "+o.doubleVar+" "+o.DoubleVar+" "+o.booleanVar+" "+o.ObjectVar+ " "+o.ExceptionVar+" "+o.StringVar);

    }
}