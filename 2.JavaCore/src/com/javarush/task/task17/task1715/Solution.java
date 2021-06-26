package com.javarush.task.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Аптека


Аптека
Реализуй интерфейс Runnable в классах Apteka и Person.
Все нити должны работать пока не isStopped.
Логика для Apteka: drugsController должен сделать продажу (вызвать метод void sell(Drug drug, int count)) случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 300 мс.
Логика для Person: drugsController должен сделать покупку (вызвать метод void buy(Drug drug, int count)) случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 100 мс.
Расставь synchronized там, где это необходимо.


Requirements:
1. Класс Solution должен содержать public static поле drugsController типа DrugsController.
2. Класс Solution должен содержать public static поле isStopped типа boolean.
3. Класс Solution должен содержать private static void метод waitAMoment(), который должен ждать 100 мс.
4. Класс Apteka должен реализовывать интерфейс Runnable.
5. Нить Apteka должна работать пока isStopped = false.
6. Нить Apteka должна использовать drugsController для продажи случайного лекарства (getRandomDrug) в количестве (getRandomCount).
7. Нить Apteka должна ждать 300мс между продажами, используя метод waitAMoment().
8. Класс Person должен реализовывать интерфейс Runnable.
9. Нить Person должна работать пока isStopped = false.
10. Нить Person должна использовать drugsController для покупки случайного лекарства (getRandomDrug) в количестве (getRandomCount).
11. Нить Person должна ждать 100мс между покупками, используя метод waitAMoment().
12. Методы класса DrugsController должны быть synchronized.
*/

public class Solution {
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka(), "Apteka");
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka implements Runnable {

        @Override
        public void run() {
            while (!isStopped){
                drugsController.sell(getRandomDrug(),getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }
        }
    }

    public static class Person implements Runnable {
        @Override
        public void run() {
            while (!isStopped){
                drugsController.buy(getRandomDrug(),getRandomCount());
                waitAMoment();
            }
        }
    }

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (DrugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(DrugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
