package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов



Адаптация нескольких интерфейсов
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируй countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.


Requirements:
1. Класс Solution должен содержать public static поле countries типа Map<String, String>.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки в виде комментариев в интерфейсах.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
      IncomeData incomedata  =  new IncomeData() {
           @Override
           public String getCountryCode() {
               return "38";
           }

           @Override
           public String getCompany() {
               return "JJJ";
           }

           @Override
           public String getContactFirstName() {
               return "JJJ";
           }

           @Override
           public String getContactLastName() {
               return "Fuck YUo";
           }

           @Override
           public int getCountryPhoneCode() {
               return 38;
           }

           @Override
           public int getPhoneNumber() {
               return 501234567;
           }
       };
       IncomeDataAdapter adap  = new IncomeDataAdapter(incomedata);
        System.out.println(adap.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer,Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            Integer phone = data.getPhoneNumber();
            String phonestr = phone.toString();
            while (phonestr.length()<10){
                phonestr = "0"+phonestr;

            }

            String clean = "("+phonestr.substring(0,3)+")"+
                    phonestr.substring(3,6)+"-"+phonestr.substring(6,8)+"-"+phonestr.substring(8,10);
            return  "+" + data.getCountryPhoneCode()+ clean;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}