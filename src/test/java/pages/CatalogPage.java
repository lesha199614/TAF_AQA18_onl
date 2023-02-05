package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    String link = "/inventory.html";

    public String getLink() {
        return link;
    }

    SelenideElement title = $(".title");
    List<SelenideElement> items = $$(".inventory_item_name");
    List <SelenideElement> itemPrice = $$ (".inventory_item_price");
    List <SelenideElement> addItemToCartButton = $$ (".btn_inventory");
    SelenideElement cartButton = $(".shopping_cart_link");

    public SelenideElement getTitle() {
        return title;
    }

    public List<SelenideElement> getItems() {
        return items;
    }

    public List<SelenideElement> getItemPrice() {
        return itemPrice;
    }

    public List<SelenideElement> getAddItemToCartButton() {
        return addItemToCartButton;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }
}
