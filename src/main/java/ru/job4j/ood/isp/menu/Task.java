package ru.job4j.ood.isp.menu;

public class Task implements Action {

    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public void doAction() {
        System.out.println("----------- Running task " + taskName + "-----------");
    }
}