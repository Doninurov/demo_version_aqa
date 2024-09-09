package pages;


import com.codeborne.selenide.SelenideElement;
import interfaces.Text;
import org.aeonbits.owner.ConfigFactory;
import owner.config.AuthConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage implements Text {
    private final SelenideElement
            passwordField = $("#password"),
            userNameField = $("#user-name"),
            loginBtn = $("#login-button"),
            headerContainer = $(".header_secondary_container");

    public RegistrationPage setPassword(String value) {
        passwordField.setValue(value);
        return this;
    }
    public RegistrationPage setUserName(String value) {
        userNameField.setValue(value);
        return this;
    }
    public void checkForSuccessLogin() {
        loginBtn.click();
        headerContainer.shouldHave(text(PRODUCTS));
    }
    public void authorization() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        userNameField.setValue(config.username());
        passwordField.setValue(config.password());
        loginBtn.click();
        headerContainer.shouldHave(text(PRODUCTS));
    }
}


