package com.javarush.task.task18.task1823;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/* 
Нити и байты

Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Requirements:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.

*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> fileList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (bufferedReader.ready()){
            String file = bufferedReader.readLine();
            if(file.equals("exit")){
                break;
            }else {
                fileList.add(file);
            }
        }
        bufferedReader.close();
        for (String file :fileList
             ) {
            ReadThread read = new ReadThread(file);

        }

    }

    public static class ReadThread extends Thread {
            private String filename;

        public ReadThread(String fileName) {
            //implement constructor body
            this.filename = fileName;
            start();
        }

        @Override
        public void run() {
            Integer maxbyte = 0;
            try {
                maxbyte = countBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (resultMap) {
                resultMap.put(filename, maxbyte);
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
        private Integer countBytes () throws IOException {
            FileInputStream fileInputStream = new FileInputStream(filename);
            int []  arr = new int[256];
            while (fileInputStream.available()>0){
                arr[fileInputStream.read()]++;
            }
            int maxindex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[maxindex]<arr[i]){
                    maxindex = i;
                }
            }
            fileInputStream.close();
                return maxindex;
        }
    }
}
