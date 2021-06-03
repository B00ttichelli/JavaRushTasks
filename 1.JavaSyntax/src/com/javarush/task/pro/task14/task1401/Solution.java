package com.javarush.task.pro.task14.task1401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Поработай обработчиком
*/

public class Solution {

    public static final String INPUT_NAME = "\nВведите имя: ";
    public static final String INPUT_AGE = "Введите возраст пользователя '%s': ";

    public static final String CANNOT_BE_NULL = "Имя не может быть null.";
    public static final String CANNOT_BE_EMPTY = "Имя не может быть пустым.";
    public static final String CANNOT_CONTAIN_DIGIT = "Имя не может содержать цифры.";
    public static final String CANNOT_BE_NEGATIVE = "Возраст не может быть меньше 0.";
    public static final String CANNOT_BE_TOO_BIG = "Возраст не может быть больше 150.";
    public static final String UNKNOWN_ERROR = "Неизвестная ошибка.";

    public static final String FOUND = "\nПользователь '%s' найден под индексом %d.\n";
    public static final String NOT_FOUND = "\nПользователь '%s' не найден.\n";

    static List<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            addUser(new User());
        }

        User userToSearch = new User();
        userToSearch.setName("Рафаэль");

        findUserIndex(userToSearch);
    }

    static void addUser(User user) {
        System.out.print(INPUT_NAME);
        String name = scanner.nextLine();

        System.out.printf(INPUT_AGE, name);
        int age = Integer.parseInt(scanner.nextLine());

        int setNameResponseCode = user.setName(name);
        int err = 0;
        /*В методе addUser обработай значение, возвращаемое методом setName:
        если setName вернул -1, выведи сообщение: "Имя не может быть null."
        если -2, выведи сообщение: "Имя не может быть пустым."
        если -3, выведи сообщение: "Имя не может содержать цифры."
        если другое значение, кроме 0, выведи сообщение: "Неизвестная ошибка."*/
        int setAgeResponse  = user.setAge(age);
        if(setNameResponseCode ==-1){
            System.out.println(CANNOT_BE_NULL);
        }else if(setNameResponseCode == -2){
            System.out.println(CANNOT_BE_EMPTY);
        } else if(setNameResponseCode == -3){
            System.out.println(CANNOT_CONTAIN_DIGIT);
        }else if (setNameResponseCode != 0){
            System.out.println(UNKNOWN_ERROR);

        }else {
            err++;
        }
       /* В методе addUser обработай значение, возвращаемое методом setAge:
        если setAge вернул -1, выведи сообщение: "Возраст не может быть меньше 0."
        если -2, выведи сообщение: "Возраст не может быть больше 150."
*/

        if(setAgeResponse == -1){
            System.out.println(CANNOT_BE_NEGATIVE);
        }else if(setAgeResponse == -2){
            System.out.println(CANNOT_BE_TOO_BIG);
        }else if(setAgeResponse !=0) {
            System.out.println(UNKNOWN_ERROR);
        }else {
            err++;
        }

        if(err==2) {
            users.add(user);
        }
    }

    /*В методе findUserIndex обработай значение, возвращаемое методом indexOf:
    если indexOf вернул -1, выведи сообщение "Пользователь '<имя пользователя>' не найден."
    иначе — оставь текущее сообщение*/

    static void findUserIndex(User user) {
        int index=users.indexOf(user);

        if ((index) == -1) {
            System.out.printf(NOT_FOUND,user.getName());

        }else {
            System.out.printf(FOUND, user.getName(), index);
        }
    }
}
