package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD


CRUD
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Requirements:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public final static String warning  = "Invalid Arguments";
/*-c Миронов м 15/04/1990*/
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]){
            case "-c":
                createPerson(args[1],args[2],args[3]);
                break;
            case "-u":
                updatePerson(args[1],args[2],args[3],args[4]);
                break;
            case "-d":
                deletePerson(args[1]);
                break;
            case "-i":
                showPerson(args[1]);
                break;
            default:
                System.out.println(warning);
        }

        /*System.out.println(allPeople);*/

    }



    public static void createPerson(String name, String sex, String bd){
        Date parse = null;
        try {
            parse = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
        } catch (ParseException e) {
            System.out.println(warning);

        }
        if(sex.equals("ж")){
                allPeople.add(Person.createFemale(name,parse));
            }else if( sex.equals("м")){
                allPeople.add(Person.createMale(name,parse));
            }else {
                System.out.println(warning);
            }
        System.out.println(allPeople.size()-1);
    }
    public static void updatePerson(String id, String name, String sex, String bd){
        Date parse = null;
        try {
            parse = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
        } catch (ParseException e) {
            System.out.println(warning);

        }
        try {
            allPeople.get(Integer.parseInt(id)).setBirthDate(parse);
            if(sex.equals("ж")){
                allPeople.get(Integer.parseInt(id)).setSex(Sex.FEMALE);
            }else if (sex.equals("м")){
                allPeople.get(Integer.parseInt(id)).setSex(Sex.MALE);
            }else {
                throw new IllegalArgumentException();
            }
            allPeople.get(Integer.parseInt(id)).setName(name);
        } catch (NumberFormatException e) {
            System.out.println(warning);
        } catch (IndexOutOfBoundsException e){
            System.out.println(warning);
        } catch (IllegalArgumentException e){
            System.out.println(warning);
        }


    }
    public static void deletePerson(String id){
        try {
            allPeople.get(Integer.parseInt(id)).setBirthDate(null);
            allPeople.get(Integer.parseInt(id)).setSex(null);
            allPeople.get(Integer.parseInt(id)).setName(null);
        } catch (NumberFormatException e) {
            System.out.println(warning);
        } catch (IndexOutOfBoundsException e){
            System.out.println(warning);
        }


    }
    public static void  showPerson(String id){
        try {
            System.out.println(allPeople.get(Integer.parseInt(id)).toString());
        } catch (NumberFormatException e) {
            System.out.println(warning);
        }catch (IndexOutOfBoundsException e){
            System.out.println(warning);
        }
    }

}
