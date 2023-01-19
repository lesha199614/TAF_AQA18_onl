package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.WaitsService;
import steps.UserStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
        driver.get(ReadProperties.getUrl());

        //Solution1
        iTestContext.setAttribute("driver", driver);
        //Solution 1 - Finish

        userStep = new UserStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
