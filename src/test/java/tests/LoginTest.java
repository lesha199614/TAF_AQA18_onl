package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import pages.DashBoardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    //@Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButtonInput().click();

        Assert.assertTrue(new DashBoardPage(driver).isPageOpened());
    }
    //@Test
    public void loginSuccessfulTest() {

        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(),ReadProperties.password())
                .isPageOpened());
    }
    //@Test
    public void loginIncorrectTest() {
        Assert.assertEquals(userStep.loginIncorrect(ReadProperties.username(),"sdfadaa")
                .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}
