package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BookingSearchResultPage extends BasePage {
    public BookingSearchResultPage(WebDriver driver) {
        super(driver);
    }

    private final By hotelResults = By.xpath("//div[@data-testid='property-card']");
    private final By hotelTitle = By.xpath("//div[@data-testid='title']");
    private final By hotelRating = By.xpath("//div[@ data-testid='review-score']/div[1]");

    public List<WebElement> getListOfResults() {
        return driver.findElements(hotelResults);
    }
    public List <WebElement> getListOfHotels() {
        return new ArrayList<>(driver.findElements(hotelResults));
    }
    public List <String> getListOfHotelTitles() {
        List <String> listOfTitles = new ArrayList<>();
        for (WebElement webElement : driver.findElements(hotelResults)){
            listOfTitles.add(webElement.findElement(hotelTitle).getText().trim());
        }
        return listOfTitles;
    }
    public List <String> getListOfHotelRatings() {
        List <String> listOfRating = new ArrayList<>();
        for (WebElement webElement : driver.findElements(hotelResults)){
            listOfRating.add(webElement.findElement(hotelRating).getText().trim());
        }
        return listOfRating;
    }
}
