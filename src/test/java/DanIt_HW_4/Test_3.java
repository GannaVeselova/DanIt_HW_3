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
            driver.get("https://www.foxtrot.com.ua/");
            driver.manage().window().maximize();
            String keyWordToFind = "Уцінені товари";
            WebElement buttonSale = driver.findElement(By.cssSelector("[class='header__sub-link jslink header__sale-content']"));
            buttonSale.click();
            sleep(3000);
            WebElement promotionElement = driver.findElement(By.cssSelector("[class='page__title']"));
            String namePromotion = promotionElement.getText();
            Assert.assertTrue("Title doesn't contains;" + keyWordToFind + "word", namePromotion.contains(keyWordToFind));

        } catch (AssertionError ex) {
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
