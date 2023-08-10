package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int size = queue.size();
        for (int i = 0; i < Math.min(size - 1, count - 1); i++) {
            queue.poll();
        }
        return queue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        Customer firstUpsetCustomer = null;
        int size = queue.size();
        for (int i = 0; i < Math.min(size, count); i++) {
            queue.poll();
        }
        firstUpsetCustomer = queue.poll();
        return firstUpsetCustomer != null ? firstUpsetCustomer.name() : null;
    }
}
