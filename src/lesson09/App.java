package lesson09;

import java.util.*;

class TV {
    private String model;
    private Date created;

    private int currentChannel = 0;
    private boolean isOn = false;

    public TV(String model) {
        this(model, new Date());
    }

    public TV(String model, Date created) {
        this.model = model;
        this.created = created;

        this.isOn = false;
        this.currentChannel = 1;
    }

    @Override
    public String toString() {
        return String.format(
                "Модель Телевизора: %s\nДата выпуска: %s\nСостояние: %s\nКанал: %s\n",
                this.model,
                this.created,
                this.isOn ? "Включен" : "Выключен",
                this.currentChannel
        );
    }

    public String getModel() {
        return model;
    }

    public Date getCreated() {
        return created;
    }

    public void turnOn() {
        if (!this.isOn) {
            System.out.println("Включили телевизор");
            this.isOn = true;
        }
    }

    public void turnOff() {
        if (this.isOn) {
            System.out.println("Выключили телевизор");
            this.isOn = false;
        }
    }

    public void setChannel(int channel) throws IllegalArgumentException {
        if (channel < 1 || channel > 99) {
            throw new IllegalArgumentException("Канал может быть только от 1 до 99");
        }

        System.out.println("Переключили на канал " + channel);

        this.currentChannel = channel;
    }

    public int getChannel() {
        return currentChannel;
    }
}

/*
**Формулировка задания:**
Реализовать класс Телевизор. У класса есть поля, свойства и методы.
Проверить работу в классе App, методе main.
*/

/*
**Ожидаемый результат:**
1. Создан класс Телевизор;
2. У класса есть поля, свойства и методы. Поля желательно сделать
private. Задать новые значения полям класса можно через конструктор.
4. Создан класс App с методом main.
5. В методе main класса App создано несколько экземпляров класса
Телевизор.
6. Дополнительно. Задавать параметры класса Телевизор с клавиатуры
или случайным числом
*/

public class App {
    public static void main(String[] args) {
        List<TV> tvs = new ArrayList<>();

        tvs.add(new TV("A231"));

        //////////////////////////////////

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите модель телевизора: ");
        String model  = scanner.nextLine();

        tvs.add(new TV(model));

        ///////////////////////////////

        Random random = new Random();

        tvs.add(new TV(String.format("M%s", random.nextInt(899) + 100)));

        for (TV tv : tvs) {
            if (random.nextBoolean()) {
                tv.turnOn();
            } else {
                tv.turnOff();
            }

            tv.setChannel(random.nextInt(97) + 1);

            System.out.println(tv);
        }
    }
}
