package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель клиента банка
 *
 * @author Ilya
 * @version 1.0
 */
public class User {
    /**
     * Содержит номер паспорта клиента
     */
    private String passport;
    /**
     * Содержит ФИО клиента
     */
    private String username;

    /**
     * Конструктор для создания нового клиента
     *
     * @param passport уникальный номер паспорта клиента
     * @param username ФИО клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить значение поля {@link User#passport}
     *
     * @return значение поля {@link User#passport}
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет установить значение поля {@link User#passport}
     *
     * @param passport новое значение поля {@link User#passport}
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить значение поля {@link User#username}
     *
     * @return значение поля {@link User#username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет установить значение поля {@link User#username}
     *
     * @param username новое значение поля {@link User#username}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод проверяет равенство объектов класса {@link User} на основе поля {@link User#passport}
     *
     * @param o объект класса {@link User} для сравнения с текущим
     * @return true - объекты равны, false - объекты не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод вычисляет хеш-код текущего объекта класса {@link User} на основе поля {@link User#passport}
     *
     * @return значение хеш-кода объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
