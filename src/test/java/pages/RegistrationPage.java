package pages;


import org.aeonbits.owner.ConfigFactory;
import owner.config.AuthConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static interfaces.Text.PRODUCTS;

public class RegistrationPage {
    private static final String
            PASSWORD_FIELD = "#password",
            USER_NAME_FIELD = "#user-name",
            LOGIN_BTN = "#login-button",
            HEADER_CONTAINER = ".header_secondary_container";
    public RegistrationPage setPassword(String value) {
        $(PASSWORD_FIELD).setValue(value);
        return this;
    }
    public RegistrationPage setUserName(String value) {
        $(USER_NAME_FIELD).setValue(value);
        return this;
    }
    public RegistrationPage checkForSuccessLogin() {
        $(LOGIN_BTN).click();
        $(HEADER_CONTAINER).shouldHave(text(PRODUCTS));
        return this;
    }
    public RegistrationPage authorization() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        $(USER_NAME_FIELD).setValue(config.username());
        $(PASSWORD_FIELD).setValue(config.password());
        $(LOGIN_BTN).click();
        $(HEADER_CONTAINER).shouldHave(text(PRODUCTS));
        return this;
    }
}


