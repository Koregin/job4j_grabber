package ru.job4j.ood.ocp;

/*
Если понадобиться добавить возможность сохранять объект класса Image в
другом формате, например BMP или PNG, то придется вносить изменения в данный класс.
 */
public class Image {
    private String name;
    private double size;

    public Image(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public void saveAsJPEG(Image image) {
        /*
        какой-то код сохранения Image c расширением jpeg
        */
    }
}
