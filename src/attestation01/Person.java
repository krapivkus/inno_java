package attestation01;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int money;
    private List<Product> products = new LinkedList<>();

    public Person(String name, int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными!");
        }

        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3-х символов");
        }

        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return
            "Покупатель: %s, Денег в кармане: %s шекелей".formatted(
                this.name,
                this.money
            );
    }

    public void printData() {
        System.out.println(
            "Покупатель: %s\nДенег в кармане: %s шекелей\nПродуктов в сумке: %s на общую сумму %s шекелей".formatted(
                this.name,
                this.money,
                this.products.size(),
                this.products.stream().mapToInt(Product::price).sum()
            )
        );

        if (this.products.size() > 0) {
            System.out.println("Покупки: " + this.products.stream().map(Product::name).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Ничего не куплено Т_Т");
        }
    }

    /*
     В нашем случае идентичностью объекта можно считать только значение поля name
     остальное - состояние
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;

        /* по текущем методам мы видимо что name не будет пустым */

        return this.name.equals(person.name);
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buy(Product product) {
        if (this.money < product.price()) {
            System.out.printf("%s не может позволить себе %s\n".formatted(this.name, product.name()));
            return;
        }

        System.out.printf("%s покупает %s!!!\n".formatted(this.name, product.name()));

        this.products.add(product);
        this.money -= product.price();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
