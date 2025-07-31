package lesson10;

/*
Задача 2. Задана последовательность, состоящая только из символов ‘>’,
‘<’ и ‘-‘. Требуется найти количество стрел, которые спрятаны в этой
последовательности. Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.

Входные данные: в первой строке входного потока записана строка,
состоящая из символов ‘>’, ‘<’ и ‘-‘ (без пробелов). Строка может содержать до
106 символов.

Выходные данные: в единственную строку выходного потока нужно
вывести искомое количество стрелок.
 */

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int t;

        for (int i = 0; i < 106; i++) {
            t = random.nextInt(3);
            sb.append(t == 0 ? '<' : (t == 1 ? '>' : "-"));
        }

        String s = sb.toString();

        System.out.println(s);
        System.out.println("==============================================");

        int result = 0;
        int l, r, i;

        while (true) {
            l = s.indexOf("<--<<");
            r = s.indexOf(">>-->");

            if  (l == -1 && r == -1) {
                System.out.println(s);
                break;
            } else {
                i = r > 0 && r > l ? r : l;

                System.out.println(s.substring(0, i));
                System.out.println(s.substring(i, i + 5) + " (" + ++result + ")");

                s = s.substring(i + 5);
            }
        }

        System.out.println("==============================================");
        System.out.println("Ответ: " + result);
    }
}
