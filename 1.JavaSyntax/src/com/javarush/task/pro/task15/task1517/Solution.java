package com.javarush.task.pro.task15.task1517;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Файловые операции

Файловые операции
Нужно написать программу, которая будет считывать с клавиатуры два пути к файлу.

Если файла по первому пути не существует, его нужно создать.
Если же файл по первому пути существует, нужно переместить этот файл по второму пути, но только в том случае, если по второму пути файла нет.
Если же он есть, нужно просто удалить файл по первому пути.
Используй соответствующие методы класса Files: createFile(), move(), delete(), exists()/notExists().

Requirements:
1. Программа должна считать из консоли два пути.
2. В программе должны быть использованы соответствующие методы класса Files: createFile(Path.class), move(Path, Path), delete(Path), exists(Path)/notExists(Path).
3. Программа должна обрабатывать введенные пути согласно условию.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path filePath = Paths.get(scanner.nextLine());
        Path fileNewPath = Paths.get(scanner.nextLine());
        if(!Files.exists(filePath)){
            Files.createFile(filePath);
        }else if (!Files.exists(fileNewPath)){
            Files.move(filePath,fileNewPath);

        } else {
            Files.delete(filePath);
        }
    }
}

