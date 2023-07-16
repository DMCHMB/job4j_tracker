package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book shildt = new Book("Java", 1200);
        Book sierra = new Book("Head", 555);
        Book horstmann = new Book("Core Java", 777);
        Book martin = new Book("Clean code", 444);
        Book[] books = {shildt, sierra, horstmann, martin};
        printBooks(books);
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        System.out.println("Replace book 0 and 3");
        printBooks(books);
        System.out.println("Show only book with name \"Clean code\")");
        printBooks(books, "Clean code");
    }

    private static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " " + book.getNumberOfPages());
        }
    }

    private static void printBooks(Book[] books, String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                System.out.println(book.getName() + " " + book.getNumberOfPages());
            }
        }
    }
}
