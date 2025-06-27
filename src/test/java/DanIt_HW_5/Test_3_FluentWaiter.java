package DanIt_HW_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;

public class Test_3_FluentWaiter {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bi.ua/");
        String nameProduct = "Лялька";
        int first = 0;
        FluentWait<WebDriver> fluentWaiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchFieldError.class);

        fluentWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='search']")));
        WebElement searchName = driver.findElement(By.cssSelector("[name='search']"));
        searchName.sendKeys(nameProduct);

        fluentWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='btn40 bgBaseP b']")));
        WebElement searchButton = driver.findElement(By.cssSelector("[class='btn40 bgBaseP b']"));
        searchButton.click();

        fluentWaiter.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("[class='col-8 col-lg-9']"), 24));
        List<WebElement> catalog = driver.findElements(By.cssSelector("[class='col-8 col-lg-9']"));
        WebElement firstDoll = catalog.get(first);
        String firstNameDoll = firstDoll.findElement(By.cssSelector("[class='itemDes']")).getText();
        System.out.println(firstNameDoll);

        driver.quit();
    }
}
