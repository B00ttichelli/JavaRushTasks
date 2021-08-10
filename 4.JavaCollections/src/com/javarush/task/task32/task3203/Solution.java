package com.javarush.task.task32.task3203;

import java.io.PrintWriter;
import java.io.StringWriter;

/* 
Пишем стек-трейс

Пишем стек-трейс
Реализуй логику метода getStackTrace, который в виде одной строки (одного объекта типа String) должен возвращать весь стек-трейс переданного исключения.
Используй подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
Метод main не участвует в тестировании.


Requirements:
1. Публичный статический метод String getStackTrace (Throwable) должен существовать.
2. В методе getStackTrace необходимо создать объект типа StringWriter.
3. В методе getStackTrace (Throwable) необходимо использовать метод класса Throwable, который принимает объект типа PrintWriter.
4. Метод getStackTrace (Throwable) должен возвращать весь стек-трейс переданного исключения.

*/

public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter  = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);

        return stringWriter.toString();
    }
}
