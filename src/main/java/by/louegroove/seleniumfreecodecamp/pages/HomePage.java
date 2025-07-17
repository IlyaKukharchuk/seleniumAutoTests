package by.louegroove.seleniumfreecodecamp.pages;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.ApplicationAdministrationPage;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private By enterAsAdminButton = By.xpath("//div//button[2]");

    public ApplicationAdministrationPage clickEnterAsUserButton() {
        click(enterAsAdminButton);
        return new ApplicationAdministrationPage();
    }
}
