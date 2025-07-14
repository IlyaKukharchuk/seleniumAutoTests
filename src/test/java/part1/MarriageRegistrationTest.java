package part1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebElement surname2Input = driver.findElement(By.xpath("//input[@placeholder='Введите фамилию (минимум 2 символа)']"));
        WebElement username2Input = driver.findElement(By.xpath("//input[@placeholder='Введите имя (минимум 2 символа)']"));
        WebElement middleName2Input = driver.findElement(By.xpath("//input[@placeholder='Введите отчество (минимум 5 символов)']"));
        WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder='дд/мм/гггг"));
        WebElement passport3Input = driver.findElement(By.xpath("//input[@placeholder='Введите номер паспорта (не более 8 символов)']"));
        WebElement sexInput = driver.findElement(By.xpath("//input[@placeholder='Введите адрес прописки']"));

        // Заполняем форму
        surnameInput.sendKeys("Иванов");
        usernameInput.sendKeys("Иван");
        middleNameInput.sendKeys("Иванович");
        phoneInput.sendKeys("375290000000");
        passportInput.sendKeys("12345678");
        addressInput.sendKeys("Ул. Московская, 5");
        nextButton.click();

        // Даные услуги
        // Статус заявки

    }

    @AfterClass
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}