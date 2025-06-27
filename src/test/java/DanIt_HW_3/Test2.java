package DanIt_HW_3;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");

        WebElement hamburgerButton = driver.findElement(By.cssSelector("[data-testid='menu_button']"));
        hamburgerButton.click();
        sleep(5000);
        WebElement sideMenu = driver.findElement(By.cssSelector("[class='burger']"));
        sleep(5000);
        Assert.assertTrue(sideMenu.isDisplayed());
        driver.quit();
    }
}
