package by.louegroove.seleniumfreecodecamp.pages.adminPage;

import by.louegroove.seleniumfreecodecamp.pages.BasePage;
import org.openqa.selenium.By;

public class ApplicationAdministrationPage extends BasePage {
    private By refreshButton = By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[2]");
    private By closeButton = By.xpath("//div[contains(@class, 'MuiDialogActions-root')]//button[1]");
    private By likeButton = By.xpath("(//tr[1]//td[contains(@class, 'MuiTableCell-root')])[6]//button[1]");
    private By dislikeButton = By.xpath("(//tr[1]//td[contains(@class, 'MuiTableCell-root')])[6]//button[2]");
    private By applicationsTable = By.xpath("//table[contains(@class, 'MuiTable-root')]");

    public boolean isApplicationsTableDisplayed(){
        return find(applicationsTable).isDisplayed();
    }
}