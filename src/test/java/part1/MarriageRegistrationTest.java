package part1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class MarriageRegistrationTest {
    WebDriver driver;
    WebDriverWait wait;

    final String VALID_USERNAME = "user";
    final String VALID_PASSWORD = "senlatest";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Авторизация через URL
        driver.get("https://" + VALID_USERNAME + ":" + VALID_PASSWORD + "@regoffice.senla.eu/");
    }

    @Test(priority = 1)
    public void testEnterAsUser() {
        // Ждем и кликаем кнопку "Войти как пользователь"
        WebElement enterAsUserButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div//button[1]")));
        enterAsUserButton.click();

        // Ждем появления формы регистрации
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@id,'TextInputField')]")));
    }

    @Test(priority = 2, dependsOnMethods = "testEnterAsUser")
    public void testFillMarriageForm() throws InterruptedException {
        Thread.sleep(500);

        // Данные заявителя
        // Находим все поля формы
        WebElement surnameInput = driver.findElement(By.xpath("//input[@placeholder='Введите фамилию (минимум 2 символа)']"));
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Введите имя (минимум 2 символа)']"));
        WebElement middleNameInput = driver.findElement(By.xpath("//input[@placeholder='Введите отчество (минимум 5 символов)']"));
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Введите номер телефона (не более 11 символов)']"));
        WebElement passportInput = driver.findElement(By.xpath("//input[@placeholder='Введите номер паспорта (не более 8 символов)']"));
        WebElement addressInput = driver.findElement(By.xpath("//input[@placeholder='Введите адрес прописки']"));
        WebElement nextButton = driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[2]"));

        // Заполняем форму
        surnameInput.sendKeys("Иванов");
        usernameInput.sendKeys("Иван");
        middleNameInput.sendKeys("Иванович");
        phoneInput.sendKeys("375290000000");
        passportInput.sendKeys("12345678");
        addressInput.sendKeys("Ул. Московская, 5");
        nextButton.click();

        // Выбор услуги
        WebElement marriageButton = driver.findElement(By.xpath("//button[contains(text(), 'Регистрация брака')]"));
        marriageButton.click();

        // Данные гражданина
        WebElement surname2Input = driver.findElement(By.xpath("//label[contains(text(), 'Фамилия')]/following::input[1]"));
        WebElement username2Input = driver.findElement(By.xpath("//label[contains(text(), 'Имя')]/following::input[1]"));
        WebElement middleName2Input = driver.findElement(By.xpath("//label[contains(text(), 'Отчество')]/following::input[1]"));
        WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder='дд/мм/гггг']"));
        WebElement passport2Input = driver.findElement(By.xpath("//label[contains(text(), 'Номер паспорта')]/following::input[1]"));
        WebElement adress2Input = driver.findElement(By.xpath("//input[@placeholder='Введите адрес прописки']"));
        WebElement sexInput = driver.findElement(By.xpath("//label[contains(text(), 'Пол')]/following::input[1]"));
        WebElement doneButton = driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[3]"));

        // Заполняем форму
        surname2Input.sendKeys("Иванов");
        username2Input.sendKeys("Иван");
        middleName2Input.sendKeys("Иванович");
        dateInput.sendKeys("22062007");
        passport2Input.sendKeys("12345678");
        sexInput.sendKeys("м");
        adress2Input.sendKeys("Ул. Московская, 54");
        doneButton.click();

        // Даные услуги
        WebElement registrationDate = driver.findElement(By.xpath("//label[contains(text(), 'Дата регистрации')]/following::input[1]"));
        WebElement newSurnameInput = driver.findElement(By.xpath("//label[contains(text(), 'Новая фамилия')]/following::input[1]"));
        WebElement spouseSurnameInput = driver.findElement(By.xpath("//label[contains(text(), 'Фамилия супруга/и')]/following::input[1]"));
        WebElement spouseNameInput = driver.findElement(By.xpath("//label[contains(text(), 'Имя супруга/и')]/following::input[1]"));
        WebElement spouseMiddleNameInput = driver.findElement(By.xpath("//label[contains(text(), 'Отчество супруга/и')]/following::input[1]"));
        WebElement spouseBirthDay = driver.findElement(By.xpath("//label[contains(text(), 'Дата рождения супруга/и')]/following::input[1]"));
        WebElement spousePassport = driver.findElement(By.xpath("//label[contains(text(), 'Номер паспорта супруга/и')]/following::input[1]"));

        // Заполняем форму
        registrationDate.sendKeys("22222222");
        newSurnameInput.sendKeys("Малахов");
        spouseSurnameInput.sendKeys("Иванов");
        spouseNameInput.sendKeys("Андрей");
        spouseMiddleNameInput.sendKeys("Иванович");
        spouseBirthDay.sendKeys("33112004");
        spousePassport.sendKeys("12345678");
        doneButton.click();

        // Статус заявки
        WebElement invoiceStatus = driver.findElement(By.xpath("//span[contains(text(), 'Статус заявки:')]"));
        String invoiceStatusText = invoiceStatus.getText();

        // Использование утверждения для проверки условия
        Assert.assertTrue(invoiceStatusText.contains("На рассмотрении"), "Текст должен содержать фразу: На рассмотрении");
    }


    @AfterClass
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}