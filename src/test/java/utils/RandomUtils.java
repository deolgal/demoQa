package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getRandomSurname() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomPhoneNumber () {
        return new Faker().phoneNumber().phoneNumber();
    }

    public static String getRandomAddress () {
        return new Faker().address().fullAddress();

    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

     public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }
}