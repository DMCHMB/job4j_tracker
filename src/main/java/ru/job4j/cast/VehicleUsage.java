package ru.job4j.cast;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle train = new Train();
        Vehicle train2 = new Train();
        Vehicle bus = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = {plane, train, bus, plane2, train2, bus2};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}