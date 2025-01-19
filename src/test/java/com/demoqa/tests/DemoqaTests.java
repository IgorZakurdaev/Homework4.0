package com.demoqa.tests;

import com.demoqa.utils.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.ResultTableComponent;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


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

    @ValueSource(strings = {"Male", "Female", "Other"})
    @ParameterizedTest(name = "Проверка возможных значений параметра Gender = {0}")
    void genderEnumTest(String gender) {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .gender(gender)
                .number(testData.number)
                .submit();
        response.checkModalTitle();
    }

    @CsvFileSource(resources = "/test_data/StateAndCityEnum.csv")
    @ParameterizedTest(name = "Проверка возможных значений параметров state={0} and city={1}")
    void stateAndCityEnumTest(String state, String city) {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .gender(testData.gender)
                .number(testData.number)
                .state(state)
                .city(city)
                .submit();
        response.checkModalTitle();
    }

    @ValueSource(strings = {"lobster-07.jpg", "tiger.png"})
    @ParameterizedTest(name = "Проверка возможных типов загружаемых файлов")
    void checkTypeOfUploadingFileTest(String picture) {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .gender(testData.gender)
                .number(testData.number)
                .uploadPicture(picture)
                .submit();
        response.checkModalTitle();
    }
}
