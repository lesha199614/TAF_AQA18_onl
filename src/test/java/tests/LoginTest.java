package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput.sendKeys(ReadProperties.username());
        loginPage.passwordInput.sendKeys(ReadProperties.password());
        loginPage.logInButton.click();

        //Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void loginSuccessfulTest() {
//        Assert.assertTrue(
//                userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
//                .isPageOpened()
//        );
    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                .errorText.getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }

    //@Test
//    public void addProjectTest() {
//        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
//        projectSteps.addProject("WP_01");
//
//        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
//                "WP_01");
//    }
}
