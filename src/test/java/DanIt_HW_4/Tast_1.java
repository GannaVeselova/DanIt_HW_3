package DanIt_HW_4;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Tast_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        String keyWordToFind = "Кошик";
        WebElement cartButton = driver.findElement(By.cssSelector("[class='header-cart__button']"));
        cartButton.click();
        sleep(3000);
        WebElement textCart = driver.findElement(By.cssSelector("[class='modal-layout']"));
        String text = textCart.getText();
        sleep(3000);
        Assert.assertTrue(keyWordToFind, text.contains(keyWordToFind));
        WebElement cartWindowClose = driver.findElement(By.cssSelector("[class='btn button button--icon']"));
        sleep(3000);
        cartWindowClose.click();
        sleep(3000);
        driver.quit();
    }
}
