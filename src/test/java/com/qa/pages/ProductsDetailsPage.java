package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsDetailsPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private WebElement cartBackpackTitle;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    private WebElement cartBackpackDescription;
    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    private WebElement backToProductsButton;
    @AndroidFindBy(accessibility = "test-Price")
    private WebElement SLBPrice;

    public static ProductsDetailsPage action(){
        return new ProductsDetailsPage();
    }

    public String getSLBCartTitle(){
         return getText(cartBackpackTitle);
    }

    public String getSLBCartDescription(){
        return getText(cartBackpackDescription);
    }

    public String getSLBPrice(){
        return getText(SLBPrice);
    }

    public ProductsDetailsPage scrollToPrice(){
        scrollToElement();
        return this;
    }

    public ProductsPage clickBackButton(){
        click(backToProductsButton);
        return new ProductsPage();
    }
}
