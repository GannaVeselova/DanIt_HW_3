package DanIt_HW_7;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class Test_3_FluentWaiter {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bi.ua/");
        String keyWordToFind = "Лялька";
        int firstNumberCatalog = 0;
        FluentWait<WebDriver> fluentWaiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchFieldError.class);

        fluentWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='search']")));
        WebElement searchName = driver.findElement(By.cssSelector("[name='search']"));
        searchName.sendKeys(keyWordToFind);

        fluentWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='btn40 bgBaseP b']")));
        WebElement searchButton = driver.findElement(By.cssSelector("[class='btn40 bgBaseP b']"));
        searchButton.click();

        fluentWaiter.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//a[@class='goodsItemLink good']"), 24));
        List<WebElement> catalog = driver.findElements(xpath("//a[@class='goodsItemLink good']"));

        WebElement firstDoll = catalog.get(firstNumberCatalog);
        firstDoll.click();
        WebElement firstNameDoll = driver.findElement(By.cssSelector("h1[class='h1']"));
        Assert.assertTrue(firstNameDoll.isDisplayed());

        driver.quit();
    }
}
