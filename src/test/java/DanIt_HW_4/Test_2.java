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
        try {
            driver.get("https://ext.com.ua/");
            driver.manage().window().maximize();
            String KeyWordToFind = "Олива";
            WebElement searchField = driver.findElement(By.cssSelector("[class='search__input']"));
            searchField.sendKeys(KeyWordToFind);

            WebElement searchButton = driver.findElement(By.cssSelector("[class='search__button']"));
            searchButton.click();
            sleep(5000);

            WebElement oilElement = driver.findElement(By.cssSelector("[id='j-catalog-header']"));
            sleep(7000);
            String oilElementName = oilElement.getText();
            Assert.assertTrue("Title doesn't contains;" + KeyWordToFind,
                    oilElementName.contains(KeyWordToFind));

        } catch (AssertionError ex) {
            ex.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
