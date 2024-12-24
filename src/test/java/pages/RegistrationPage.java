package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent =new CalendarComponent();
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    private SelenideElement firstNameInput =$("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput =$("#userEmail"),
    genderWrapper =$("#genterWrapper"),
    userNumberInput = $("#userNumber"),
    dateOfBirthInput = $("#dateOfBirthInput"),
    subjects =$("#subjectsInput"),
    hobbies =$("div#hobbiesWrapper"),
    uploadPicture=$("#uploadPicture"),
    currentAddress=$("#currentAddress"),
    state = $("#stateCity-wrapper"),
    submit = $("#submit");



    public RegistrationPage setFirstName (String name){
        firstNameInput.setValue(name);
        return this;
    }
    public RegistrationPage setLastName (String name){
        lastNameInput.setValue(name);
        return this;
    }
    public RegistrationPage setEmail (String email){
        userEmailInput.setValue(email);
        return this;
    }
    public RegistrationPage gender (String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage number (String number) {
        userNumberInput.setValue(number);
        return this;
    }
    public RegistrationPage dateOfBirth (String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    public RegistrationPage subjectsInput (String subjectsInput) {
        subjects.setValue(subjectsInput).pressEnter();
        return this;
    }
    public RegistrationPage hobbies (String value) {
        hobbies.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadPicture (String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }
    public RegistrationPage address (String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage state (String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage city (String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public void submit () {
        submit.click();
    }
}
