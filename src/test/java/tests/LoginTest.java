package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButtonInput().click();

        Assert.assertTrue(new ProductsPage(driver).isPageOpened());
    }



    @Test
    public void loginSuccessfulTest() {

        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(),ReadProperties.password())
                .isPageOpened());
    }
    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(userStep.loginIncorrect(ReadProperties.username(),"sdfadaa")
                .getErrorTextElement().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test
    public void end2end(){
        userStep.loginSuccessful(ReadProperties.username(),ReadProperties.password());

        userStep.openFirstItem();
        //Assert.assertTrue(userStep.openFirstItem().isPageOpened());
    }
}
