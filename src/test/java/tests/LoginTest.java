package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void login() throws InterruptedException {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        navigationStep.openFirstItemPage();
        userStep.addFirstItemFromItemPage();
        navigationStep.returnToCatalogFromItemPage();
        navigationStep.openCartFromCatalog();
        userStep.completeOrder("Alex", "Vayteh", "1243");
        Thread.sleep(2000);

    }
}