package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Valerio",2.6);
        grades.put("Antonio",3.7);
        grades.put("Andrea",7.4);
        grades.put("Sergio",8.9);
        grades.put("Pinokio",2.0);
    }
}
