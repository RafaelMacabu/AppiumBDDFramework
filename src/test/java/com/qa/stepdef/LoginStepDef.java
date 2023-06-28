package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username) {
        LoginPage.action()
                .enterUsername(username);

    }

    @When("I enter the password {string}")
    public void iEnterThePassword(String password) {
        LoginPage.action()
                .enterPassword(password);

    }

    @When("I Log in")
    public void iLogIn() {
        LoginPage.action()
                .clickLoginButton();

    }

    @Then("I should get a error message {string}")
    public void iShouldGetAErrorMessage(String error) {
        Assert.assertEquals(error,LoginPage.action().getErrorText());

    }

    @Then("I should see the products page with the title {string}")
    public void iShouldSeeTheProductsPageWithTheTitle(String title) {
        Assert.assertEquals(title, ProductsPage.action().getTitle());

    }
}
