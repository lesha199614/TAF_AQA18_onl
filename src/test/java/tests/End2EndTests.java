package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class End2EndTests extends BaseTest {

    @Test
    public void makeOrder() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        navigationSteps.openFirstItem();
        userStep.addToCartFromFirstProductPage();
        navigationSteps.moveToCartFromFirstProductPage();
        navigationSteps.checkoutCart();
        userStep.fillCheckoutForm();
        Assert.assertEquals(userStep.submitForm().getCompleteOrder().getText(), "THANK YOU FOR YOUR ORDER");
    }
}
