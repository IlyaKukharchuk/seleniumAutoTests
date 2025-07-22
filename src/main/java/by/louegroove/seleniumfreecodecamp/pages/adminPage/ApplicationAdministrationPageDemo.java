package by.louegroove.seleniumfreecodecamp.pages.adminPage;

import by.louegroove.seleniumfreecodecamp.pages.adminPage.elements.TableElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Этот класс нигде не используется.
 * Это класс-пример: как бы выглядел {@link ApplicationAdministrationPage},
 * если бы мы описывали его через паттерн Page Element
 */

public class ApplicationAdministrationPageDemo {
    private final WebDriver driver;
    private final TableElement table;

    public ApplicationAdministrationPageDemo(WebDriver driver) {
        this.driver = driver;
        this.table = new TableElement(driver);
        PageFactory.initElements(driver, this);
    }

    public TableElement getTable() {
        return table;
    }

    public void approveApplication(String number) {
        table.getRowByNumber(number).getApproveButton().click();
    }

    public String getApplicationStatus(String number) {
        return table.getRowByNumber(number).getStatusCell().getText();
    }
}