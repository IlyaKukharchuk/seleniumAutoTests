package admin;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.ApplicationAdministrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ApplicationAdministrationTest extends AdminTest {
    WebDriverWait wait;
    private ApplicationAdministrationPage applicationAdministrationPage;
    private int count = 0;
    @BeforeClass
    public void loginAsAdmin() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        applicationAdministrationPage = registrationDetailsPage.insertRegDetails(
                "Иванов",
                "Иван",
                "Иванович",
                "123456789",
                "12345678",
                "22111998"
        );
    }
    @BeforeMethod
    public void enterToAdminTablePage() {
        count++;
        if (count > 1){ // Т.к. самый первый клик происходит при инициализации AdminTest (в @BeforeClass)
            System.out.println("clickEnterAsAdminButton");
            homePage.clickEnterAsAdminButton();
        }
    }

    @AfterMethod
    public void returnToHomePage() {
        if (applicationAdministrationPage != null) {
            System.out.println("clickCloseButton");
            applicationAdministrationPage.clickCloseButton();
        }
    }

    @Test
    public void testPresenceOfApplicationTable() throws InterruptedException {
        System.out.println("testPresenceOfApplicationTable");

        wait.until(ExpectedConditions.visibilityOf(applicationAdministrationPage.getApplicationsTable()));
        Assert.assertTrue(applicationAdministrationPage.isApplicationsTableDisplayed(),
                "Таблица заявок должна быть видимой");
    }

    @Test
    public void testLikeButton() throws InterruptedException {
        System.out.println("testLikeButton");
        wait.until(ExpectedConditions.elementToBeClickable(applicationAdministrationPage.getLikeButton()));
        applicationAdministrationPage.clickLikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Одобрена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Одобрена");
    }

    @Test
    public void testDislikeButton() throws InterruptedException {
        System.out.println("testDislikeButton");
        wait.until(ExpectedConditions.elementToBeClickable(applicationAdministrationPage.getDislikeButton()));
        applicationAdministrationPage.clickDislikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Отклонена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Отклонена");

    }
}