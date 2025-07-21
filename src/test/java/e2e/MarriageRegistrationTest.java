package e2e;

import base.BaseTest;
import by.louegroove.seleniumfreecodecamp.valueobjects.ApplicantVO;
import by.louegroove.seleniumfreecodecamp.valueobjects.CitizenVO;
import by.louegroove.seleniumfreecodecamp.valueobjects.MarriageDetailsVO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MarriageRegistrationTest extends BaseTest {
    @Test
    public void testFillMarriageForm() {
        clickEnterAsUserButton();

        // 2. Создание объектов с тестовыми данными
        ApplicantVO applicant = new ApplicantVO(
                "Иванов", "Иван", "Иванович",
                "375290000000", "12345678", "Ул. Московская, 5"
        );

        CitizenVO citizen = new CitizenVO(
                "Иванов", "Иван", "Иванович",
                "22062007", "12345678", "м", "Ул. Московская, 54"
        );

        MarriageDetailsVO marriageDetails = new MarriageDetailsVO(
                "22222222", "Малахов",
                "Иванов", "Андрей", "Иванович",
                "33112004", "12345678"
        );

        // 3. Заполнение форм
        fillApplicantForm(applicant);
        selectMarriageService();
        fillCitizenForm(citizen);
        fillMarriageDetailsForm(marriageDetails);

        // 4. Проверка статуса
        Assert.assertTrue(getApplicationStatus().contains("На рассмотрении"));
    }

    private void clickEnterAsUserButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div//button[1]"))).click();
    }

    private void fillApplicantForm(ApplicantVO applicant) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@id,'TextInputField')]")));

        type(By.xpath("//input[@placeholder='Введите фамилию (минимум 2 символа)']"), applicant.getSurname());
        type(By.xpath("//input[@placeholder='Введите имя (минимум 2 символа)']"), applicant.getName());
        type(By.xpath("//input[@placeholder='Введите отчество (минимум 5 символов)']"), applicant.getMiddleName());
        type(By.xpath("//input[@placeholder='Введите номер телефона (не более 11 символов)']"), applicant.getPhone());
        type(By.xpath("//input[@placeholder='Введите номер паспорта (не более 8 символов)']"), applicant.getPassport());
        type(By.xpath("//input[@placeholder='Введите адрес прописки']"), applicant.getAddress());

        click(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[2]"));
    }

    private void selectMarriageService() {
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

        click(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[3]"));
    }

    private void fillMarriageDetailsForm(MarriageDetailsVO details) {
        type(By.xpath("//label[contains(text(), 'Дата регистрации')]/following::input[1]"), details.getRegistrationDate());
        type(By.xpath("//label[contains(text(), 'Новая фамилия')]/following::input[1]"), details.getNewSurname());
        type(By.xpath("//label[contains(text(), 'Фамилия супруга/и')]/following::input[1]"), details.getSpouseSurname());
        type(By.xpath("//label[contains(text(), 'Имя супруга/и')]/following::input[1]"), details.getSpouseName());
        type(By.xpath("//label[contains(text(), 'Отчество супруга/и')]/following::input[1]"), details.getSpouseMiddleName());
        type(By.xpath("//label[contains(text(), 'Дата рождения супруга/и')]/following::input[1]"), details.getSpouseBirthDate());
        type(By.xpath("//label[contains(text(), 'Номер паспорта супруга/и')]/following::input[1]"), details.getSpousePassport());

        click(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[3]"));
    }

    private String getApplicationStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(), 'Статус заявки:')]"))).getText();
    }

    // Вспомогательные методы
    private void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}