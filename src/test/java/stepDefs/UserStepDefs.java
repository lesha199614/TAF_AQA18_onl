package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStepDefs extends BaseCucumberTest {

    private BaseCucumberTest baseCucumberTest;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public UserStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
        this.loginPage = new LoginPage(driver);
    }
    @Given("login successful")
    public void loginSuccessful() {
        loginPage.getUsernameInput().sendKeys(ReadProperties.username());
        loginPage.getPassword().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
    }

    @Given("open SauceDemo")
    public void openSauceDemo() {
        driver.get(ReadProperties.getUrl());
    }
}
