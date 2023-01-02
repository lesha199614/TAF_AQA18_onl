package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButtonInput().click();

        Assert.assertTrue(driver.findElement(By.id("ui-dialog-title-messageDialog")).isDisplayed());
        Assert.assertTrue(new DashBoardPage(driver).isPageOpened());
    }
}
