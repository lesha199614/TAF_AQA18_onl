package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingStartPage extends BasePage {

    public BookingStartPage(WebDriver driver) {
        super(driver);
    }

    private final By destinationLocator = By.xpath("//div[@data-testid='searchbox-layout-vertical']//input[@name='ss']");
    private final By searchButtonLocator = By.xpath("//div[@data-testid='searchbox-layout-vertical']//button[@type='submit']");
    private final By helpLocator = By.xpath("//div[@data-testid='searchbox-layout-vertical']//div[@data-testid='autocomplete-result']");

    public WebElement getDestination () {
        return waitsService.waitForExists(destinationLocator);
    }
    public WebElement getSearchButton () {
        return waitsService.waitForExists(searchButtonLocator);
    }
    public WebElement getHelp () {
        return waitsService.waitForExists(helpLocator);
    }
}
