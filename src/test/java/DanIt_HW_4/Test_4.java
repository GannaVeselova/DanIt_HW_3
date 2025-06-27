package DanIt_HW_4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='autosuggest-autosuggest__results']"));
        int size = elements.size();

        System.out.println(size);
        sleep(3000);
        driver.quit();
    }
}
