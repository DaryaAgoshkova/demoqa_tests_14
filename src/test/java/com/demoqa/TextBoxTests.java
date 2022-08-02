package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000; // 10 seconds
        Configuration.browser = "chrome";
        Configuration.browserSize = "1910x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
//        $("[id=userName]").setValue("Daria");
        $("#userName").setValue("Daria");
        $("#userEmail").setValue("daryatester@gmail.com");
        $("#currentAddress").setValue("Some Test Address");
        $("#permanentAddress").setValue("Another Test Address");
        $("#submit").click();

        $("#submit").click();
        $("#output").shouldHave(text("Daria"));
//        $("#output").shouldHave(text("daryatester@gmail.com"));
//        $("#output").shouldHave(text("Some Test Address"));
//        $("#output").shouldHave(text("Another Test Address"));
        $("#output #name").shouldHave(text("Daria"));
        $("#output #email").shouldHave(text("daryatester@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Some Test Address"));
        $("#output #permanentAddress").shouldHave(text("Another Test Address"));
    }
}
