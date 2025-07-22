package by.louegroove.seleniumfreecodecamp.pages.adminPage;

import by.louegroove.seleniumfreecodecamp.pages.BasePage;
import org.openqa.selenium.By;

public class RegistrationDetailsPage extends BasePage {
    private By surnameField = By.xpath("//label[contains(text(), 'Фамилия')]/following::input[1]");
    private By nameField = By.xpath("//label[contains(text(), 'Имя')]/following::input[1]");
    private By middlenameField = By.xpath("//label[contains(text(), 'Отчество')]/following::input[1]");
    private By phoneField = By.xpath("//label[contains(text(), 'Телефон')]/following::input[1]");
    private By passportField = By.xpath("//label[contains(text(), 'Номер паспорта')]/following::input[1]");
    private By birthdayField = By.xpath("//label[contains(text(), 'Дата рождения')]/following::input[1]");
    private By nextButton = By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[2]");


    public void setSurnameField(String surname) {
        set(surnameField, surname);
    }

    public void setNameField(String name) {
        set(nameField, name);
    }

    public void setMiddlenameField(String middlename) {
        set(middlenameField, middlename);
    }

    public void setPhoneField(String phone) {
        set(phoneField, phone);
    }

    public void setPassportField(String passport) {
        set(passportField, passport);
    }

    public void setBirthdayField(String birthday) {
        set(birthdayField, birthday);
    }

    private By welcomeText = By.xpath("//h2[contains(@style, MuiTypography-root)]//span[contains(text(), 'Вы вошли как')]//b[contains(text(), 'Aдминистратор')]");

    public ApplicationAdministrationPage clickNextButton() {
        click(nextButton);
        return new ApplicationAdministrationPage();
    }

    public boolean nextButtonIsDisabled() {
        return find(nextButton).getAttribute("disabled") != null;
    }

    public boolean isWelcomeTextDisplayed() {
        return find(welcomeText).isDisplayed();
    }

    public ApplicationAdministrationPage insertRegDetails(String surname, String name, String middlename, String phone, String passport, String birthday) {
        setSurnameField(surname);
        setNameField(name);
        setMiddlenameField(middlename);
        setPhoneField(phone);
        setPassportField(passport);
        setBirthdayField(birthday);
        return clickNextButton();
    }
}
