package admin;

import base.BaseTest;
import by.louegroove.seleniumfreecodecamp.pages.adminPage.RegistrationDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminTest extends BaseTest {
    protected RegistrationDetailsPage registrationDetailsPage;

    @BeforeClass
    public void startUp() {
        registrationDetailsPage = homePage.clickEnterAsAdminButton();
//         Ждем появления форм
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@id,'TextInputField')]")));
    }

}