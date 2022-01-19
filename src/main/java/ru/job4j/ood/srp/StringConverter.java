package ru.job4j.ood.srp;

/*
Метод должен решать одну задачу по конвертации строки.
Но он ещё дополнительно считает количство определенных символов.
И выводит информацию в консоль.
 */
public class StringConverter {
    public String convertString(String str) {
        String newString = str.replace(";", ".");
        long counter = newString.chars()
                .filter(ch -> ch == '.')
                .count();
        System.out.println("В строке \"" + newString + "\"" + counter + " точек");
        return newString;
    }

    public static void main(String[] args) {
        StringConverter stringConverter = new StringConverter();
        stringConverter.convertString("Я гуляю по Москве; У прохожих на виду; Я люблю свою Москву; Но уехать так хочу;");
    }
}
