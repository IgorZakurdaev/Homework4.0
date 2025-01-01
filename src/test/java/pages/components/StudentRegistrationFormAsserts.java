package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.TestDataForDemoqaTests.*;

public class StudentRegistrationFormAsserts {
    public void checkResultForMaxFields() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave((text(firstName+" "+lastName)));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave((text(email)));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave((text(gender)));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave((text(number)));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave((text(day+" "+months+","+year)));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave((text(subjects)));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave((text(hobbies)));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave((text(picture)));
        $(".table-responsive").$(byText("Address")).parent().shouldHave((text(address)));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave((text(state+" "+city)));
    }

    public void checkResultForMinFields() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void checkResultWithoutRequiredParameter() {
        $("*").shouldNotHave(text("Thanks for submitting the form"));

    }

}
