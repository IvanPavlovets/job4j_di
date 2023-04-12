package ru.job4j;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    /**
     * Карта с объектами. В ней мы будем хранить проинициализированные объекты.
     */
    private final Map<String, Object> els = new HashMap<>();

    /**
     * Метод регистрации классов в Context.
     * Сначало получаем все конструкторы класса,
     * Если их больше 1, то кидаем исключение.
     * Когда мы нашли конструктор -
     * 1) мы собираем аргументы этого конструктора;
     * 2) ищем уже зарегистрированные объекты,
     * чтобы внедрить их в конструктор.
     * 3) Последний этап - это создание объекта и
     * добавление его в карту.
     * @param Class cl
     */
    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Coun't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    /**
     * Метод возвращает проинициализированный объект.
     * inst.getCanonicalName() - получаем имя класса через рефлексию
     * @param Class<T> inst
     * @return <T> T
     * @param <T>
     */
    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }

}
