package e2e;

import base.BaseTest;
import by.louegroove.seleniumfreecodecamp.valueobjects.ApplicantVO;
import by.louegroove.seleniumfreecodecamp.valueobjects.BirthDetailsVO;
import by.louegroove.seleniumfreecodecamp.valueobjects.CitizenVO;
import by.louegroove.seleniumfreecodecamp.valueobjects.MarriageDetailsVO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BirthdayRegistrationTest extends BaseTest {
    @Test
    public void testFillMarriageForm() {
        clickEnterAsUserButton();

        // Создание объектов с тестовыми данными
        ApplicantVO applicant = new ApplicantVO(
                "Иванов", "Иван", "Иванович",
                "375290000000", "12345678", "Ул. Московская, 5"
        );

        CitizenVO citizen = new CitizenVO(
                "Иванов", "Иван", "Иванович",
                "22062007", "12345678", "м", "Ул. Московская, 54"
        );

        BirthDetailsVO birthDetailsVO = new BirthDetailsVO(
                "Ул. Московская, 54", "Анита",
                "Иван", "Марья", "Иоанн"
        );

        // Заполнение форм
        fillApplicantForm(applicant);
        click(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[2]"));
        selectService();
        fillCitizenForm(citizen);
        click(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[3]"));
        fillBirthDetailsForm(birthDetailsVO);
        click(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[3]"));

        // Проверка статуса
        Assert.assertTrue(getApplicationStatus().contains("На рассмотрении"));
    }

    private void clickEnterAsUserButton() {
        driver.findElement(By.xpath("//div//button[2]")).click();
    }

    private void fillApplicantForm(ApplicantVO applicant) {
        type(By.xpath("//input[@placeholder='Введите фамилию (минимум 2 символа)']"), applicant.getSurname());
        type(By.xpath("//input[@placeholder='Введите имя (минимум 2 символа)']"), applicant.getName());
        type(By.xpath("//input[@placeholder='Введите отчество (минимум 5 символов)']"), applicant.getMiddleName());
        type(By.xpath("//input[@placeholder='Введите номер телефона (не более 11 символов)']"), applicant.getPhone());
        type(By.xpath("//input[@placeholder='Введите номер паспорта (не более 8 символов)']"), applicant.getPassport());
        type(By.xpath("//input[@placeholder='Введите адрес прописки']"), applicant.getAddress());
    }

    void selectService() {
        click(By.xpath("//button[contains(text(), 'Регистрация брака')]"));
    }

    private void fillCitizenForm(CitizenVO citizen) {
        type(By.xpath("//label[contains(text(), 'Фамилия')]/following::input[1]"), citizen.getSurname());
        type(By.xpath("//label[contains(text(), 'Имя')]/following::input[1]"), citizen.getName());
        type(By.xpath("//label[contains(text(), 'Отчество')]/following::input[1]"), citizen.getMiddleName());
        type(By.xpath("//input[@placeholder='дд/мм/гггг']"), citizen.getBirthDate());
        type(By.xpath("//label[contains(text(), 'Номер паспорта')]/following::input[1]"), citizen.getPassport());
        type(By.xpath("//label[contains(text(), 'Пол')]/following::input[1]"), citizen.getSex());
        type(By.xpath("//input[@placeholder='Введите адрес прописки']"), citizen.getAddress());
    }

    private void fillBirthDetailsForm(BirthDetailsVO details) {
        type(By.xpath("//label[contains(text(), 'Место рождения')]/following::input[1]"), details.getBirthAddress());
        type(By.xpath("//label[contains(text(), 'Мать')]/following::input[1]"), details.getMother());
        type(By.xpath("//label[contains(text(), 'Отец')]/following::input[1]"), details.getFather());
        type(By.xpath("//label[contains(text(), 'Бабушка')]/following::input[1]"), details.getGrandma());
        type(By.xpath("//label[contains(text(), 'Дедушка')]/following::input[1]"), details.getGrandpa());
    }

    private String getApplicationStatus() {
        return driver.findElement(By.xpath("//span[contains(text(), 'Статус заявки:')]")).getText();
    }

    // Вспомогательные методы
    private void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}