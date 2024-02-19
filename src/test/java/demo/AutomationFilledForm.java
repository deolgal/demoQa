package demo;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import java.util.Locale;

public class AutomationFilledForm extends TestBase {

    @Test
    void automationPractice() {
        Faker faker = new Faker();
        String [] genders = {"Male", "Female", "Other"};
        String [] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String [] citiesHaryana = {"Karnal", "Panipat"};
        String firstName = RandomUtils.getRandomName();
        String lastName = RandomUtils.getRandomSurname();
        String email = RandomUtils.getRandomEmail();
        String phoneNumber = String.valueOf(faker.number().numberBetween(1000000000L,9999999999L));
        String address = RandomUtils.getRandomAddress();
        String gender = RandomUtils.getRandomItemFromArray(genders);
        String monthOfBirth = RandomUtils.getRandomItemFromArray(monthArray);
        String dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
        String yearOfBirth = String.valueOf(faker.number().numberBetween(1900,2010));
        String city = RandomUtils.getRandomItemFromArray(citiesHaryana);

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhone(phoneNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth);

        registrationPage.checkAllHobies()
                        .setObjectsInput("Physics")
                        .uploadPicture("qa-2-min.png")
                        .setAddress(address)
                        .setStateCity("Haryana",city)
                        .submitButtonClick();

        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", email)
                        .verifyResult("Gender", gender)
                        .verifyResult("Mobile", phoneNumber)
                        .verifyResult("Date of Birth", dayOfBirth)
                        .verifyResult("Subjects", "Physics")
                        .verifyResult("Hobbies", "Sports, Reading, Music")
                        .verifyResult("Picture", "qa-2-min.png")
                        .verifyResult("Address", address)
                        .verifyResult("State and City", "Haryana " + city);

    }
}
