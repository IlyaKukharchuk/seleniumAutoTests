package admin;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ApplicationAdministrationTest extends BaseTest {
    WebDriverWait wait;
    @BeforeClass
    public void setUp() {
        WebElement enterAsUserButton = driver.findElement(By.xpath("//div//button[1]"));
        enterAsUserButton.click();

        // Ждем появления формы регистрации
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@id,'TextInputField')]")));
    }
    @Test
    public void testLegitCreds(){
        registrationDetailsPage.setSurnameField("Иванов");
        registrationDetailsPage.setNameField("Иван");
        registrationDetailsPage.setMiddlenameField("Иванович");
        registrationDetailsPage.setPhoneField("123456789");
        registrationDetailsPage.setPassportField("12345678");
        registrationDetailsPage.setBirthdayField("22011994");
        Assert.assertTrue(registrationDetailsPage.nextButtonIsDisabled());
        registrationDetailsPage.clickNextButton();
    }
}
