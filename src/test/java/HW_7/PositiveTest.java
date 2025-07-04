package HW_7;

import HW_7.Listeners.Listener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;



@Listeners(Listener.class)
public class PositiveTest extends BaseTest {

    @Test
    public void findElementCatalogueHomepageAndCompareWithTitleProductPage() {
        int avtoElement = 6;
        FluentWait<WebDriver> fluentWaiter = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchFieldError.class);
        List<WebElement> catalogueElements = getDriver().findElements(By.cssSelector("[class='categories-section__link link--black']"));
        WebElement findElementCatalogue = catalogueElements.get(avtoElement);
        findElementCatalogue.click();
        fluentWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='title-page flex middle-xs section-title']")));
        WebElement searchTitleProductPage = getDriver().findElement(By.cssSelector("h1[class='title-page flex middle-xs section-title']"));
        Assert.assertTrue(searchTitleProductPage.isDisplayed());
    }

    @Test
    public void verifyBonusProgram(){
        WebElement bonusProgramButton = getDriver().findElement(By.cssSelector("[class='link--new']"));
        bonusProgramButton.click();
        WebElement pageBonusProgram = getDriver().findElement(By.cssSelector("[class='loyalty-header__title text-center text-bold m_b-5']"));
        Assert.assertTrue(pageBonusProgram.isDisplayed());
    }


}
