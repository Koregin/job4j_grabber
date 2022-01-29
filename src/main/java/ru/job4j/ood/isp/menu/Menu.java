package ru.job4j.ood.isp.menu;

import java.util.Optional;

public interface Menu {
    boolean add(Task parent, Task child);

    Optional<Node<Task>> findBy(String taskName);
}

