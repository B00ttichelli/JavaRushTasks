package com.javarush.task.task19.task1917;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/* 
Свой FileWriter

Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len) throws IOException
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.


Requirements:
1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
8. Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же метод поля fileWriter.
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;


    public FileConsoleWriter(String fileName) throws IOException {

        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append ) throws IOException {
        this.fileWriter = new FileWriter(fileName,append);
    }

    public FileConsoleWriter(File file) throws IOException {

        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {

        this.fileWriter = new FileWriter(file,append);
    }

    public FileConsoleWriter(FileDescriptor fd) {

        this.fileWriter = new FileWriter(fd);
    }








    public static void main(String[] args) {

    }
    public void write(char[] cbuf, int off, int len) throws IOException {
        CharBuffer cb = CharBuffer.wrap(cbuf, off, len);
        System.out.println(cb.toString());
        fileWriter.write(cbuf,off,len);
    }
    public void write(int c) throws IOException {
        System.out.println(c);
        fileWriter.write(c);
    }
    public void write(String str) throws IOException {
        System.out.println(str);
        fileWriter.write(str);
    }
    public void write(String str, int off, int len) throws IOException {

        System.out.println(str.substring(off,len+off));
        fileWriter.write(str,off,len);
    }
    public void write(char[] cbuf) throws IOException {
        System.out.println(cbuf);
        fileWriter.write(cbuf);
    }
    public void close() throws IOException {
        fileWriter.close();
    }
}
