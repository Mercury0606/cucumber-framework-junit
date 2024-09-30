package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObject.LandingPage;
import utils.TestContextSetup;




public class LandingPageStepDefinition {

    public WebDriver driver;
    LandingPage landingPage;
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();

    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() throws InterruptedException {
        Assert.assertEquals(landingPage.getTitle(),"GreenKart - veg and fruits kart");
    }


    @When("^User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);

        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getSearchText().split("-")[0].trim();
    }

    @When("Add {int} items of the selected product to cart")
    public void add_items_of_the_selected_product_to_cart(int num) {
        // Write code here that turns the phrase above into concrete actions
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.increaseQuantity(3);
    }

}
