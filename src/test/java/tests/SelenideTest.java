package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends BaseTest {

    @Test
    public void sauceDemo() {
        open("/");
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        navigationStep.openFirstItemFromCatalog();
        userStep.addItemToCart();
        navigationStep.openCartFromItemPage();
        userStep.setOrder().getCompleteOrder()
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }
}
