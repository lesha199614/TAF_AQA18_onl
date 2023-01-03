package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final By headerTitleHeaderLocator = By.className("title");
    private final By firstNameLocator = By.className("first-name");
    private final By lastNameLocator = By.className("last-name");
    private final By zipLocator = By.className("postal-code");
    private final By continueButton = By.id("continue");

    String pagePath = "checkout-step-one.html";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleHeaderLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstNameLocator);
    }

    public WebElement getLastName() {
        return driver.findElement(lastNameLocator);
    }

    public WebElement getZip() {
        return driver.findElement(zipLocator);
    }

    public WebElement continueButton() {
        return driver.findElement(continueButton);
    }


}
