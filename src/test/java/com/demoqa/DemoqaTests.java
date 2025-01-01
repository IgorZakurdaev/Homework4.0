package com.demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.StudentRegistrationFormAsserts;

import static utils.TestDataForDemoqaTests.*;

public class DemoqaTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    StudentRegistrationFormAsserts response = new StudentRegistrationFormAsserts();


    @Test
    @DisplayName("Проверка успешного сценария с максимальным количеством полей и маппинга в ответ сервиса")
    void studentRegistrationFormSuccessMaxTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .gender(gender)
                .number(number)
                .dateOfBirth(day, months, year)
                .subjectsInput(subjects)
                .hobbies(hobbies)
                .uploadPicture(picture)
                .address(address)
                .state(state)
                .city(city)
                .submit();
         response.checkResultForMaxFields();
    }

    @Test
    @DisplayName("Проверка успешного сценария с минимальным количеством параметров")
    void studentRegistrationFormSuccessMinTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .gender(gender)
                .number(number)
                .submit();
        response.checkResultForMinFields();
    }

    @Test
    @DisplayName("Проверка сценария с отправкой формы без обязательного параметра")
    void studentRegistrationFormWithoutRequiredParameter() {
        registrationPage.openPage()
                .removeBanners()
                .setLastName(lastName)
                .gender(gender)
                .number(number)
                .submit();
        response.checkResultWithoutRequiredParameter();
    }

}
