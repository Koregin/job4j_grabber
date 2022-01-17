package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Класс для работы с пользователем
 * Представляет возможности для пользователя:
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 */

public class Emulator {
    private static DirFileCache dirFileCache = null;

    private static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static boolean checkPath(String path) {
        boolean result = true;
        if (!Files.exists(Path.of(path))) {
            System.out.printf("Файл %s не найден%s", path, System.lineSeparator());
            result = false;
        }
        return result;
    }

    private static void fileAction(Integer action) {
        System.out.println("Введите название файла: ");
        String file = readInput();
        if (dirFileCache != null) {
            if (checkPath(dirFileCache.getCachingDir() + file)) {
                if (action == 2) {
                    dirFileCache.load(file);
                } else if (action == 3) {
                    System.out.println(dirFileCache.get(file));
                }
            }
        } else {
            System.out.println("Не введена директория для кэширования");
        }
    }

    public static void main(String[] args) {
        boolean run = true;
        String dirForCache;
        while (run) {
            System.out.println("Menu:");
            System.out.println("1. Выбрать директорию для кэширования.");
            System.out.println("2. Загрузить файл в кэш");
            System.out.println("3. Получить содержимое файла из кэша");
            System.out.println("4. Выход");
            System.out.println(DirFileCache.lookupLoadCalls.get());
            Scanner scanner = new Scanner(System.in);
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                System.out.println("Введите директорию: ");
                dirForCache = readInput();
                if (checkPath(dirForCache)) {
                    dirFileCache = new DirFileCache(dirForCache);
                }
            }
            if (select == 2) {
                fileAction(select);
            }
            if (select == 3) {
                fileAction(select);
            }
            if (select == 4) {
                run = false;
                System.out.println("До свидания!");
            }
        }
    }
}
