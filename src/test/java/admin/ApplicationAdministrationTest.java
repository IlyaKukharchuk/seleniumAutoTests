package admin;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.ApplicationAdministrationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationAdministrationTest extends AdminTest {
    private ApplicationAdministrationPage applicationAdministrationPage;

    @BeforeClass
    public void loginAsAdmin() {
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
        if (!skipInitialAdminButtonClick) {
            homePage.clickEnterAsAdminButton();
        }
        skipInitialAdminButtonClick = false;
    }

    @AfterMethod
    public void returnToHomePage() {
        if (applicationAdministrationPage != null) {
            applicationAdministrationPage.clickCloseButton();
        }
    }

    @Test
    public void testPresenceOfApplicationTable() {
        Assert.assertTrue(applicationAdministrationPage.isApplicationsTableDisplayed(),
                "Таблица заявок должна быть видимой");
    }

    @Test
    public void testLikeButton(){
        applicationAdministrationPage.clickLikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Одобрена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Одобрена");
    }

    @Test
    public void testDislikeButton() {
        applicationAdministrationPage.clickDislikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Отклонена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Отклонена");
    }
}