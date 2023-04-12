package ru.job4j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext();
        contex.register(Store.class);
        contex.register(ConsoleInput.class);
        contex.register(StartUI.class);
        contex.refresh();
        StartUI ui = contex.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan Pavlovets");
        ui.print();

    }
}
