package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final By headerTitleHeaderLocator = By.className("title");
    private final By firstNameLocator = By.id("first-name");
    private final By lastNameLocator = By.id("last-name");
    private final By zipLocator = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeOrderLocator = By.className("complete-header");

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

    public WebElement getContinue() {
        return driver.findElement(continueButton);
    }

    public WebElement getFinish() {
        return driver.findElement(finishButton);
    }

    public WebElement getCompleteOrder() {
        return driver.findElement(completeOrderLocator);
    }


}
