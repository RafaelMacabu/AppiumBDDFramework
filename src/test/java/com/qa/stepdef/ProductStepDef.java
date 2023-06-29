package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsDetailsPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {


    @Given("I'm logged in")
    public void imLoggedIn() {
        LoginPage.action()
                .login("standard_user","secret_sauce");

    }

    @When("I click on the product title {string}")
    public void iClickOnTheProductTitle(String title) {
        ProductsPage.action()
                .clickSLBTitle();
    }


    @Then("the product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String title, String price) {
        Boolean checkTitle = ProductsPage.action().getSLBTitle().equalsIgnoreCase(title);
        Boolean checkPrice = ProductsPage.action().getSLBPrice().equalsIgnoreCase(price);
        Assert.assertTrue(checkPrice & checkTitle);
    }


    @Then("I should be on the products details page with title {string},price {string} and description {string}")
    public void iShouldBeOnTheProductsDetailsPageWithTitlePriceAndDescription(String title, String price, String description) {
        Boolean checkTitle = ProductsDetailsPage.action().getSLBCartTitle().equalsIgnoreCase(title);
        Boolean checkPrice = ProductsDetailsPage.action().getSLBPrice().equalsIgnoreCase(price);
        Boolean checkDesc = ProductsDetailsPage.action().getSLBCartDescription().equalsIgnoreCase(description);
        Assert.assertTrue(checkPrice & checkTitle & checkDesc);

    }

}
