package stepDefinitions;


import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import pageObject.CheckoutPage;
import pageObject.LandingPage;
import utils.TestContextSetup;



public class CheckoutPageStepDefinition {
    LandingPage landingPage ;
    CheckoutPage checkoutPage;

    public WebDriver driver;
    TestContextSetup testContextSetup;
    String productName;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }
    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_xxx_items_in_checkout_page(String name) throws InterruptedException {

        landingPage.CheckoutItems();
        Thread.sleep(2000);
        productName = name;

    }
    @Then("Verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
        String code = String.valueOf(1231);
        checkoutPage.assertProductName(productName);
        Thread.sleep(2000);
        checkoutPage.proceedPromo(code);

    }







}
