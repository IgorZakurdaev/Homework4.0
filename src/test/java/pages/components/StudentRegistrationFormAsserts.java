package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormAsserts {
    public void checkResultForMaxFields(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave((text("Вася Пупкин")));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave((text("vasyaPupkin@mail.ru")));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave((text("Female")));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave((text("8979765432")));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave((text("11 December,1984")));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave((text("History")));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave((text("Sports, Music")));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave((text("lobster-07.jpg")));
        $(".table-responsive").$(byText("Address")).parent().shouldHave((text("Проспект танцующих слонов, 5")));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave((text("NCR Delhi")));
    }
    public void checkResultForMinFields(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }
    public void checkResultWithoutRequiredParameter(){
        $("*").shouldNotHave(text("Thanks for submitting the form"));

    }

}
