package com.demoqa.tests;

import com.demoqa.utils.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.ResultTableComponent;


public class DemoqaTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent response = new ResultTableComponent();
    TestData testData = new TestData();


    @Test
    @DisplayName("Проверка успешного сценария с максимальным количеством полей и маппинга в ответ сервиса")
    void studentRegistrationFormSuccessMaxTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .gender(testData.gender)
                .number(testData.number)
                .dateOfBirth(testData.day, testData.months, testData.year)
                .subjectsInput(testData.subjects)
                .hobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .address(testData.address)
                .state(testData.state)
                .city(testData.city)
                .submit();
        response.checkModalTitle();
        response.checkResult("Student Name", testData.firstName + " " + testData.lastName);
        response.checkResult("Student Email", testData.email);
        response.checkResult("Gender", testData.gender);
        response.checkResult("Mobile", testData.number);
        response.checkResult("Date of Birth", testData.day + " " + testData.months + "," + testData.year);
        response.checkResult("Subjects", testData.subjects);
        response.checkResult("Hobbies", testData.hobbies);
        response.checkResult("Picture", testData.picture);
        response.checkResult("Address", testData.address);
        response.checkResult("State and City", testData.state + " " + testData.city);

    }

    @Test
    @DisplayName("Проверка успешного сценария с минимальным количеством параметров")
    void studentRegistrationFormSuccessMinTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .gender(testData.gender)
                .number(testData.number)
                .submit();
        response.checkModalTitle();
    }

    @Test
    @DisplayName("Проверка сценария с отправкой формы без обязательного параметра")
    void studentRegistrationFormWithoutRequiredParameter() {
        registrationPage.openPage()
                .removeBanners()
                .setLastName(testData.lastName)
                .gender(testData.gender)
                .number(testData.number)
                .submit();
        response.checkResultWithoutRequiredParameter();
    }

}
