package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.DeliveryUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_Tests extends BaseTest {


    @Test
    public void login() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        navigationStep.openFirstItemPage();
        userStep.addFirstItemFromItemPage();
        navigationStep.returnToCatalogFromItemPage();
        navigationStep.openCartFromCatalog();
        Assert.assertEquals(userStep.completeOrder("Alex", "Vayteh", "1243").title.getText(), "CHECKOUT: COMPLETE!");
    }

    @Test
    public void chain() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .addToCart
                .get(0)
                .click();
        Assert.assertEquals(navigationStep.openCartFromCatalog()
                        .cartCheckOut()
                        .setShippingValues("Alex", "Vayeh", "1234")
                        .clickContinue()
                        .clickFinish()
                        .backToCatalog()
                        .title
                        .getText()
                , "PRODUCTS");
    }

    @Test
    public void valueOfObject() {
        User user = userStep.createUser();
        DeliveryUser deliveryUser = userStep.createDeliveryUser();
        userStep.loginSuccessful(user);
        userStep.addFirstItemToCartFromCatalog();
        navigationStep.openCartFromCatalog();
        Assert.assertEquals(userStep.completeOrder(deliveryUser).title.getText(), "CHECKOUT: COMPLETE!");
    }

    @Test
    public void builder() {
        User user = User.builder()
                .userName(ReadProperties.username())
                .password(ReadProperties.password())
                .build();
        DeliveryUser deliveryUser = DeliveryUser.builder()
                .userName("Alex")
                .lastName("Vayteh")
                .postalCode("1234")
                .build();
        userStep.loginSuccessful(user);
        userStep.addFirstItemToCartFromCatalog();
        navigationStep.openCartFromCatalog();
        Assert.assertEquals(userStep.completeOrder(deliveryUser).title.getText(), "CHECKOUT: COMPLETE!");
    }

}