package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Отслеживаем изменения
читать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0


[LineItem{type=SAME, line='строка1'},
 LineItem{type=REMOVED, line='строка2'},
LineItem{type=SAME, line='строка3'},
 LineItem{type=REMOVED, line='строка4'},
  LineItem{type=SAME, line='строка5'},
  LineItem{type=ADDED, line='строка0'},
   LineItem{type=SAME, line='строка1'},
 LineItem{type=REMOVED, line='строка2'},
  LineItem{type=SAME, line='строка3'},
  LineItem{type=ADDED, line='строка4'},
   LineItem{type=SAME, line='строка5'}]
Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Requirements:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.


*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        ArrayList<String> old = fileToList(file1);
        ArrayList<String> updated = fileToList(file2);
        Set<String> allLines = new HashSet<>();
        allLines.addAll(old);
        allLines.addAll(updated);
        int counterForOld = 0 ;
        int counterForNew = 0;
        while (counterForOld<old.size()&&counterForNew<updated.size()){

            if (old.get(counterForOld).equals(updated.get(counterForNew))){
                lines.add(new LineItem(Type.SAME,old.get(counterForOld)));
                counterForNew++;
                counterForOld++;
            }else {
                if(old.get(counterForOld+1).equals(updated.get(counterForNew))){
                    lines.add(new LineItem(Type.REMOVED,old.get(counterForOld)));
                    counterForOld++;
                }else if(old.get(counterForOld).equals(updated.get(counterForNew+1))){
                    lines.add(new LineItem(Type.ADDED,updated.get(counterForNew)));
                    counterForNew++;
                }
            }
        }
        while (counterForOld<old.size()){
            lines.add(new LineItem(Type.REMOVED,old.get(counterForOld)));
            counterForOld++;
        }
        while (counterForNew<updated.size()){
            lines.add(new LineItem(Type.ADDED,updated.get(counterForNew)));
            counterForNew++;
        }

        file1.close();
        file2.close();
        System.out.println(lines);

    }



    public static ArrayList<String> fileToList (BufferedReader file) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        while (file.ready()){
            result.add(file.readLine());
        }
        return result;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }
}
