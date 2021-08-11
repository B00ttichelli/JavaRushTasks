package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/* 
Генератор паролей



Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Requirements:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/

public class Solution {
private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
private static  final String UPPERCASE = LOWERCASE.toUpperCase();
private static final String DIGITS = "0123456789";
private static  final SecureRandom  random =  new SecureRandom();
private static final  String ALLOWED = LOWERCASE+UPPERCASE+DIGITS;
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()  {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder stringBuilder = new StringBuilder();

       stringBuilder.append(generateRandomString(UPPERCASE,2));
       stringBuilder.append(generateRandomString(LOWERCASE,2));
       stringBuilder.append(generateRandomString(DIGITS,2));
       stringBuilder.append(generateRandomString(ALLOWED,2));

        try {
            byteArrayOutputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  byteArrayOutputStream;
    }

    public static String generateRandomString(String in,int size){
     StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(in.length());
            result.append(in.charAt(index));

        }
        return result.toString();
    }
}
