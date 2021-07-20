package com.javarush.task.task20.task2002;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush


Читаем и пишем в файл: JavaRush
Реализуй логику записи в файл и чтения из файла для класса JavaRush.
Пустых полей у объекта User быть не может. Дату в файле удобно хранить в формате long.
Метод main реализован только для тебя и не участвует в тестировании.


Requirements:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("/home/platon/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/Test", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Zalupa");
            user.setLastName("Hui");
            user.setCountry(User.Country.OTHER);
            user.setBirthDate(new Date());
            user.setMale(true);

            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

           if(!users.isEmpty()){
               for (User user:users
               ) {
                   StringBuilder stringBuilder = new StringBuilder();
                   stringBuilder.append(user.getFirstName()+":"+user.getLastName()+":"+user.getCountry().getDisplayName()+":"+user.getBirthDate().getTime()+":"+user.isMale());
                   outputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
                   outputStream.write(59);
               }
           }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (inputStream.available()>0){
                byte[] buff = new byte[inputStream.available()];
                inputStream.read(buff,0,inputStream.available());
                String allLines = new String(buff,"UTF-8");
                String[] usersArr = allLines.split(";");

                for (String line : usersArr
                ) {
                    String[] split = line.split(":");
                    User user = new User();
                    user.setFirstName(split[0]);
                    user.setLastName(split[1]);
                    if(split[2].equals("Russia")){
                        user.setCountry(User.Country.RUSSIA);

                    }else if (split[2].equals("Ukraine")){
                        user.setCountry(User.Country.UKRAINE);
                    }else {
                        user.setCountry(User.Country.OTHER);
                    }
                    user.setBirthDate(new Date(Long.parseLong(split[3])));
                    user.setMale(Boolean.parseBoolean(split[4]));
                    users.add(user);
                }



            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
