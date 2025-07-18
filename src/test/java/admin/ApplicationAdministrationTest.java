package admin;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.ApplicationAdministrationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ApplicationAdministrationTest extends AdminTest{
    @AfterMethod
    public void returnToHomePage(ApplicationAdministrationPage applicationAdministrationPage){
        applicationAdministrationPage.clickCloseButton();
    }
    @Test
    public void testPresenceOfApplicationTable() {
        ApplicationAdministrationPage applicationAdministrationPage = registrationDetailsPage.insertRegDetails(
                "Иванов",
                "Иван",
                "Иванович",
                "123456789",
                "12345678",
                "22111998"
        );
        wait.until(ExpectedConditions.visibilityOf(applicationAdministrationPage.getApplicationsTable()));
        Assert.assertTrue(applicationAdministrationPage.isApplicationsTableDisplayed(),
                "Таблица заявок должна быть видимой");
    }
    @Test
    public void testLikeButton() {
        ApplicationAdministrationPage applicationAdministrationPage = registrationDetailsPage.insertRegDetails(
                "Иванов",
                "Иван",
                "Иванович",
                "123456789",
                "12345678",
                "22111998"
        );
        wait.until(ExpectedConditions.elementToBeClickable(applicationAdministrationPage.getLikeButton()));
        applicationAdministrationPage.clickLikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(
                applicationAdministrationPage.getApplicationStatus(), "Одобрена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Одобрена");
    }
    @Test
    public void testDislikeButton(){
        ApplicationAdministrationPage applicationAdministrationPage = registrationDetailsPage.insertRegDetails(
                "Иванов",
                "Иван",
                "Иванович",
                "123456789",
                "12345678",
                "22111998"
        );
        wait.until(ExpectedConditions.elementToBeClickable(applicationAdministrationPage.getDislikeButton()));
        applicationAdministrationPage.clickDislikeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(applicationAdministrationPage.getApplicationStatus(), "Отклонена"));
        Assert.assertEquals(applicationAdministrationPage.getStatus(), "Отклонена");
    }
}
