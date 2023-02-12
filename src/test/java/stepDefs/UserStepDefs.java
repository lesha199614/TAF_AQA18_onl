package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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


    @When("complete order with first name {string}, last name {string}, zip code {string}")
    public void completeOrder(String firstName, String lastName, String zip) {
        cartPage.getCheckoutButton().click();
        cartPage.getFirstName().sendKeys(firstName);
        cartPage.getLastName().sendKeys(lastName);
        cartPage.getPostalCode().sendKeys(zip);
        cartPage.getContinueButton().click();
        cartPage.getFinishButton().click();
    }

    @Then("Text {string} is shown")
    public void completeOrderText (String completeText) {
        Assert.assertEquals(cartPage.getCompleteOrder().getText(),completeText);
    }

}
