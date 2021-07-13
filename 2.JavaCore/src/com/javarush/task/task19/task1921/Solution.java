package com.javarush.task.task19.task1921;

import javax.swing.text.DateFormatter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович

Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Requirements:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {



/// ЭТО КРАСИВОЕ И ЭЛЕГАНТНОЕ РЕШЕНИЕ НЕ ПРОХОДИТ ВАЛИДАТОР
/*
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()){
            String tmp = bufferedReader.readLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy",Locale.ENGLISH);
            PEOPLE.add(new Person(tmp.replaceAll("\\d",""),simpleDateFormat.parse(tmp.replaceAll("\\D",""))));
        }
        bufferedReader.close();*/

        // Валидатор просит немного говнокода и мы ему его дадим с кучей цыклов и прочим говном Слава Явараш !!!


        BufferedReader  bufferedReader  = new BufferedReader(new FileReader(args[0]));

        while (bufferedReader.ready()){

            String[] split = bufferedReader.readLine().split(" ");
            StringJoiner  name = new StringJoiner(" ");
            StringJoiner  date = new StringJoiner("/");

            for (int i = 0; i < split.length-3; i++) {
                name.add(split[i]);
            }

            for (int i = split.length-3; i < split.length ; i++) {
                date.add(split[i]);
            }

            PEOPLE.add(new Person(name.toString(),new SimpleDateFormat("dd/MM/yyyy").parse(date.toString())));
        }
        bufferedReader.close();

    }
}
