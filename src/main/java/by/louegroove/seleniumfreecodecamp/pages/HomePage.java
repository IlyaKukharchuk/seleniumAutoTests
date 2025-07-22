package by.louegroove.seleniumfreecodecamp.pages;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.ApplicationAdministrationPage;
import by.louegroove.seleniumfreecodecamp.pages.adminPage.RegistrationDetailsPage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By enterAsAdminButton = By.xpath("//div//button[2]");
    private By enterAsUserButton = By.xpath("//div//button[1]");

    public RegistrationDetailsPage clickEnterAsAdminButton() {
        click(enterAsAdminButton);
        return new RegistrationDetailsPage();
    }

    public void clickEnterAsUserButton() {
        click(enterAsUserButton);
    }
}
