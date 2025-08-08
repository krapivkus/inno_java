package attestation01;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
    private static final String[] TEST_DATA = new String[] {"""
Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10
Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150
Павел Андреевич - Хлеб
Павел Андреевич - Масло
Анна Петровна - Кофе растворимый
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Торт
Борис - Торт
Павел Андреевич - Торт
END
""", """
Женя = 0
Мороженое = 200
Женя - Мороженое
END
""", """
Света = -3
""", """
Фа = 100
"""};

    private static final Pattern MATCH_PATTERN
        = Pattern.compile("([\\p{L} ]+ *= *-?\\d+)( *; *[\\p{L} ]+ *= *-?\\d+)*");
    private static final Pattern SEARCH_PATTERN
        = Pattern.compile("([\\p{L} ]+) *= *(-?\\d+)");
    private static final Pattern TRADE_PATTERN
        = Pattern.compile("([\\p{L} ]+) *- *([\\p{L} ]+) *");


    public static void process_data(Scanner scanner) {
        Map<String, Person> persons = new HashMap<>();
        Map<String, Product> products = new HashMap<>();

        int line_index = 0;

        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().strip();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.equals("END")) {
                    break;
                }

                if (line_index < 2) { // Инициируем данные
                    if (!MATCH_PATTERN.matcher(line).matches()) {
                        System.out.println("Передана недопустимая строка с %s, давай еще".formatted(
                            line_index == 0 ? "людишками" : "продуктами"
                        ));
                        continue;
                    }

                    Matcher m = SEARCH_PATTERN.matcher(line);

                    if (line_index == 0) {
                        while (m.find()) {
                            persons.put(
                                m.group(1).strip(),
                                new Person(m.group(1).strip(), Integer.parseInt(m.group(2).strip()))
                            );
                        }
                    } else {
                        while (m.find()) {
                            products.put(
                                m.group(1).strip(),
                                new Product(m.group(1).strip(), Integer.parseInt(m.group(2).strip()))
                            );
                        }
                    }

                    for (Object it : line_index == 0 ? persons.values() : products.values()) {
                        System.out.println(it);
                    }

                    line_index++;

                    if (line_index == 2) {
                        System.out.println("\n===========[ Покупки ]===========");
                    }
                } else { // Покупки
                    Matcher m = TRADE_PATTERN.matcher(line);

                    if (!m.matches()) {
                        System.out.println("Недопустимая строка покупки");
                        continue;
                    }

                    String person_name = m.group(1).strip();

                    if (!persons.containsKey(person_name)) {
                        System.out.println("Нет такого покупателя");
                        continue;
                    }

                    String product_name = m.group(2).strip();

                    if (!products.containsKey(product_name)) {
                        System.out.println("Нет такого товара");
                        continue;
                    }

                    persons.get(person_name).buy(products.get(product_name));
                }
            }
        } finally {
            System.out.println("\n===========[ Результат ]===========");

            for (Person person : persons.values()) {
                person.printData();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < TEST_DATA.length; i++) {
            System.out.println("======== [ТЕСТ %s] ========".formatted(i));

            try {
                App.process_data(new Scanner(TEST_DATA[i]));
            } catch (Exception e) {
                System.out.println("Произошла чудовищная ошибка: %s".formatted(e.getMessage()));
            }

        }

//        App.process_data(new Scanner(System.in));

    }
}
