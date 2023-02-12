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
    private final By checkoutButtonLocator = By.id("checkout");
    private final By firstNameLocator = By.id("first-name");
    private final By lastNameLocator = By.id("last-name");
    private final By postalCodeLocator = By.id("postal-code");
    private final By finishButtonLocator = By.id("finish");
    private final By continueButtonLocator = By.id("continue");
    private final By BackToCatalogButtonLocator = By.id("back-to-products");
    private final By completeOrderLocator = By.className("complete-header");

    public WebElement getTitle() {
        return waitsService.waitForExists(titleLocator);
    }

    public WebElement getCheckoutButton() {
        return waitsService.waitForExists(checkoutButtonLocator);
    }

    public WebElement getFirstName() {
        return waitsService.waitForExists(firstNameLocator);
    }

    public WebElement getLastName() {
        return waitsService.waitForExists(lastNameLocator);
    }

    public WebElement getPostalCode() {
        return waitsService.waitForExists(postalCodeLocator);
    }

    public WebElement getFinishButton() {
        return waitsService.waitForExists(finishButtonLocator);
    }

    public WebElement getContinueButton() {
        return waitsService.waitForExists(continueButtonLocator);
    }

    public WebElement getBackToCatalogButton() {
        return waitsService.waitForExists(BackToCatalogButtonLocator);
    }

    public WebElement getCompleteOrder() {
        return waitsService.waitForExists(completeOrderLocator);
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
