package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

public class HW_Tests extends BaseTest {


    @Test
    public void login(){
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        navigationStep.openFirstItemPage();
        userStep.addFirstItemFromItemPage();
        navigationStep.returnToCatalogFromItemPage();
        navigationStep.openCartFromCatalog();
        userStep.completeOrder("Alex", "Vayteh", "1243");
    }

    @Test
    public void chain(){
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .addToCartFirstItem.click();
        navigationStep.openCartFromCatalog()
                .cartCheckOut()
                .setShippingValues("Alex", "Vayeh", "1234")
                .clickContinue()
                .clickFinish()
                .backToCatalog();


    }
}