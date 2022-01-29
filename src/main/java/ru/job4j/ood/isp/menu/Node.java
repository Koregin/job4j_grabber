package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

class Node<Task> {
    private final Task value;
    final List<Node<Task>> children = new ArrayList<>();

    public Node(Task value) {
        this.value = value;
    }

    public Task getValue() {
        return value;
    }
}
