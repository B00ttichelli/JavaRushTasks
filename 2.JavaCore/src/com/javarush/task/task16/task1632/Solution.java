package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок


Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()


Requirements:
1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfinityThread());
        threads.add(new InterruptedPrintThread());
        threads.add(new SayUraThread());
        threads.add(new MessageThread());
        threads.add(new NumberReaderThread());
    }

    public static void main(String[] args) {

        threads.get(4).start();
    }

    public static class InfinityThread extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class InterruptedPrintThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class SayUraThread extends Thread {
        @Override
        public void run() {

            while (true){

                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        private boolean flag;

        @Override
        public void showWarning() {
            flag = true;
        }

        @Override
        public void run() {
           while (true){
               if (currentThread().isAlive() && flag == true) {
                   break;
               }
           }
        }
    }

    public static class NumberReaderThread extends Thread {   //переписать по нормальном
        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            Integer sum = 0;
            try {
                input = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (!input.equals("N")) {
                sum += Integer.parseInt(input);
                try {
                    input = bufferedReader.readLine();
                } catch (IOException e) {
                    System.out.println(sum);
                    break;

                }
            }
            System.out.println(sum);
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}