# job4j_di
В крупных проектах могут быть классы, которые имеют много зависимостей.<br>
Чтобы упростить создание такие объектов, программисты придумали концепцию "внедрение зависимостей"<br>
с английского DI - dependency injection.<br>

Давайте мы сделаем свою реализацию DI. Для реализации DI используется два подхода:<br>
мета программирование, рефлексия.<br>

В этом примере мы будем использовать рефлексию.<br>
Рефлексия позволяет узнать какие элементы имеет класс в процессе выполнения программы.<br>