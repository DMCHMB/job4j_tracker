package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Arsentev Petr Sergeevich");
        map.put("iivanov@yandex.ru", "Ivanov Ivan Sergeevich");
        map.put("ppetrov@yandex.ru", "Petrov Petr Sergeevich");
        map.put("vsidorov@yandex.ru", "Sidorov Vlad Sergeevich");
        map.put("vsidorov@yandex.ru", "Sidorov Vladimir Petrovich");
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
