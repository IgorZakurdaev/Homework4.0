package com.demoqa.pages.components;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();
    public void checkResult(String name,String value) {
        $(".table-responsive").$(byText(name)).parent().shouldHave((text(value)));
    }

    public void checkModalTitle() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void checkResultWithoutRequiredParameter() {
        $("*").shouldNotHave(text("Thanks for submitting the form"));

    }

}
