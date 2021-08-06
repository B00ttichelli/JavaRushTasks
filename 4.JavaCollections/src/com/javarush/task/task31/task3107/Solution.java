package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern


Null Object Pattern
Почитай на вики про паттерн "Null Object".
Используй Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируй поле объектом NullFileData.


Requirements:
1. Конструктор Solution должен инициализировать поле fileData объектом ConcreteFileData.
2. Если в конструкторе Solution возникла ошибка, нужно инициализировать поле fileData объектом NullFileData.
3. Конструктор Solution должен корректно устанавливать значение поля hidden у объекта ConcreteFileData.
4. Конструктор Solution должен корректно устанавливать значение поля executable у объекта ConcreteFileData.
5. Конструктор Solution должен корректно устанавливать значение поля directory у объекта ConcreteFileData.
6. Конструктор Solution должен корректно устанавливать значение поля writable у объекта ConcreteFileData.
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

        Path path  = Paths.get(pathToFile);
        try {
            this.fileData = new ConcreteFileData(Files.isHidden(path),Files.isExecutable(path),Files.isDirectory(path),Files.isWritable(path));

        } catch (Exception e){
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
