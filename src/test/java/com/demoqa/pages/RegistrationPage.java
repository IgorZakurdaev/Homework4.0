package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderWrapper = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjects = $("#subjectsInput");
    private SelenideElement hobbies = $("div#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement state = $("#stateCity-wrapper");
    private SelenideElement submit = $("#submit");


    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public SelenideElement getFirstNameInput() {
        return firstNameInput;
    }

    public RegistrationPage setLastName(String name) {
        lastNameInput.setValue(name);
        return this;
    }
    public SelenideElement getLastNameInput() {
        return lastNameInput;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage gender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage number(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage dateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage subjectsInput(String subjectsInput) {
        subjects.setValue(subjectsInput).pressEnter();
        return this;
    }

    public RegistrationPage hobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage address(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage state(String value) {
        $("#state").click();
        state.$(byText(value)).click();
        return this;
    }

    public RegistrationPage city(String value) {
        $("#city").click();
        state.$(byText(value)).click();
        return this;
    }

    public void submit() {
        submit.click();
    }
}
