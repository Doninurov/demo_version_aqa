package pages;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainScreenPage {
    private static final String
            BACKPACK_ITEM = "#add-to-cart-sauce-labs-backpack",
            BIKE_LIGHT_ITEM = "#add-to-cart-sauce-labs-bike-light",
            BIKE_T_SHIRT_ITEM = "#add-to-cart-sauce-labs-bolt-t-shirt",
            FLEECE_JACKET_ITEM = "#add-to-cart-sauce-labs-fleece-jacket",
            ONESIE_ITEM = "#add-to-cart-sauce-labs-onesie",
            CART_BADGE = "#shopping_cart_container .shopping_cart_badge",
            REMOVE_BACKPACK_ITEM = "#remove-sauce-labs-backpack",
            BURGER_MENU_BTN = "#react-burger-menu-btn",
            RESET_ACTIONS_BTN = "#reset_sidebar_link",
            LOGOUT_BTN = "#logout_sidebar_link";

    public MainScreenPage checkForCartEmpty() {
        $(CART_BADGE).shouldNot(exist);
        return this;
    }
    public MainScreenPage addBackpackIntoCart() {
        $(BACKPACK_ITEM).click();
        return this;
    }
    public MainScreenPage add5ItemsIntoCart() {
        String[] itemId = {BACKPACK_ITEM,  BIKE_LIGHT_ITEM, BIKE_T_SHIRT_ITEM,FLEECE_JACKET_ITEM,ONESIE_ITEM};
        for (String identifier : itemId) {
            $(identifier).click();
        }
        return this;
    }
    public MainScreenPage checkForCartBadge(int expectedItemInCart) {
        String expectedText = String.valueOf(expectedItemInCart);
        $(CART_BADGE).shouldHave(text(expectedText));
        return this;
    }
    public MainScreenPage checkForRemoveBtnNotExist() {
        $(REMOVE_BACKPACK_ITEM).shouldNot(exist);
        return this;
    }
    public MainScreenPage checkForRemoveBtnAppear() {
        $(REMOVE_BACKPACK_ITEM).should(exist);
        return this;
    }
    public MainScreenPage clickToBurgerMenuBtn() {
        $(BURGER_MENU_BTN).click();
        return this;
    }
    public MainScreenPage clickToLogoutBtn() {
        $(LOGOUT_BTN).click();
        return this;
    }
    public MainScreenPage clickToResetBtn() {
        $(RESET_ACTIONS_BTN).click();
        return this;
    }
}


