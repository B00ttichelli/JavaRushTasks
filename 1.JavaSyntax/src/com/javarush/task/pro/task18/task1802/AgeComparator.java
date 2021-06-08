package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту

  отрицательное число, если возраст студента student1 больше возраста студента student2;
        положительное число, если возраст студента student1 меньше возраста студента student2;
        0, если возраст студентов student1 и student2 одинаковый.

*/

public class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge()>o2.getAge()){
          return -1;
        }else if (o1.getAge()<o2.getAge()){
            return 1;
        }else {
            return 0;
        }
    }
    //напишите тут ваш код
}
