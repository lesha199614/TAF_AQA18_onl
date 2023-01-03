package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {

    //private final By headerTitleHeaderLocator = By.xpath("//div[contains(text(), 'All Projects')]");
    private final static String pagePath = "/index.php?/dashboard";
    private final By headerTitleHeaderLocator = By.id("ui-dialog-title-messageDialog");

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public DashBoardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver);

        if(openPageByUrl) {
            openPageByUrl();
        }
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleHeaderLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
