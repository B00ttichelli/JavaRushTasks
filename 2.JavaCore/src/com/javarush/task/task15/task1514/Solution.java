package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
Статики-1
В статическом блоке инициализируй labels пятью различными парами ключ-значение.


Requirements:
1. В классе Solution должен быть только один метод — main().
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.
*/

public class Solution {
  public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1D,"What");
        labels.put(2D,"a");
        labels.put(3D,"fuck");
        labels.put(4d,"is");
        labels.put(5d,"this?");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
