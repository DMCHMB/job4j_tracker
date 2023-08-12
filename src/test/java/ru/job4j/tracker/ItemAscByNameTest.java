package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {
    @Test
    public void whenAscComparator() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1, "first");
        Item item2 = new Item(2, "second");
        Item item3 = new Item(3, "third");
        items.add(item1);
        items.add(item3);
        items.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}