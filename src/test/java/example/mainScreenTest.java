package example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.MainScreenPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class mainScreenTest extends testBase {
    MainScreenPage mainScreenPage = new MainScreenPage();
    RegistrationPage registrationPage = new RegistrationPage() ;
    @BeforeEach
    void authorizationAsUser() {
        step("Login to site", () -> {
            open(Configuration.baseUrl);
            registrationPage.authorization();
        });

    }
    @AfterEach
    void clearActions() {
        step("Clearing all action we done on site", () -> {
            mainScreenPage.clickToBurgerMenuBtn();
            mainScreenPage.clickToResetBtn();
        });
    }
    @Tag("Smoke")
    @Test
    @DisplayName("Adding one item into cart")
    void add1ItemToCart() {
        step("Checking for card is empty", () -> {
            mainScreenPage.checkForCartEmpty();
        });
        step("Adding backpack into cart", () -> {
            mainScreenPage.addBackpackIntoCart();
        });
        step("Checking that cart is not empty", () -> {
            mainScreenPage.checkForCartBadge(1);
        });

    }

    @Tag("Smoke")
    @Test
    @DisplayName("Adding 5 items into cart")
    void add5ItemsToCart() {
        step("Checking for card is empty", () -> {
            mainScreenPage.checkForCartEmpty();
        });
        step("Adding 5 items into cart", () -> {
            mainScreenPage.add5ItemsIntoCart();
        });
        step("Checking that cart is not empty", () -> {
            mainScreenPage.checkForCartBadge(5);
        });
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Remove btn appear after adding item to cart")
    void removeBtnAppear() {
        step("Checking for remove btn is not exist", () -> {
            mainScreenPage.checkForRemoveBtnNotExist();
        });
        step("Adding backpack into cart", () -> {
            mainScreenPage.addBackpackIntoCart();
        });
        step("Checking remove btn appear", () -> {
            mainScreenPage.checkForRemoveBtnAppear();
        });
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Checking for btn conditions still the same after logout and login ")
    void checkingBtnConditionAfterLogout() {
        step("Checking for remove btn is not exist", () -> {
            mainScreenPage.checkForRemoveBtnNotExist();
        });
        step("Adding backpack into cart", () -> {
            mainScreenPage.addBackpackIntoCart();
        });
        step("Checking remove btn appear", () -> {
            mainScreenPage.checkForRemoveBtnAppear();
        });
        step("Logout and login again", () -> {
            mainScreenPage.clickToBurgerMenuBtn();
            mainScreenPage.clickToLogoutBtn();
            registrationPage.authorization();
        });
        step("Checking remove btn appear", () -> {
            mainScreenPage.checkForRemoveBtnAppear();
        });
        step("Checking that cart has still 1 item", () -> {
            mainScreenPage.checkForCartBadge(1);
        });
    }
}
