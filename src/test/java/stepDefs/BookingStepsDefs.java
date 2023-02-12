package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BookingStartPage;

public class BookingStepsDefs extends BaseCucumberTest {

    private BaseCucumberTest baseCucumberTest;
    private BookingStartPage bookingStartPage;

    public BookingStepsDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
        this.bookingStartPage = new BookingStartPage(driver);
    }

    @Given("open Booking")
    public void openBooking() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    @When("search for {string} destination")
    public void searchForHotel(String hotel) throws InterruptedException {
        bookingStartPage.getDestination().sendKeys(hotel);
        Thread.sleep(5000);
        bookingStartPage.getHelp().click();
        bookingStartPage.getSearchButton().click();
        Thread.sleep(5000);
    }
}
