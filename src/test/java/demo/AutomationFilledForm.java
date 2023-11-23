package demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationFilledForm {
    @BeforeAll
    static void beforeAll () {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void automationPractice () {
        //variables
        String firstName = "Olga";
        String lastName = "Isaeva";
        String email = "test12@mail.ru";
        String phoneNumber = "8981666666";
        String address = "Mashinostroiteley 5-150";

        open("/automation-practice-form");
        //fill form
        $(byText("Female")).click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirth div.react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").click();
        $(byText("October")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1994")).click();
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/qa-2-min.png"));
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        /// hide overlay banners
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".btn-primary").click();
        $(".table-responsive").shouldHave(Condition.text(firstName),Condition.text(lastName),Condition.text(address),Condition.text(email),Condition.text("qa-2-min.png"),Condition.text("Haryana Panipat"),Condition.text(phoneNumber));





    }
}
