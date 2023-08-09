package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(List.of(origin));
        for (String t : text) {
            if (!check.contains(t)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
