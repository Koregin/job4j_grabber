package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CinemaTest {

    @Ignore
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    public void whenNotFindSession() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> false);
        assertNull(sessions);
    }

    @Ignore
    public void whenAdd() {
        Cinema cinema = new Cinema3D();
        Session session3D = new Session3D();
        List<Session> sessions = List.of(session3D);
        cinema.add(session3D);
        assertThat(sessions, is(cinema.find(session -> true)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        cinema.buy(account, 10, 125, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public  void whenPlaceIsBusy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket dublTicket = cinema.buy(account, 1, 1, date);
    }
}