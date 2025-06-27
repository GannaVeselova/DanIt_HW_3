package DanIt_HW_4;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Test_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rozetka.com.ua/");
            driver.manage().window().maximize();
            String findElementByWord = "Акції";
            WebElement findElement = driver.findElement(By.cssSelector("[class='all-actions-link sub-lg']"));
            findElement.click();
            sleep(3000);
            WebElement promotionElement = driver.findElement(By.cssSelector("[class='catalog-heading mt-4']"));
            String namePromotion = promotionElement.getText();
            Assert.assertTrue("Title doesn't contains;" + findElementByWord + "word", namePromotion.contains(findElementByWord));
            Assert.assertTrue(namePromotion.contains(findElementByWord));
        } catch (AssertionError ex) {
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
