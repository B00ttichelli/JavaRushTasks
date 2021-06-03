package com.javarush.task.pro.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Стек в домашних условиях
*/
/*
Стек в домашних условиях
        В классе MyStack нужно реализовать свою версию структуры хранения данных стек на базе ArrayList.
        Все элементы хранятся в приватном списке storage. Твоя задача реализовать все объявленные методы класса MyStack.
        Где метод push(String) добавляет элемент в начало списка storage. Метод pop() возвращает первый элемент списка
        storage, а потом удаляет его из этого списка. Метод peek() возвращает первый элемент списка storage.
        Метод empty() проверяет, не пустой ли список storage. Метод search(String) ищет элемент в списке storage
        и возвращает его индекс. Если элемента нет в списке — возвращает -1.*/

public class MyStack {

    private final List<String> storage = new ArrayList<>();

    public void push(String s) {
        storage.add(0,s);
    }

    public String pop() {
        //напишите тут ваш код
        String result  = storage.get(0);
        storage.remove(0);
        return result;
    }

    public String peek() {
        //напишите тут ваш код
        return storage.get(0);
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public int search(String s) {
        //напишите тут ваш код
        int result = -1;
        for (int i = 0; i < storage.size(); i++) {
            if(storage.get(i).equals(s)){
                result = i;
            }
        }
        return result;
    }
}
