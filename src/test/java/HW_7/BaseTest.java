package HW_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    private static final String BASE_URL = "https://hotline.ua/";
    @BeforeMethod
    public void driverInit() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
