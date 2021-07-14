package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Requirements:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.


*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        FileWriter file2 = new FileWriter(args[1]);



        while (file1.ready()){
            String tmp = file1.readLine();
            String[] split = tmp.split(" ");
            for (String str :split
                 ) {
                if(!str.replaceAll("\\d","").equals(str)){
                    file2.write(str + " ");
                }
            }

        }

        file1.close();
        file2.close();
    }
}
