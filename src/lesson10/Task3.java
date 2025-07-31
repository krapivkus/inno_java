package lesson10;

/*
Задача 3*. Задана строка, состоящая из букв английского алфавита,
разделенных одним пробелом. Необходимо каждую последовательность
символов упорядочить по возрастанию и вывести слова в нижнем регистре.

Входные данные: в единственной строке последовательность символов
представляющее два слова.

Выходные данные: упорядоченные по возрастанию буквы в нижнем
регистре.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String input = "Avada KedavRA";
        String[] parts = input.toLowerCase().split(" ");

        char[] left = parts[0].toCharArray();
        char[] right = parts[1].toCharArray();

        Arrays.sort(left);
        Arrays.sort(right);

        System.out.println(new String(left) + " " + new String(right));
    }
}
