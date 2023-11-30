package demo;

import org.junit.jupiter.api.Test;
public class AutomationFilledForm extends TestBase {

    @Test
    void automationPractice() {
        //variables
        String firstName = "Olga";
        String lastName = "Isaeva";
        String email = "test12@mail.ru";
        String phoneNumber = "8981666666";
        String address = "Mashinostroiteley 5-150";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender("Female")
                .setPhone(phoneNumber)
                .setBirthDay("12", "October", "1994");

        registrationPage.checkAllHobies()
                        .setObjectsInput("Physics")
                        .uploadPicture("qa-2-min.png")
                        .setAddress(address)
                        .setStateCity("Haryana","Karnal")
                        .submitButtonClick();

        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", email)
                        .verifyResult("Gender", "Female")
                        .verifyResult("Mobile", phoneNumber)
                        .verifyResult("Date of Birth", "12 October,1994")
                        .verifyResult("Subjects", "Physics")
                        .verifyResult("Hobbies", "Sports, Reading, Music")
                        .verifyResult("Picture", "qa-2-min.png")
                        .verifyResult("Address", address)
                        .verifyResult("State and City", "Haryana Karnal");

    }
}
