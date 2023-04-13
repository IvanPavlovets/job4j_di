package ru.job4j;

import org.springframework.stereotype.Component;

@Component
public class StartUI {
    private final ConsoleInput input;
    private final Store store;

    public StartUI(ConsoleInput input, Store store) {
        this.input = input;
        this.store = store;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
