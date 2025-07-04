package HW_7;

import HW_7.Listeners.Listener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class NegativeTest extends BaseTest {

    @Test
    public void changeCityOnHomePage() {
        String newCity = "London";
        WebElement localCityButton = getDriver().findElement(By.cssSelector("[class='location__city']"));
        localCityButton.click();
        WebElement windowWithSearchField = getDriver().findElement(By.xpath("//input [@class='field ']"));
        windowWithSearchField.sendKeys(newCity);
        windowWithSearchField.click();
        WebElement messageIsBe = getDriver().findElement(By.cssSelector(" [class='search__not-found']"));
        Assert.assertFalse(messageIsBe.isDisplayed());
    }
}
