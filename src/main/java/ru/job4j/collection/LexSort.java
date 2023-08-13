package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(extractTaskNumber(left), extractTaskNumber(right));
    }

    private int extractTaskNumber(String s) {
        String taskNumber = s.split("\\.")[0];
        return Integer.parseInt(taskNumber.trim());
    }
}
