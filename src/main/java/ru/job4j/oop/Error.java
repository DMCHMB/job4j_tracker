package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка активна? " + active);
        System.out.println("Статус ошибки " + status);
        System.out.println("Сообщение об ошибке " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error unauthorized = new Error(false, 401, "Authorization Required");
        Error forbidden = new Error(true, 403, "You don't have permission to access this server");
        Error unavailable = new Error(true, 503, "The service you requested is not available");
        defaultError.printInfo();
        unauthorized.printInfo();
        forbidden.printInfo();
        unavailable.printInfo();
    }
}
