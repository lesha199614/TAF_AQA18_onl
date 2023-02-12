package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By titleLocator = By.className("title");
    private final By checkoutButtonLocator = By.className("checkout");
    private final By firstNameLocator = By.className("first-name");
    private final By lastNameLocator = By.className("last-name");
    private final By postalCodeLocator = By.className("postal-code");
    private final By finishButtonLocator = By.className("finish");
    private final By continueButtonLocator = By.className("continue");
    private final By BackToCatalogButtonLocator = By.className("back-to-products");
    private final By completeOrderLocator = By.className("complete-header");

    public WebElement getTitle() {
        return driver.findElement(titleLocator);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButtonLocator);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstNameLocator);
    }

    public WebElement getLastName() {
        return driver.findElement(lastNameLocator);
    }

    public WebElement getPostalCode() {
        return driver.findElement(postalCodeLocator);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }

    public WebElement getBackToCatalogButton() {
        return driver.findElement(BackToCatalogButtonLocator);
    }

    public WebElement getCompleteOrder() {
        return driver.findElement(completeOrderLocator);
    }

    public CartPage cartCheckOut() {
        getCheckoutButton().click();
        return this;
    }

    public CartPage setShippingValues(String name, String surname, String zip) {
        getFirstName().sendKeys(name);
        getLastName().sendKeys(surname);
        getPostalCode().sendKeys(zip);
        return this;
    }

    public CartPage clickContinue() {
        getContinueButton().click();
        return this;
    }

    public CartPage clickFinish() {
        getFinishButton().click();
        return this;
    }

    public CatalogPage backToCatalog() {
        getBackToCatalogButton().click();
        return new CatalogPage(driver);
    }
}
