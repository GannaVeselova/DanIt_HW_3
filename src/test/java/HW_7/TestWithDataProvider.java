package HW_7;

import HW_7.Data_provider.SearchTestData;
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

import static java.lang.Thread.sleep;


@Listeners(Listener.class)
public class TestWithDataProvider extends BaseTest {

    @Test(dataProvider = "getSearchData", dataProviderClass = SearchTestData.class)
    public void verifyTitleWithTitleProductPage(String wordToSearch, String expectedTitle) throws InterruptedException {
        FluentWait<WebDriver> fluentWaiter = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchFieldError.class);
        WebElement searchField = getDriver().findElement(By.cssSelector("input[type='text']"));
        searchField.sendKeys(wordToSearch);
        sleep(3000);
        WebElement searchFieldButton = getDriver().findElement(By.cssSelector("button.search__btn "));
        searchFieldButton.click();
        fluentWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='catalog-title']")));
        WebElement searchTitleProductPage = getDriver().findElement(By.cssSelector("[class='catalog-title']"));
        String getSearchTitleProductPage = searchTitleProductPage.getText();
        Assert.assertEquals(expectedTitle, getSearchTitleProductPage);

    }

    @Test
    public void checkingLoginPageByUrl() {
        String checkUrl = "https://hotline.ua/ua/login/";
        FluentWait<WebDriver> fluentWaiter = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchFieldError.class);
        WebElement loginButton = getDriver().findElement(By.cssSelector("[class='user-button__image flex middle-xs center-xs']"));
        loginButton.click();
        fluentWaiter.until(ExpectedConditions.urlContains("/login/"));
        String getUrlFromLoginPage = getDriver().getCurrentUrl();
        Assert.assertEquals(getUrlFromLoginPage, checkUrl);

    }

}
