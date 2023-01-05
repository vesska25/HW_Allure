package com.vesska;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "vesska25/JavaBasics2";
    private static final String ISSUE = "testIssue";

    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("s.savich")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия Issue в репозитории с лямбда шагами")
    @Test
    public void openIssueTestWithSteps() {


        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем в поиске репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Нажимаем на ссылку репозитория "+ REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Переходим во вкладу Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });
    }
}

