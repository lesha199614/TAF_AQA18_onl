package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CartPage {
    String link = "cart.html";

    public String getLink() {
        return link;
    }

    SelenideElement title = $(".title");
    List<SelenideElement> items = $$(".inventory_item_name");
    List<SelenideElement> prices = $$(".inventory_item_price");
    List<SelenideElement> removeItem = $$(".cart_button");
    SelenideElement checkoutButton = $("#checkout");
    SelenideElement firstName = $("#first-name");
    SelenideElement lastName = $("#last-name");
    SelenideElement postalCode = $("#postal-code");
    SelenideElement continueButton = $("#continue");
    SelenideElement finishButton = $("#finish");
    SelenideElement completeOrder = $(".complete-header");

    public SelenideElement getTitle() {
        return title;
    }

    public List<SelenideElement> getItems() {
        return items;
    }

    public List<SelenideElement> getPrices() {
        return prices;
    }

    public List<SelenideElement> getRemoveItem() {
        return removeItem;
    }

    public SelenideElement getCheckoutButton() {
        return checkoutButton;
    }

    public SelenideElement getFirstName() {
        return firstName;
    }

    public SelenideElement getLastName() {
        return lastName;
    }

    public SelenideElement getPostalCode() {
        return postalCode;
    }

    public SelenideElement getContinueButton() {
        return continueButton;
    }

    public SelenideElement getFinishButton() {
        return finishButton;
    }

    public SelenideElement getCompleteOrder() {
        return completeOrder;
    }
}
