package ru.tuz.tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.tuz.utils.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TuzTests   {
    @BeforeEach
     void setUp(){

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        open("https://www.tuz-saratov.ru/");
    }
    @EnumSource(Language.class)
    @ParameterizedTest
    void checkTitleTest(Language language){
        $(".lang").$(byText(language.name())).click();
        $(".main-page").shouldHave(text(language.description));
    }
}
