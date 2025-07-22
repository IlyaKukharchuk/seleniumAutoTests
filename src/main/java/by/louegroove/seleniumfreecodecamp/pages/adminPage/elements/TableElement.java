package by.louegroove.seleniumfreecodecamp.pages.adminPage.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TableElement {
    private final WebDriver driver;

    @FindBy(css = "table.MuiTable-root")
    private WebElement table;

    @FindBy(css = "table.MuiTable-root thead th")
    private List<WebElement> headers;

    @FindBy(css = "table.MuiTable-root tbody tr")
    private List<TableRowElement> rows;

    public TableElement(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getHeaders() {
        return headers;
    }

    public List<TableRowElement> getRows() {
        return rows;
    }

    public TableRowElement getRowByNumber(String number) {
        return rows.stream()
                .filter(row -> number.equals(row.getNumberCell().getText()))
                .findFirst()
                .orElseThrow();
    }
}