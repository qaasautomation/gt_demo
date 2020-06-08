package com.example.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class ExampleTest {
    @Test
    public void testCanSignIn() {
        System.out.printf("Test");
        Selenide.open("https://angular.realworld.io/");
        $("body > app-root > app-layout-header > nav > div > ul > li:nth-child(2) > a").click();
        $("body > app-root > app-auth-page > div > div > div > div > form > fieldset > fieldset:nth-child(2) > input").setValue("test@test.com");
        $("body > app-root > app-auth-page > div > div > div > div > form > fieldset > fieldset:nth-child(3) > input").setValue("123456");
        $("body > app-root > app-auth-page > div > div > div > div > form > fieldset > button").click();
        $("body > app-root > app-auth-page > div > div > div > div > app-list-errors > ul > li").shouldHave(Condition.exactText(" email or password is invalid "));
    }
}