package StepDefs;

import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class FirstStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("открыт браузер")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("страница логина открыта")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
        loginPage= new LoginPage(driver);
    }

    @Then("страница логина отображается")
    public void isPageOpen() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

}
