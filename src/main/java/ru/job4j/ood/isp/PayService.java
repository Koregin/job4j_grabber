package ru.job4j.ood.isp;
/*
В этом примере реализуется какой-то абстрактный платежный сервис с одним методом.
Этот метод реализуется одним классом.
В дальнейшем мы решили реализовать ещё один сервис реализующий данный интерфейс, но с дополнительными методами.
В следствии этого надо будет добавить методы заглушки в первый класс, который уже был реализован.
В дальнейшем, используя этот класс, другой программист может использовать его в качестве базового и получить исключение недоумевая что метод был не
реализован.
 */

public interface PayService {
    boolean payMethod();
    void sendEmail();
}

class PayPal implements PayService {

    @Override
    public boolean payMethod() {
        /* make payment transaction */
        return true;
    }

    @Override
    public void sendEmail() {
        throw new UnsupportedOperationException();
    }
}

class YandexMoney implements PayService {

    @Override
    public boolean payMethod() {
        /* make payment transaction */
        return true;
    }

    @Override
    public void sendEmail() {
        System.out.println("Send email about payment status");
    }
}