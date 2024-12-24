package com.demoqa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.StudentRegistrationFormAsserts;

public class DemoqaTests extends TestBase {
    RegistrationPage registrationPage =new RegistrationPage();
    StudentRegistrationFormAsserts response = new StudentRegistrationFormAsserts();
    @Test
    @DisplayName ("Проверка успешного сценария с максимальным количеством полей и маппинга в ответ сервиса")
    void studentRegistrationFormSuccessMaxTest(){
        registrationPage.openPage()
        .setFirstName("Вася")
        .setLastName("Пупкин")
        .setEmail("vasyaPupkin@mail.ru")
        .gender("Female")
        .number("8979765432")
        .dateOfBirth("11","December","1984")
        .subjectsInput("History")
        .hobbies("Sports")
        .hobbies("Music")
        .uploadPicture("lobster-07.jpg")
        .address("Проспект танцующих слонов, 5")
        .state("NCR")
        .city("Delhi")
        .submit();
        response.checkResultForMaxFields();
    }
    @Test
    @DisplayName("Проверка успешного сценария с минимальным количеством параметров")
    void studentRegistrationFormSuccessMinTest(){
        registrationPage.openPage()
        .setFirstName("Вася")
        .setLastName("Пупкин")
        .gender("Female")
        .number("8979765432")
        .submit();
        response.checkResultForMinFields();
    }
    @Test
    @DisplayName("Проверка сценария с отправкой формы без обязательного параметра")
    void studentRegistrationFormWithoutRequiredParameter(){
        registrationPage.openPage()
                .setLastName("Пупкин")
                .gender("Female")
                .number("8979765432")
                .submit();
        response.checkResultWithoutRequiredParameter();
    }

}
