package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CatalogPage;
import pages.ItemPage;
import pages.LoginPage;

public class UserStepDefs extends BaseCucumberTest {

    private BaseCucumberTest baseCucumberTest;
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private ItemPage itemPage;
    private CartPage cartPage;

    public UserStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
        this.loginPage = new LoginPage(driver);
        this.catalogPage = new CatalogPage(driver);
        this.itemPage = new ItemPage(driver);
        this.cartPage = new CartPage(driver);
    }
    @Given("login successful")
    public CatalogPage loginSuccessful() {
        loginPage.getUsernameInput().sendKeys(ReadProperties.username());
        loginPage.getPassword().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
        return new CatalogPage(driver);
    }

    @Given("open SauceDemo")
    public void openSauceDemo() {
        driver.get(ReadProperties.getUrl());
    }

    @When("add item to Cart")
    public void addItemToCart() {
        itemPage.getAddToCart().click();
    }
}
