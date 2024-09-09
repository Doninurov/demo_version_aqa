package example;

import com.codeborne.selenide.Configuration;
import interfaces.Text;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import owner.config.AuthConfig;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationTest extends testBase implements Text {
        RegistrationPage registrationPage = new RegistrationPage() ;
    @Disabled
    @Test
    @DisplayName("Successful login")
    void LoginSuccess() {
        step("Open registrations form", () -> {
            open(Configuration.baseUrl);
        });
        step("Filling form", () -> {
            registrationPage.setUserName(USER_NAME)
                    .setPassword(PASSWORD);
        });
        step("Checking for login", () -> {
            registrationPage.checkForSuccessLogin();
        });
    }

//        Правильный вариант с библиотекой OWNER
    @Test
    @DisplayName("Successful login")
    void LoginSuccessWithOwner() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        step("Open registrations form", () -> {
            open(Configuration.baseUrl);
        });
        step("Filling form", () -> {
            registrationPage.setUserName(config.username())
                    .setPassword(config.password());
        });
        step("Checking for login", () -> {
            registrationPage.checkForSuccessLogin();
        });
    }
    }
