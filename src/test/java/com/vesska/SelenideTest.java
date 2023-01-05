package com.vesska;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {


    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("s.savich")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия Issue в репозитории")
    @Test
    public void openIssueTest() {

        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("vesska25/JavaBasics2");
        $(".header-search-input").submit();

        $(linkText("vesska25/JavaBasics2")).click();

        $("#issues-tab").click();
        $(withText("testIssue")).should(Condition.exist);
    }
}
