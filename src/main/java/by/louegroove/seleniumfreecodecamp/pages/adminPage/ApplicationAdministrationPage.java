package by.louegroove.seleniumfreecodecamp.pages.adminPage;

import by.louegroove.seleniumfreecodecamp.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplicationAdministrationPage extends BasePage {
    private By refreshButton = By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[2]");
    private By closeButton = By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[1]");
    private By likeButton = By.xpath("(//tr[1]//td[contains(@class, 'MuiTableCell-root')])[6]//button[1]");
    private By dislikeButton = By.xpath("(//tr[1]//td[contains(@class, 'MuiTableCell-root')])[6]//button[2]");
    private By applicationStatus = By.xpath("(  //tr[1]//td[contains(@class, 'MuiTableCell-root')])[5]");
    private By applicationsTable = By.xpath("//table[contains(@class, 'MuiTable-root')]");

    public boolean isApplicationsTableDisplayed() {
        return find(applicationsTable).isDisplayed();
    }

    public String getStatus() {
        return find(applicationStatus).getText();
    }

    public WebElement getApplicationStatus() {
        return find(applicationStatus);
    }

    public void clickDislikeButton() {
        click(dislikeButton);
    }

    public void clickLikeButton() {
        click(likeButton);
    }

    public By getLikeButton() {
        return likeButton;
    }

    public By getDislikeButton() {
        return dislikeButton;
    }

    public void clickCloseButton() {
        click(closeButton);
    }

    public void clickRefreshButton() {
        click(refreshButton);
    }

    public WebElement getApplicationsTable() {
        return find(applicationsTable);
    }
}