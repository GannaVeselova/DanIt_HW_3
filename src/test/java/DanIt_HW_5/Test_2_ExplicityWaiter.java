package DanIt_HW_5;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Test_2_ExplicityWaiter {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bi.ua/");
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Вік']")));
        WebElement webElementAgeButton = driver.findElement(By.xpath("//span[text()='Вік']"));
        webElementAgeButton.click();

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='iSelOpWr ovUlWr unAc ac']")));
        List<WebElement> webElementsAge = driver.findElements(By.cssSelector("ul[class='iSelOpWr ovUlWr unAc ac']"));
        Assert.assertTrue(webElementsAge.get(0).isDisplayed());

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='2-3 роки']")));
        WebElement webElementAgeSecondThirdButton = driver.findElement(By.xpath("//li[text()='2-3 роки']"));
        webElementAgeSecondThirdButton.click();

        driver.quit();
    }
}
