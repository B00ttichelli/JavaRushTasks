package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* 
Знакомство с тегами


Знакомство с тегами
Считай с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Requirements:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        String content = "";
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(consoleReader.readLine());
        consoleReader.close();
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[10];
        while (fileReader.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new char[10];
        }

        fileReader.close();
        content = sb.toString();


        String open = "<" + args[0];
        int openLen = open.length();
        String close = "</" + args[0] + ">";
        int closeLen = close.length();
        List<String> slices = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        deque.push(content);

        while (!deque.isEmpty()) {
            String poll = deque.poll();
            if (!poll.contains(open)) {
                continue;
            }
            String head = poll.substring(poll.indexOf(open) + openLen, poll.indexOf(close));
            String tail = poll.substring(poll.indexOf(close) + closeLen);

            int opensInHead = getEntryCount(head, open);

            StringBuilder headSb = new StringBuilder(head);
            while (opensInHead-- > 0) {
                String subTail = tail.substring(0, tail.indexOf(close));

                opensInHead += getEntryCount(subTail, open);
                headSb.append(close).append(subTail);
                tail = tail.substring(tail.indexOf(close) + closeLen);
            }
            head = headSb.toString();
            deque.push(tail);
            deque.push(head);
            slices.add(open + head + close);
        }

        for (String slice : slices) {
            System.out.println(slice);
        }

    }

    public static int getEntryCount(String string, String substring) {
        return (string.length() - string.replaceAll(substring, "").length()) / substring.length();
    }
}
