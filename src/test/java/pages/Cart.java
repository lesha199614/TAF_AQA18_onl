package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends BasePage {
    public Cart(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "title")
    public WebElement title;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "back-to-products")
    public WebElement backToCatalogButton;

    @FindBy(id = "complete-header")
    public WebElement completeOrder;

    public Cart cartCheckOut() {
        checkoutButton.click();
        return this;
    }

    public Cart setShippingValues(String name, String surname, String zip) {
        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        postalCode.sendKeys(zip);
        return this;
    }

    public Cart clickContinue() {
        continueButton.click();
        return this;
    }

    public Cart clickFinish() {
        finishButton.click();
        return this;
    }

    public CatalogPage backToCatalog() {
        backToCatalogButton.click();
        return new CatalogPage(driver);
    }
}
