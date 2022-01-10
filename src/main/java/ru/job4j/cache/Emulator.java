package ru.job4j.cache;

import java.util.Scanner;

/**
 * Класс для работы с пользователем
 * Представляет возможности для пользователя:
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 */

public class Emulator {

    private static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        boolean run = true;
        DirFileCache dirFileCache = null;
        String dirForCache;
        while (run) {
            System.out.println("Menu:");
            System.out.println("1. Выбрать директорию для кэширования.");
            System.out.println("2. Загрузить файл в кэш");
            System.out.println("3. Получить содержимое файла из кэша");
            System.out.println("4. Выход");
            Scanner scanner = new Scanner(System.in);
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                System.out.println("Введите директорию: ");
                dirForCache = readInput();
                dirFileCache = new DirFileCache(dirForCache);
            }
            if (select == 2) {
                System.out.println("Введите нзвание файла: ");
                String file = readInput();
                if (dirFileCache != null) {
                    dirFileCache.load(file);
                } else {
                    System.out.println("Не введена директория для кэширования");
                }
            }
            if (select == 3) {
                System.out.println("Введите нзвание файла: ");
                String file = readInput();
                if (dirFileCache != null) {
                    System.out.println(dirFileCache.get(file));
                } else {
                    System.out.println("Не введена директория для кэширования");
                }
            }
            if (select == 4) {
                run = false;
                System.out.println("До свидания!");
            }
        }
    }
}
