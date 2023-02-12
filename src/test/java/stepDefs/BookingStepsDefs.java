package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void searchForHotel(String hotel) throws InterruptedException {
        bookingStartPage.getDestination().sendKeys(hotel);
        bookingStartPage.getHelp().click();
        bookingStartPage.getSearchButton().click();
        Thread.sleep(5000);
    }

    @Then("{string} hotel result exist")
    public void hotelResultExist(String hotel) {
    }
}
