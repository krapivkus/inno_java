package lesson10;

import java.util.Scanner;

/*
Задача 1. Для введенной с клавиатуры буквы английского алфавита
нужно вывести слева стоящую букву на стандартной клавиатуре. При этом
клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a», а слева от "а"
буква "р", также соседними считаются буквы «l» и буква «z», а буква «m» с
буквой «q».

Входные данные: строка входного потока содержит один символ —
маленькую букву английского алфавита.

Выходные данные: следует вывести букву стоящую слева от заданной
буквы, с учетом замкнутости клавиатуры.
 */

public class Task1 {
    private static String LETTERS = "qwertyuiopasdfghjklzxcvbnm";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int position;

        while (true) {
            System.out.print("Введите символ:");

            input = scanner.nextLine();

            if (input.equals("quit")) {
                System.out.println("ПАКА!");
                break;
            }

            if (input.length() != 1) {
                System.out.println("Недопустимый ввод");
                continue;
            }

            position = LETTERS.indexOf(input.charAt(0));

            if (position == -1) {
                System.out.println("Неподходящий символ");
            } else {
                System.out.printf(
                    "Предыдущий в списке символ: %s\n",
                    position == 0 ? LETTERS.charAt(LETTERS.length() - 1) : LETTERS.charAt(position - 1)
                );
            }
        }
    }
}
