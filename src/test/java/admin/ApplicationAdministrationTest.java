package admin;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.ApplicationAdministrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationAdministrationTest extends AdminTest {
    private ApplicationAdministrationPage applicationAdministrationPage;
    @BeforeClass
    public void loginAsAdmin() throws InterruptedException {
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
        homePage.clickEnterAsAdminButton();
    }

    @AfterMethod
    public void returnToHomePage() {
        if (applicationAdministrationPage != null) {
            applicationAdministrationPage.clickCloseButton();
            applicationAdministrationPage = null; // Очищаем ссылку
        }
    }

    @Test
    public void testPresenceOfApplicationTable() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(applicationAdministrationPage.getApplicationsTable()));
        Assert.assertTrue(applicationAdministrationPage.isApplicationsTableDisplayed(),
                "Таблица заявок должна быть видимой");
    }

    @Test
    public void testLikeButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(applicationAdministrationPage.getLikeButton()));
        applicationAdministrationPage.clickLikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Одобрена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Одобрена");
    }

    @Test
    public void testDislikeButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(applicationAdministrationPage.getDislikeButton()));
        applicationAdministrationPage.clickDislikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Отклонена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Отклонена");

    }
}