package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов
    private final By username = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public UIElement getUsernameInput() {
        return new UIElement(driver, username);
    }

    public WebElement getPassword() {
        return driver.findElements(username);
    }

    public Button getLogInButton() {
        return new Button(driver, logInButtonLocator);
    }
}
