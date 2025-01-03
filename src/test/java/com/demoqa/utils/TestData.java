package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    static Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String number = faker.number().digits(10);
    public String address = faker.address().fullAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String subjects = faker.options().option("English", "Chemistry", "Physics", "Commerce",
            "Social Studies", "Hindi", "Biology");
    public static String months = faker.options().option("December", "November", "January", "February", "March", "April", "May"
            , "June", "July", "August", "September", "October");
    public String year =String.valueOf(faker.number().numberBetween(1920,2024));
    public String day = String.valueOf(faker.number().numberBetween(1,28));
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);
    public String picture = faker.options().option("lobster-07.jpg", "tiger.png");

    public static String getRandomCity(String state) {
        switch (state) {
            case ("NCR"):
                String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
                return getRandomItemFromArray(cityNCR);
            case ("Uttar Pradesh"):
                String[] cityUP = {"Agra", "Lucknow", "Merrut"};
                return getRandomItemFromArray(cityUP);
            case ("Haryana"):
                String[] cityHaryana = {"Karnal", "Panipat"};
                return getRandomItemFromArray(cityHaryana);
            case ("Rajasthan"):
                String[] cityRajasthan = {"Jaipur", "Jaiselmer"};
                return getRandomItemFromArray(cityRajasthan);
            default:
                return null;


        }
    }


    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];

    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    public static String getRandomNumber(int min, int max) {
        int i = (ThreadLocalRandom.current().nextInt(min, max + 1));
        if (i < 10) {
            String j = Integer.toString(i);
            String x = "0" + j;
            return x;
        }
        String j = Integer.toString(i);
        return j;

    }


}
