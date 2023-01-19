package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import steps.UserStep;

public class LoginTest extends BaseTest {

    //@Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButtonInput().click();

        Assert.assertTrue(new DashBoardPage(driver).isPageOpened());
    }

    @Test(description = "Description")
    @Issue("AQA-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "mylink", url= "https://onliner.by")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccessfulTest() {
        userStep = new UserStep(driver);
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened());
    }

    //@Test
    public void loginIncorrectTest() {
        Assert.assertEquals(userStep.loginIncorrect(ReadProperties.username(), "sdfadaa")
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}
