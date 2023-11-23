package demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AutomationFilledForm {
    @BeforeAll
    static void beforeAll () {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void automationPractice () {
        open("https://demoqa.com/automation-practice-form");
        Selenide.$("#lastName").shouldBe(Condition.visible);
    }
}
