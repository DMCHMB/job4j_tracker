package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает логику работы банковского сервиса
 *
 * @author Ilya
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов и их счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в систему
     *
     * @param user уникальный объект класса {@link User}
     *             Если клиент уже зарегистрирован в системе, дублирования не произойдет
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента из системы
     *
     * @param passport уникальный номер паспорта клиента
     * @return true - клиент удален из системы, false - удаление не удалось
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет счет существующему клиенту {@link User}
     *
     * @param passport уникальный номер паспорта клиента
     * @param account  уникальный счет клиента
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод производит поиск клиента по уникальному номеру паспорта
     *
     * @param passport уникальный номер паспорта клиента
     * @return клиента {@link User}, либо null, если клиент не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод производит поиск банковского счета {@link Account} клиента {@link User}
     * по уникальному номеру паспорта и реквизитам счета
     *
     * @param passport  уникальный номер паспорта клиента
     * @param requisite реквизиты счета клиента
     * @return банковский счет клиента{@link User}, либо null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод производит перевод денег с одного счета на другой.
     * Метод проверяет, что счета отправителя и получателя существуют,
     * а также что баланс счета отправителя больше суммы перевода
     *
     * @param srcPassport   номер паспорта отправителя
     * @param srcRequisite  реквизиты счета отправителя
     * @param destPassport  номер паспорта получателя
     * @param destRequisite реквищиты счета получателя
     * @param amount        сумма перевода
     * @return true - если операция прошла успешно,
     * false - счет отправителя или получателя не найден, либо недостаточно средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }

    /**
     * Метод позволяет получить список банкоских счетов клиента {@link User}
     *
     * @param user объект класса {@link User}
     * @return список счетов клиента в формате коллекции List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
