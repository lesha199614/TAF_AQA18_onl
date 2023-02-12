package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingSearchResultPage extends BasePage {
    public BookingSearchResultPage(WebDriver driver) {
        super(driver);
    }

    private final By hotelResults = By.xpath("//div[@data-testid='property-card']//div[@data-testid='title']");

    public List<WebElement> getListOfResults() {
        return driver.findElements(hotelResults);
    }
    public List<String> getListOfHotelNames() {

    }
}
