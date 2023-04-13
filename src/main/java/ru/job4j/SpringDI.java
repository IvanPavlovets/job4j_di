package ru.job4j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext();
        contex.scan("ru.job4j");
        contex.refresh();
        StartUI ui = contex.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan Pavlovets");
        ui.print();

    }
}
