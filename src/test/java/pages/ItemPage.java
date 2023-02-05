package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ItemPage {
    SelenideElement itemName = $(".inventory_details_name");
    SelenideElement itemPrice = $(".inventory_details_price");
    SelenideElement addItemToCartButton = $(".btn_inventory");
    SelenideElement cart = $(".shopping_cart_link");
    SelenideElement backToCatalogButton = $("#back-to-products");

    public SelenideElement getBackToCatalogButton() {
        return backToCatalogButton;
    }

    public SelenideElement getItemName() {
        return itemName;
    }

    public SelenideElement getItemPrice() {
        return itemPrice;
    }

    public SelenideElement getAddItemToCartButton() {
        return addItemToCartButton;
    }

    public SelenideElement getCart() {
        return cart;
    }
}
