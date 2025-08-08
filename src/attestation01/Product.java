package attestation01;

/*
 Нейросеть говорит что лучшая практика для неизменяемых объектов в
 современной Джаве - это рекорды. Сразу создает и хэш, и тустриг
 и геттеры. Тут это подходит.
 */

public record Product(String name, int price) {
    public Product {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }

        if (name == null) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        if (name.length() < 3) {
            throw new IllegalArgumentException("Название не может быть короче 3-х символов");
        }
    }

    @Override
    public String toString() {
        return "Продукт: %s, Цена: %s шекелей".formatted(name, price);
    }
}
