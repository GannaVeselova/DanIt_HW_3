package DanIt_HW_4;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;


public class Test_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().window().maximize();
        String keyWordToFind = "холодильники";
        WebElement searchField = driver.findElement(By.cssSelector("input[class='header-search__field evinent-search-input']"));
        searchField.sendKeys(keyWordToFind);

        WebElement searchButton = driver.findElement(By.cssSelector("input[class='header-search__button evinent-search-button']"));
        searchButton.click();
        sleep(5000);

        WebElement findPageProduct = driver.findElement(By.cssSelector("[class='page__title']"));
        sleep(7000);
        Assert.assertTrue(findPageProduct.isDisplayed());
        driver.quit();
    }

}

