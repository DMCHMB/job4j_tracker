package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета клиента
 *
 * @author Ilya
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета
     */
    private String requisite;
    /**
     * Баланс банковского счета
     */
    private double balance;

    /**
     * Конструктор банковского счета
     *
     * @param requisite реквизиты банковского счета
     * @param balance   баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить значение поля {@link Account#requisite}
     *
     * @return значение поля {@link Account#requisite}
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет установить значение поля {@link Account#requisite}
     *
     * @param requisite новое значение поля {@link Account#requisite}
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить значение поля {@link Account#balance}
     *
     * @return значение поля {@link Account#balance}
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет установить значение поля {@link Account#balance}
     *
     * @param balance новое значение поля {@link Account#balance}
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод проверяет равенство объектов класса {@link Account} на основе поля {@link Account#requisite}
     *
     * @param o объект класса {@link Account} для сравнения с текущим
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод вычисляет хеш-код текущего объекта класса {@link Account} на основе поля {@link Account#requisite}
     *
     * @return значение хеш-кода объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
