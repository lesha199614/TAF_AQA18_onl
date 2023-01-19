package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLogInButtonInput().click();
    }

    @Step
    public DashBoardPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new DashBoardPage(driver);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

}
