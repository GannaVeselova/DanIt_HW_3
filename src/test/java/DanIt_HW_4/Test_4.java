package DanIt_HW_4;


import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static java.lang.Thread.sleep;

public class Test_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotline.ua/");
        driver.manage().window().maximize();
        sleep(3000);
        WebElement turnOffLight = driver.findElement(By.xpath("//span[@class='toggle__button toggle__button--left']"));
        turnOffLight.click();
        sleep(3000);
        WebElement turnOffNight = driver.findElement(By.xpath("//span[@class='toggle__button toggle__button--right']"));

        Assert.assertTrue(turnOffNight.isDisplayed());
        sleep(3000);
        driver.quit();
    }
}
