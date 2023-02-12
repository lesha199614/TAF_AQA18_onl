package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CatalogPage;
import pages.ItemPage;
import pages.LoginPage;

public class NavigationStepsDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private ItemPage itemPage;
    private CartPage cartPage;

    public NavigationStepsDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
        this.loginPage = new LoginPage(driver);
        this.catalogPage = new CatalogPage(driver);
        this.itemPage = new ItemPage(driver);
        this.cartPage = new CartPage(driver);
    }

    @When("open first Item")
    public ItemPage openFirstItem() {
        catalogPage.getItem().get(0).click();
        return new ItemPage(driver);
    }
}
