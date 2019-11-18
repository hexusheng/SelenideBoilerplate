package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.DriverHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;


public class LoginPage extends BasePage {

    public SelenideElement loginField = $("#login__username");
    public SelenideElement passwordField = $("#login__password");
    public SelenideElement signInButton = $("#login_enter");
    public SelenideElement termsOfUseLabel = $("label[for=\"login_agree\"]");

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    @Step("Login with email - {email} and password - {password}")
    public void login(String email, String password) {
        loginField.setValue(email);
        passwordField.setValue(password);
        termsOfUseLabel.click();
        signInButton.click();
        DriverHelper.waitForUrlContains("account/accounts");
    }
}
