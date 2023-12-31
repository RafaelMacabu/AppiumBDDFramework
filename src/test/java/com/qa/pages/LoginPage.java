package com.qa.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    @AndroidFindBy(accessibility = "test-Username")
    private WebElement usernameTxtField;
    @AndroidFindBy(accessibility = "test-Password")
    private WebElement passwordTxtField;
    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement errorMessage;

    public static LoginPage action() {
        return new LoginPage();
    }

    public LoginPage enterUsername(String username) {
        sendKeys(usernameTxtField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordTxtField, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    public String getErrorText() {
        return getText(errorMessage);
    }

    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new ProductsPage();

    }


}
