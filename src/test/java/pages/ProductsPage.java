package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By headerTitleHeaderLocator = By.id("ui-dialog-title-messageDialog");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    public boolean isPageOpened() {
        return super.isPageOpened();
    }

    @Override
    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }
}
