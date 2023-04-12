package ru.job4j;

public class Main {
    /**
     * Регистрируем в Context все классы.
     * Затем он сам их инициализирует
     * и создает класс StartUI с класами от
     * которых он зависит (Context создает
     * эти обьекты автоматически)
     * @param args
     */
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
