package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Description")
    @Issue("AQA18-11")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "myLink", url = "https://onliner.by")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPassword().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void loginSuccessfulTest() {
        User user = new User.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        Assert.assertTrue(
                userStep.loginSuccessful(user)
                        .isPageOpened()
        );
    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                        .getErrorTextElement().getText(),
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
