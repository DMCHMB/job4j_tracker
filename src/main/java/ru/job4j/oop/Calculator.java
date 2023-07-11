package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.x);
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(15));
        Calculator calc = new Calculator();
        System.out.println(calc.multiply(7));
        System.out.println(calc.divide(45));
        System.out.println(calc.sumAllOperation(40));
    }
}
