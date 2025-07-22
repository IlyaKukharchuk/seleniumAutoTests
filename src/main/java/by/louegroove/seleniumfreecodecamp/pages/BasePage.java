package by.louegroove.seleniumfreecodecamp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        logger.info("Setting WebDriver...");
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        logger.debug("Finding element with locator: {}", locator);
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        logger.info("Setting text '{}' for element with locator: {}", text, locator);
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator) {
        logger.info("Clicking element with locator: {}", locator);
        find(locator).click();
    }
}
