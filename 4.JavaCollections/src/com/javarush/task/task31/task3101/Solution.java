package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/* 
Проход по дереву файлов


Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Requirements:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[1]);
        File renamedFile = new File(file.getParentFile() + "/allFilesContent.txt");
        FileUtils.renameFile(file,renamedFile);
        File folder = new File(args[0]);
        Queue<File> files = new PriorityQueue<>();
        Collections.addAll(files, Objects.requireNonNull(folder.listFiles()));
        Map<String, String> fileList = new TreeMap<>();


        while (!files.isEmpty()) {
            File current = files.remove();
            if (current.isDirectory()) {
                Collections.addAll(files, Objects.requireNonNull(current.listFiles()));
            } else if (current.length()<=50) {
                fileList.put(current.getName(), current.getAbsolutePath());
            }
        }
        byte[] endLine = "\n".getBytes(StandardCharsets.UTF_8);
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(renamedFile,true);
        for (Map.Entry<String,String> entry : fileList.entrySet()
             ) {
            fileInputStream = new FileInputStream(entry.getValue());
            byte [] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            fileOutputStream.write(data);
            fileOutputStream.write(endLine);
            fileInputStream.close();
        }

        fileOutputStream.close();
    }
}
