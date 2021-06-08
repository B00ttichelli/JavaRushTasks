package com.javarush.task.pro.task18.task1802;

import java.util.ArrayList;
import java.util.Collections;

/*Сортировка по возрасту
        В классе Solution есть статическое поле students, которое заполняется студентами (объектами типа Student) в методе main().
        У студента (класс Student) есть имя (поле name) и возраст (поле age). Нужно отсортировать в программе студентов по возрасту
         в убывающем порядке (от старшего к младшему).
        Для этого используется метод Collections.sort(ArrayList<Student>, Comparator<Student>), в который передается список студентов
        students и компаратор сортировки по убыванию возраста.

        Твоя задача — реализовать этот компаратор. Для этого в классе AgeComparator нужно
        имплементировать интерфейс Comparator<Student> и реализовать метод int compare(Student student1, Student student2),
         который возвращает числовое значение со следующими условиями:


        отрицательное число, если возраст студента student1 больше возраста студента student2;
        положительное число, если возраст студента student1 меньше возраста студента student2;
        0, если возраст студентов student1 и student2 одинаковый.
        Метод main() не принимает участие в тестировании.


        Requirements:
        1. В классе AgeComparator нужно реализовать интерфейс Comparator<Student>.
        2. В классе AgeComparator нужно создать публичный метод int compare(Student, Student).
        3. Метод compare(Student, Student) нужно реализовать согласно условию.*/

public class Solution {
    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(students,
                new Student("Иванов", 22),
                new Student("Петров", 18),
                new Student("Сидоров", 19)
        );

        Collections.sort(students, new AgeComparator());

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
