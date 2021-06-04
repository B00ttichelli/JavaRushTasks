package com.javarush.task.pro.task15.task1504;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String src=scanner.nextLine();
        String dest=scanner.nextLine();

        try(

                InputStream input = Files.newInputStream(Paths.get(src));
                OutputStream output = Files.newOutputStream(Paths.get(dest)))
        {
            byte[] buffer=new byte[input.available()];
            while(input.available()>0)
            {
                int real=input.read(buffer);
            }
            if(buffer.length%2==0)
            {int k=0;
                for(int j=0;j<(buffer.length)/2;j++)
                {
                    k=j*2;
                    output.write(buffer[k+1]);
                    output.write(buffer[k]);
                }
            }
            else
            {
                int k=0;
                for(int j=0;j<(buffer.length-1)/2;j++)
                {
                    k=j*2;
                    output.write(buffer[k+1]);
                    output.write(buffer[k]);
                }
                output.write(buffer[buffer.length-1]);
            }
        }
        catch (Exception e) {
            System.out.println("не верный путь к файлу");

        }

        //напишите тут ваш код
    }
}
