package base;

import by.louegroove.seleniumfreecodecamp.pages.BasePage;
import by.louegroove.seleniumfreecodecamp.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected static WebDriverWait wait;
    protected BasePage basePage;
    protected HomePage homePage;
    protected static boolean skipInitialAdminButtonClick = false;

    private final String VALID_USERNAME = "user";
    private final String VALID_PASSWORD = "senlatest";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Авторизация через URL
        driver.get("https://" + VALID_USERNAME + ":" + VALID_PASSWORD + "@regoffice.senla.eu/");
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
    }
    @AfterClass
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
