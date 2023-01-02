package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {

    //private final By headerTitleHeaderLocator = By.xpath("//div[contains(text(), 'All Projects')]");
    private final By headerTitleHeaderLocator = By.id("ui-dialog-title-messageDialog");

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleHeaderLocator;
    }
}
