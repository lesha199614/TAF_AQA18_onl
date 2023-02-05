package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final By emailInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");
    private final By errorTextLocator = By.className("error-button");

    public SelenideElement getEmailInput() {
        return $(emailInputLocator);
    }

    public SelenideElement getPassword() {
        return $(passwordInputLocator);
    }

    public SelenideElement getLogInButton() {
        return $(logInButtonLocator);
    }

    public SelenideElement getErrorTextElement() {
        return $(errorTextLocator);
    }


}
