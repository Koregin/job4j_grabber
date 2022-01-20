package ru.job4j.ood.ocp;

/*
В данном случае: класс User использует класс ConsoleLogger для логирования.
Класс ConsoleLogger при вызове метода log выводит сообщение в консоль.
Если в дальнейшем понадобиться выводить сообщение в файл или в БД, то надо будет
добавить новые классы, например FileLogger и DatabaseLogger.
В класс User придется вносить изменения в зависимости от того как надо логировать,
что нарушает принцип OCP
 */

public class UserLogger {

    public static class ConsoleLogger {
        public void log(String log) {
            System.out.println(log);
        }
    }

    public class User {
        private ConsoleLogger logger;
        String name;

        public User(String name) {
            this.name = name;
            this.logger = new ConsoleLogger();
        }

        public void login() {
            /*Авторизация пользователя*/
            logger.log("Пользователь успешно авторизовался");
        }
    }
}
