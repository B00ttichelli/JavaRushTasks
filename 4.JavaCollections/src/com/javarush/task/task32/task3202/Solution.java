package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Читаем из потока
Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.


Requirements:
1. Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.
2. Метод getAllDataFromInputStream (InputStream) должен возвращать StringWriter.
3. Метод getAllDataFromInputStream (InputStream) должен вернуть StringWriter, который содержит все данные из переданного потока.
4. Возвращаемый объект ни при каких условиях не должен быть null.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) {
        StringWriter stringWriter = new StringWriter();
        try {
            byte[] buff = new byte[is.available()];
            is.read(buff);
            String s = new String(buff, StandardCharsets.UTF_8);
            stringWriter.write(s);
        }catch (Exception e){
            return  stringWriter; ///без этой срани может быть налл при екзепшене
        }


        return stringWriter;
    }
}
