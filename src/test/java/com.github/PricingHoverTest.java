package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PricingHoverTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.headless = true;
    }

    @Test
    void currentPage() {
        open(Configuration.baseUrl);
        $(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        $(".h2-mktg").shouldHave(text("Choose the plan that’s right for you."));
    }
}
