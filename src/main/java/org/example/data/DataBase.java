package org.example.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class DataBase {
    private static HashMap<String, User> users = new HashMap<>();

    private static List<Message> messages = new ArrayList<Message>();

    private DataBase() {
    }


    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
        users.put("admin", new User("admin", "admin", "admin", UserType.ADMIN));
        users.put("fox", new User("fox", "fox", "fox", UserType.CLIENT));
        users.put("bird", new User("bird", "bird", "bird", UserType.CLIENT));
        DataBase.getUsers().get("fox").setMuted(true);
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static void addMessage(Message message) {
        messages.add(message);
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}
