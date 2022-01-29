package ru.job4j.ood.isp.menu;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class SimpleMenu implements Menu {
    private final Node<Task> root;

    public SimpleMenu(Task root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(Task parent, Task child) {
        boolean result = false;
        Optional<Node<Task>> foundOptParent = findBy(parent.getTaskName());
        if (foundOptParent.isPresent() && findBy(child.getTaskName()).isEmpty()) {
            foundOptParent.get().children.add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<Task>> findBy(String taskName) {
        Optional<Node<Task>> rsl = Optional.empty();
        Queue<Node<Task>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<Task> node = data.poll();
            if (taskName.equals(node.getValue().getTaskName())) {
                rsl = Optional.of(node);
                break;
            }
            data.addAll(node.children);
        }
        return rsl;
    }
}