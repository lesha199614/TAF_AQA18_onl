package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов
    private final By username = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // Блок атомарных методов
    public UIElement getUsernameInput() { return new UIElement(driver, username);}
    public UIElement getPassword() { return new UIElement(driver, passwordInputLocator);}
    public Button getLogInButton() { return new Button(driver, logInButtonLocator);}
}
