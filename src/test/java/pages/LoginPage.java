package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Блок описания локаторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");

    // Блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return driver.findElement(emailInputLocator);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputLocator);
    }

    public WebElement getLogInButtonInput() {
        return driver.findElement(logInButtonLocator);
    }

}
