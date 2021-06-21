package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Список и нити

В методе main добавить в статический объект list 5 нитей.
Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Requirements:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут


        SpecialThread o1  = new SpecialThread();
        SpecialThread o2 =  new SpecialThread();
        SpecialThread o3 = new SpecialThread();
        SpecialThread o4 = new SpecialThread();
        SpecialThread o5  = new SpecialThread();

       Thread thread1 = new Thread(o1);
       Thread thread2 = new Thread(o2);
       Thread thread3 = new Thread(o3);
       Thread thread4 = new Thread(o4);
       Thread thread5 = new Thread(o5);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
