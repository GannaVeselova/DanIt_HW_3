package DanIt_HW_3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class Test_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();

        WebElement catalogButten = driver.findElement(By.cssSelector("[data-testid='fat_menu_btn']"));
        catalogButten.click();
        sleep(5000);

        driver.quit();
    }
}
