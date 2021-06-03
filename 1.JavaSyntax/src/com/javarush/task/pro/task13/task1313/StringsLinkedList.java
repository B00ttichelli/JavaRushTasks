package com.javarush.task.pro.task13.task1313;

import java.util.LinkedList;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }


/*
    StringsLinkedList
    Пришло время познакомиться с двусвязным списком. Решая эту задачу ты поймешь, как работает двусвязный список и сможешь добавлять в него элементы. У тебя есть класс StringsLinkedList, в котором есть поля first и last, указывающие на первый и последний элемент соответственно.
    Тебе нужно реализовать логику метода add, который будет добавлять элементы в список.

    Подсказки:

    Для правильной реализации важно понимать, что по списку можно проходить как с первого элемента до последнего, так и наоборот, поэтому при добавлении новых элементов не забудь менять ссылки рядом стоящих.
    Метод add должен создавать новый объект класса Node, в который он поместит переданное значение. Перед тем как добавлять новую ноду, нужно изменить ссылку последней ноды на новосозданную, а новосозданная станет последней.
    Если в списке один элемент, то на него указывает first.next и last.prev одновременно.
    Метод printAll создан для debug и в проверке не участвует.
    Важно:
    Node first не должна иметь значение, она указывает только на первый элемент(first.next);
    Node last также не содержит значения, а только указывает на последний элемент(last.prev).


    Requirements:
            1. При добавлении нового элемента предыдущие элементы должны получать на него ссылку.
2. При добавлении нового элемента он должен получать ссылку на предыдущий.
            3. Поле first класса StringsLinkedList должно всегда ссылаться на первый элемент, не содержать значение (value) и ссылку на предыдущий элемент (prev).
            4. Поле last класса StringsLinkedList должно всегда ссылаться на последний элемент, не содержать значение (value) и ссылку на следующий элемент (next).*/

    /*При добавлении нового элемента предыдущие элементы должны получать на него ссылку.
    При добавлении нового элемента он должен получать ссылку на предыдущий.
    Поле first класса StringsLinkedList должно всегда ссылаться на первый элемент, не содержать значение (value) и ссылку на предыдущий элемент (prev).
    Поле last класса StringsLinkedList должно всегда ссылаться на последний элемент, не содержать значение (value) и ссылку на следующий элемент (next).*/
    public void add(String value) {
        Node n = new Node();
        n.value= value;
        if(first.next == null){
            n.next = last;
            n.prev = first;
            first.next  = n;
            last.prev =n;
        } else {
            Node l = last.prev;
            l.next = n;
            last.prev = n;
            n.next = last;
            n.prev = l;
        }

        //напишите тут ваш код
    }



/*
    Node l  =  last;
    Node newNode = new Node();
    newNode.prev = l;
    newNode.value = value;
    newNode.next = null;
    last = newNode;
        if(l==null){
        first = newNode;
    }else {
        l.next = newNode;
    }
*/


    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
