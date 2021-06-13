package com.javarush.task.task11.task1115;

/* 
От школьника до пенсии
От школьника до пенсии
Измени четыре класса: Schoolboy (школьник), Student (студент), Worker (Сотрудник), Retiree (Пенсионер).
Унаследовать студента от школьника, сотрудника от студента, пенсионера от сотрудника.


Requirements:
1. В классе Solution должен быть public класс Schoolboy (школьник).
2. В классе Solution должен быть public класс Student (студент).
3. В классе Solution должен быть public класс Worker (Сотрудник).
4. В классе Solution должен быть public класс Retiree (Пенсионер).
5. Класс Student должен быть унаследован от класса Schoolboy.
6. Класс Worker должен быть унаследован от класса Student.
7. Класс Retiree должен быть унаследован от класса Worker.

*/

public class Solution {
    public static void main(String[] args) {
    }

    public class Schoolboy {

    }

    public class Student extends Schoolboy {

    }

    public class Worker extends Student{

    }

    public class Retiree extends Worker{

    }

}
