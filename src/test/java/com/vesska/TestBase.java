package com.vesska;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.vesska.config.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
