
package pages;


import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainScreenPage {
    private final SelenideElement
            backpackItem = $("#add-to-cart-sauce-labs-backpack"),
            bikeLightItem = $("#add-to-cart-sauce-labs-bike-light"),
            bikeTShirtItem = $("#add-to-cart-sauce-labs-bolt-t-shirt"),
            fleeceJacketItem = $("#add-to-cart-sauce-labs-fleece-jacket"),
            onesieItem = $("#add-to-cart-sauce-labs-onesie"),
            cartBadge = $("#shopping_cart_container .shopping_cart_badge"),
            removeBackpackItem = $("#remove-sauce-labs-backpack"),
            burgerMenuBtn = $("#react-burger-menu-btn"),
            resetActionsBtn = $("#reset_sidebar_link"),
            logoutBtn = $("#logout_sidebar_link");

    public void checkForCartEmpty() {
        cartBadge.shouldNot(exist);
    }
    public void addBackpackIntoCart() {
        backpackItem.click();
    }
    public void add5ItemsIntoCart() {
        SelenideElement[] items = {backpackItem, bikeLightItem, bikeTShirtItem, fleeceJacketItem, onesieItem
        };
        Arrays.stream(items)
            .forEach(SelenideElement::click);
    }
    public void checkForCartBadge(int expectedItemInCart) {
        String expectedText = String.valueOf(expectedItemInCart);
        cartBadge.shouldHave(text(expectedText));
    }
    public void checkForRemoveBtnNotExist() {
        removeBackpackItem.shouldNot(exist);
    }
    public void checkForRemoveBtnAppear() {
        removeBackpackItem.should(exist);
    }
    public void clickToBurgerMenuBtn() {
        burgerMenuBtn.click();
    }
    public void clickToLogoutBtn() {
        logoutBtn.click();
    }
    public void clickToResetBtn() {
        resetActionsBtn.click();
    }
}


