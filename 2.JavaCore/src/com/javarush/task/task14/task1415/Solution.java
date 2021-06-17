package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр

Клининговый центр
В этой задаче тебе нужно:
Реализовать метод cleanAllApartments().
Пройтись по списку объектов apartments:
для однокомнатных квартир (OneRoomApt) вызвать метод clean1Room();
для двухкомнатных квартир (TwoRoomApt) вызвать метод clean2Rooms();
для трехкомнатных квартир (ThreeRoomApt) вызвать метод clean3Rooms().

Requirements:
1. Метод cleanAllApartments должен принимать список аппартаметов в качестве параметра.
2. В методе cleanAllApartments для всех однокомнатных аппартаментов (OneRoomApt), содержащихся в списке, необходимо вызвать метод clean1Room().
3. В методе cleanAllApartments для всех двухкомнатных аппартаментов (TwoRoomApt), содержащихся в списке, необходимо вызвать метод clean2Rooms().
4. В методе cleanAllApartments для всех трехкомнатных аппартаментов (ThreeRoomApt), содержащихся в списке, необходимо вызвать метод clean3Rooms().
5. Классы OneRoomApt, TwoRoomApt, ThreeRoomApt должны поддерживать (реализовывать) интерфейс Apartment.
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        for (Apartment app:apartments
             ) {
            if(app instanceof OneRoomApt){
                ((OneRoomApt) app).clean1Room();
            }else if (app instanceof  TwoRoomApt){
                ((TwoRoomApt) app).clean2Rooms();
            }else if (app instanceof  ThreeRoomApt){
                ((ThreeRoomApt) app).clean3Rooms();
            }
        }
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
