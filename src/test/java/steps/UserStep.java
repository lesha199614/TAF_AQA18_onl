package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.FirstProductPage;
import pages.LoginPage;
import pages.ProductsPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String username, String psw) {
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLogInButtonInput().click();
    }

    public ProductsPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new ProductsPage(driver);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    public FirstProductPage openFirstItem(){
        productsPage.getFirstItem().click();

        return new FirstProductPage(driver);
    }

}
