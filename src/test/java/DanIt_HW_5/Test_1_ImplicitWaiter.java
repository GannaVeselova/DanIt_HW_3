package DanIt_HW_5;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class Test_1_ImplicitWaiter {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bi.ua/");
        String sendElement = "LEGO";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement searchfield = driver.findElement(By.cssSelector("input[class='iIco']"));
        searchfield.sendKeys(sendElement);

        WebElement searchButton = driver.findElement(By.cssSelector("input[class='btn40 bgBaseP b']"));
        searchButton.click();

        WebElement titleElement = driver.findElement(By.cssSelector("span[class='ac']"));

        Assert.assertTrue(titleElement.isDisplayed());
        driver.quit();
    }
}
