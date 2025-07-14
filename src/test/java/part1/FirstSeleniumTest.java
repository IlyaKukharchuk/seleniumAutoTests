package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("driver.quit();");
        driver.quit();
    }

    @Test
    public void testLoginIntoApp() throws InterruptedException {
        System.out.println("start test");
        Thread.sleep(3000);
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameInput.sendKeys("Admin");
        Thread.sleep(500);
        passwordInput.sendKeys("admin123");
        Thread.sleep(500);
        submitButton.click();
    }
}
