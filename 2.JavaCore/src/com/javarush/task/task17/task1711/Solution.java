package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


Requirements:
1. Класс Solution должен содержать public static volatile поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static final String warning = "Invalid Arguments";

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {


        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                for (int i = 1; i < (args.length); i = i + 3) {


                        createPerson(args[i], args[i + 1], args[i + 2]);

                    }
                }

                break;
            case "-u":
                synchronized (allPeople) {
                for (int i = 1; i < args.length; i = i + 4) {

                        updatePerson(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                }

                break;
            case "-d":
                synchronized (allPeople){
                for (int i =1; i<args.length; i++){

                        deletePerson(args[i]);
                    }
                }

                break;
            case "-i":
                synchronized (allPeople){
                for (int i = 1; i< args.length; i++){

                        showPerson(args[i]);
                    }
                }

                break;
            default:
                synchronized (allPeople){

                }
                System.out.println(warning);
        }
        /*System.out.println(allPeople);*/
    }


    public static void createPerson(String name, String sex, String bd) {
        Date parse = null;
        try {
            parse = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
        } catch (ParseException e) {
            System.out.println(warning);

        }
        if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, parse));
        } else if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, parse));
        } else {
            System.out.println(warning);
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void updatePerson(String id, String name, String sex, String bd) {
        Date parse = null;
        try {
            parse = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
        } catch (ParseException e) {
            System.out.println(warning);

        }
        try {
            allPeople.get(Integer.parseInt(id)).setBirthDate(parse);
            if (sex.equals("ж")) {
                allPeople.get(Integer.parseInt(id)).setSex(Sex.FEMALE);
            } else if (sex.equals("м")) {
                allPeople.get(Integer.parseInt(id)).setSex(Sex.MALE);
            } else {
                throw new IllegalArgumentException();
            }
            allPeople.get(Integer.parseInt(id)).setName(name);
        } catch (NumberFormatException e) {
            System.out.println(warning);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(warning);
        } catch (IllegalArgumentException e) {
            System.out.println(warning);
        }


    }

    public static void deletePerson(String id) {
        try {
            allPeople.get(Integer.parseInt(id)).setBirthDate(null);
            allPeople.get(Integer.parseInt(id)).setSex(null);
            allPeople.get(Integer.parseInt(id)).setName(null);
        } catch (NumberFormatException e) {
            System.out.println(warning);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(warning);
        }


    }

    public static void showPerson(String id) {
        try {
            System.out.println(allPeople.get(Integer.parseInt(id)).toString());
        } catch (NumberFormatException e) {
            System.out.println(warning);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(warning);
        }
    }

}
