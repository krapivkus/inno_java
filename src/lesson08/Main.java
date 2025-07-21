package lesson08;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Задача 1. Составить программу вывода на экран в одну строку сообщения
        // «Привет, имя_пользователя», где «имя_пользователя» - это введёное в консоль
        // имя, для выполнения данного задания нужно использовать класс Scanner.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        String username  = scanner.nextLine();
        System.out.printf("Привет, %s!\n\n\n", username);

        // Задача 2*. Вася и Петя играют в игру “Камень, ножницы, бумага”.
        // Каждый из них показывает свою фигуру камень-0, ножницы-1, бумага-2.
        // Программа определяет, кто из них выиграл.
        // Выбор каждого участника формируется случайным образом.

        Random random = new Random();

        Map<Integer, String> RPS_names = Map.of(
                0, "Камень",
                1, "Ножницы",
                2, "Бумага"
        );

        int vasya, petya, result;

        for (int i = 0; i < 9; i++) {
            vasya = random.nextInt(3);
            petya = random.nextInt(3);

            result = vasya == petya ? 1 : ((vasya + 1) % 3 == petya ? 0 : 2); // тут я задумался что-то

            System.out.printf(
                "Раунд %d\t Вася выкинул: %s\t Петя выкинул: %s\t%s\n",
                i + 1,
                RPS_names.get(vasya),
                RPS_names.get(petya),
                result == 1 ? "ничия" : (result == 0 ? "победил Вася" : "победил Петя")
            );
        }

    }
}
