package by.louegroove.seleniumfreecodecamp.pages.adminPage.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TableRowElement {
    @FindBy(how = How.CSS, css = "td:nth-child(1)")
    private WebElement numberCell;

    @FindBy(css = "td:nth-child(2)")
    private WebElement applicantCell;

    @FindBy(css = "td:nth-child(3)")
    private WebElement typeCell;

    @FindBy(css = "td:nth-child(4)")
    private WebElement timeCell;

    @FindBy(css = "td:nth-child(5)")
    private WebElement statusCell;

    @FindBy(css = "td:nth-child(6) button:first-child")
    private WebElement approveButton;

    @FindBy(css = "td:nth-child(6) button:last-child")
    private WebElement rejectButton;

    // Геттеры
    public WebElement getNumberCell() {
        return numberCell;
    }

    public WebElement getApplicantCell() {
        return applicantCell;
    }

    public WebElement getTypeCell() {
        return typeCell;
    }

    public WebElement getTimeCell() {
        return timeCell;
    }

    public WebElement getStatusCell() {
        return statusCell;
    }

    public WebElement getApproveButton() {
        return approveButton;
    }

    public WebElement getRejectButton() {
        return rejectButton;
    }
}