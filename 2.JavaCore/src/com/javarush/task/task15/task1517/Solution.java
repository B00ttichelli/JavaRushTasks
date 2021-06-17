package com.javarush.task.task15.task1517;

/* 
Статики и исключения
В статическом блоке выбрось Exception.
Нужно, чтобы класс не загрузился, и вместо значения переменной B появилось сообщение об ошибке:
Exception in thread "main" java.lang.ExceptionInInitializerError
at java.lang.Class.forName0(Native Method)
at java.lang.Class.forName(Class.java:186)
at com.intellij.rt.execution.application.AppMain.main(AppMain.java:113)
Caused by: java.lang.RuntimeException:
at com.javarush.task.task15.task1517.Solution.<clinit>(Solution.java:22)

Hint: Нужно погуглить причину, если получилось следующее:
java: initializer must be able to complete normally
java: unreachable statement


Requirements:
1. В классе Solution в статическом блоке должно возникать исключение (Exception).
2. Программа не должна ничего выводить на экран, кроме автоматического сообщения о возникшем исключении.
3. Программа не должна считывать данные с клавиатуры.
4. Класс Solution должен быть public.

*/

public class  Solution {
    public static int A = 0;
//  Может можно лутше например так
 /*   static {
        if(true){
            throw new ExceptionInInitializerError();
        }
    }*/

    static {
        try {
            Integer.parseInt("rrd");
        }catch (Exception e){
            throw new  ExceptionInInitializerError();
        }
    }

    public static int B = 5;

    public static void main (String[] args)  {
        System.out.println(B);
    }
}
