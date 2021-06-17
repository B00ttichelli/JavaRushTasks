package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
НОД

Давай найдем наибольший общий делитель (НОД). Для этого:
Введи с клавиатуры 2 целых положительных числа.
Выведи в консоли наибольший общий делитель.

Requirements:
1. Программа должна считывать с клавиатуры 2 строки.
2. Если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель (НОД) чисел, считанных с клавиатуры, и успешно завершаться.

*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        int y = 0;

            x = Integer.parseUnsignedInt(bufferedReader.readLine());
            y = Integer.parseUnsignedInt(bufferedReader.readLine());
            avothuyvam(x,y);
        while (x != 0 && y != 0) {
            if (x > y) {
                x=x%y;
            } else {
                y=y%x;

            }
        }
        System.out.println(x+y);
    }
    public static void avothuyvam (int x,int y) throws NumberFormatException{
        if(x<=0 || y<=0){
            throw new NumberFormatException();
        }
    }
}
