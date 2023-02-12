package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BookingSearchResultPage;
import pages.BookingStartPage;

public class BookingStepsDefs extends BaseCucumberTest {

    private BaseCucumberTest baseCucumberTest;
    private BookingStartPage bookingStartPage;
    private BookingSearchResultPage bookingSearchResultPage;

    public BookingStepsDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
        this.bookingStartPage = new BookingStartPage(driver);
        this.bookingSearchResultPage = new BookingSearchResultPage(driver);
    }

    @Given("open Booking")
    public void openBooking() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    @When("search for {string} destination")
    public void searchForHotel(String hotel) {
        bookingStartPage.getDestination().sendKeys(hotel);
        bookingStartPage.getHelp().click();
        bookingStartPage.getSearchButton().click();
    }

    @Then("{string} hotel result exist")
    public void hotelResultExist(String hotel) {
        Assert.assertTrue(bookingSearchResultPage.getListOfHotelTitles().contains(hotel));
    }

    @Then("Rating of {string} equals {string}")
    public void ratingEquals(String hotel, String rating) {
        Assert.assertEquals(bookingSearchResultPage.getListOfHotelRatings().get(
                bookingSearchResultPage.getListOfHotelTitles().indexOf(hotel))
                , rating);
    }
}
