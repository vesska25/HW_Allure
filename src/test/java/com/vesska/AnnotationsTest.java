package com.vesska;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AnnotationsTest {

    private static final String REPOSITORY = "vesska25/JavaBasics2";
    private static final String ISSUE = "testIssue";


    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Ищем в поиске репозиторий " + REPOSITORY)
    public void searchRepository(){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
    }

    @Step("Нажимаем на ссылку репозитория "+ REPOSITORY)
    public void repositoryClickLink() {
        $(linkText(REPOSITORY)).click();
    }

    @Step("Переходим во вкладу Issues")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue " + ISSUE)
    public void checkIssue() {
        $(withText(ISSUE)).should(Condition.exist);
    }

    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("s.savich")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия Issue в репозитории с аннотациями")
    @Test
    public void webTestWithAnnotations() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationsTest steps = new AnnotationsTest();

        steps.openMainPage();
        steps.searchRepository();
        steps.repositoryClickLink();
        steps.openIssue();
        steps.checkIssue();

    }
}

