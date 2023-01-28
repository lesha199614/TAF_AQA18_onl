package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.Checkbox;
import elements.DropDown;
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

    //@Test(description = "Description")
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

    //@Test
    public void addProjectTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.addProject("WP_01");

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                "WP_01");
    }

    //@Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("1");
        page.getType().selectByText("Use multiple test suites to manage cases");

    }

    //@Test
    public void checkBoxTest() throws InterruptedException {
        userStep.loginSuccessful(ReadProperties.username(),ReadProperties.password());
        driver.get("https://aqa18onl03.testrail.io/index.php?/admin/projects/edit/1/1");
        Checkbox checkbox = new Checkbox(driver, "Show the announcement on the overview page");
        System.out.println(checkbox.getAttributeName());
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
        Thread.sleep(2000);
        Checkbox checkbox1 = new Checkbox(driver, By.name("is_completed"));
        System.out.println(checkbox1.getAttributeName());
        checkbox1.click();
        System.out.println(checkbox1.isEnabled());
    }
    @Test
    public void dropdown() throws InterruptedException {
        userStep.loginSuccessful(ReadProperties.username(),ReadProperties.password());
        driver.get("https://aqa18onl03.testrail.io/index.php?/cases/add/1");
        DropDown dropDown = new DropDown(driver, "Template");

        Thread.sleep(2000);
    }

}
//label[contains(text(),'Template')]
//label[contains(text(),'Template']/parent::*//li