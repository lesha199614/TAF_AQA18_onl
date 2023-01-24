package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.project.AddProjectPage;
import steps.NavigationSteps;
import steps.ProjectSteps;
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
    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
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

    @Test
    public void addProjectTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.addProject("WP_01");

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                "WP_01");
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("1");
        page.getType().selectByText("Use multiple test suites to manage cases");

    }

}
