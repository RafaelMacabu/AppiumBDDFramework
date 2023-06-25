package com.qa.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username) {

    }

    @When("I enter the password {string}")
    public void iEnterThePassword(String password) {

    }

    @When("I Log in")
    public void iLogIn() {

    }

    @Then("I should get a error message {string}")
    public void iShouldGetAErrorMessage(String error) {

    }

    @Then("I should see the products page with the title {string}")
    public void iShouldSeeTheProductsPageWithTheTitle(String title) {

    }
}
