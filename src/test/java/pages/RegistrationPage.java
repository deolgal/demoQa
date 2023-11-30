package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            uploadPictureInput = $("#uploadPicture"),
            subjectInput = $("#subjectsInput"),
            phoneInput = $("#userNumber"),
            submitButton = $("#submit"),
            setAddress = $("#currentAddress");

    private String pathToResources = "src/test/resources/";

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender (String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;


    }

    public RegistrationPage setPhone (String value) {
        phoneInput.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day,month,year);
        return this;

    }

    public RegistrationPage verifyResultsModalAppears () {
        registrationResultsModal.registrationModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key,String value) {
        registrationResultsModal.verifyResult(key,value);
        return this;
    }

    public RegistrationPage checkAllHobies() {
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        return this;
    }
    public RegistrationPage setObjectsInput (String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        uploadPictureInput.uploadFile(new File(pathToResources + value));
        return this;
    }

    public RegistrationPage setAddress (String value) {
        setAddress.setValue(value);
        return this;
    }

    public RegistrationPage setStateCity (String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrationPage submitButtonClick () {
        submitButton.click();
        return this;
    }
}
