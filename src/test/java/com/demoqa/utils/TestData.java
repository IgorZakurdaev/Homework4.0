package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
    public String months;
    public String year;
    public String day;
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);
    public String picture = faker.options().option("lobster-07.jpg", "tiger.png");

    public static String getRandomCity(String state) {
        switch (state) {
            case ("NCR"):
                String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().option(cityNCR);
            case ("Uttar Pradesh"):
                String[] cityUP = {"Agra", "Lucknow", "Merrut"};
                return faker.options().option(cityUP);
            case ("Haryana"):
                String[] cityHaryana = {"Karnal", "Panipat"};
                return faker.options().option(cityHaryana);
            case ("Rajasthan"):
                String[] cityRajasthan = {"Jaipur", "Jaiselmer"};
                return faker.options().option(cityRajasthan);
            default:
                return null;


        }
    }

    public long randomTimestamp = ThreadLocalRandom.current().nextLong(
            new Date(0).getTime(),
            new Date().getTime());

    public TestData() {
        DateFormat dayFormat = new SimpleDateFormat("dd", Locale.UK);
        day = dayFormat.format(new Date(randomTimestamp));
        DateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.UK);
        months = monthFormat.format(new Date(randomTimestamp));
        DateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.UK);
        year = yearFormat.format(new Date(randomTimestamp));

    }

}



