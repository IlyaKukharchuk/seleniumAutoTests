package admin;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.ApplicationAdministrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationAdministrationTest extends AdminTest {

    private static final Logger logger = LogManager.getLogger(ApplicationAdministrationTest.class);

    private ApplicationAdministrationPage applicationAdministrationPage;

    @BeforeClass
    public void loginAsAdmin() {
        logger.info("Logging in as admin...");
        applicationAdministrationPage = registrationDetailsPage.insertRegDetails(
                "Иванов",
                "Иван",
                "Иванович",
                "123456789",
                "12345678",
                "22111998"
        );
        logger.info("Successfully logged in as admin.");
    }

    @BeforeMethod
    public void enterToAdminTablePage() {
        logger.info("Entering admin table page...");
        if (!skipInitialAdminButtonClick) {
            homePage.clickEnterAsAdminButton();
        }
        skipInitialAdminButtonClick = false;
    }

    @AfterMethod
    public void returnToHomePage() {
        logger.info("Returning to home page...");
        if (applicationAdministrationPage != null) {
            applicationAdministrationPage.clickCloseButton();
        }
    }

    @Test
    public void testPresenceOfApplicationTable() {
        logger.info("Testing presence of application table...");
        Assert.assertTrue(applicationAdministrationPage.isApplicationsTableDisplayed(),
                "Таблица заявок должна быть видимой");
        logger.info("Application table is visible.");
    }

    @Test
    public void testLikeButton() {
        logger.info("Testing like button...");
        applicationAdministrationPage.clickLikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Одобрена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Одобрена");
        logger.info("Like button test passed.");
    }

    @Test
    public void testDislikeButton() {
        logger.info("Testing dislike button...");
        applicationAdministrationPage.clickDislikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Отклонена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Отклонена");
        logger.info("Dislike button test passed.");
    }
}
