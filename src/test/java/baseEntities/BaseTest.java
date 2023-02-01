package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;
import steps.NavigationStep;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected NavigationStep navigationStep;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
        driver.get(ReadProperties.getUrl());

        // Solution 1
        iTestContext.setAttribute("driver", driver);
        // Solution 1 - Finish

        userStep = new UserStep(driver);
        navigationStep = new NavigationStep(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        driver.quit();
    }
}
