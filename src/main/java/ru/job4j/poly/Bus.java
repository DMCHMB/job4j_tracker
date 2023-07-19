package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Bus is driving");
    }

    @Override
    public void passengers(int passengers) {
        System.out.printf("I have %d passengers%n", passengers);
    }

    @Override
    public double refill(double numberOfFuel) {
        return numberOfFuel * 67;
    }
}
