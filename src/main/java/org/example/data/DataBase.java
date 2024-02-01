package org.example.data;

import java.util.HashMap;

public final class DataBase {
    private static HashMap<String, User> users = new HashMap<>();

    private DataBase() {
    }


    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
        users.put("admin", new User("admin", "admin", "admin", UserType.ADMIN));
        users.put("fox", new User("fox", "fox", "fox", UserType.CLIENT));
        users.put("bird", new User("bird", "bird", "bird", UserType.CLIENT));
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}
