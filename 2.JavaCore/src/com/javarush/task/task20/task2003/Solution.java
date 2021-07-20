package com.javarush.task.task20.task2003;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties

Знакомство с properties
В методе main() происходит считывание пути к файлу с консоли и заполнение runtimeStorage данными из файла.
Тебе необходимо в методе save() реализовать логику записи в файл для карты runtimeStorage, а в методе load() - логику чтения из файла для runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле игнорируй.
Про .properties прочитай в вики.
Подсказка: используй объект класса Properties.


Requirements:
1. Метод save() должен сохранять карту runtimeStorage в параметр outputStream.
2. Метод load() должен восстанавливать состояние карты runtimeStorage из параметра inputStream.
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        if(!runtimeStorage.isEmpty()){
            Properties properties = new Properties();
            properties.putAll(runtimeStorage);
            properties.store(outputStream,"");
        }
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код

       if (inputStream.available()>0){
           Properties properties = new Properties();
           properties.load(inputStream);
           for (Map.Entry<Object,Object> entry : properties.entrySet()
           ) {
               runtimeStorage.put(entry.getKey().toString(),entry.getValue().toString());
           }
       }

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
