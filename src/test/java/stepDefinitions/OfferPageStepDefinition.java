package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.LandingPage;
import pageObject.OffersPage;
import pageObject.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public String offerPageProductName;
    public String landingPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup  = testContextSetup;
    }

    @Then("^User searched with same (.+) in offers page$")
    public void user_searched_with_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
        switchToOfferPage();
        OffersPage offersPage = new OffersPage(testContextSetup.driver);
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getSearchText();

    }
    public void switchToOfferPage(){
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
//        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.selectTopDeals();
        //if is already switched to offer page -> skip below part
        if (!testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")){
            testContextSetup.genericUtils.switchWindowToChild();
        }

    }
    @Then("Validate product name in offers page matches with Landing page")
    public void validate_prod_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(testContextSetup.landingPageProductName,offerPageProductName);
    }
}
