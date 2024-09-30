package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");

    private By addToCartBtn = By.cssSelector("div[class='product-action'] button[type='button']" );

    private By cartBtn = By.xpath("//a[@class=\"cart-icon\"]");
    private By proceedToCheckoutBtn = By.cssSelector("div[class='cart-preview active'] button[type='button']");

    private By addProductBtn =By.cssSelector(".increment");

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getSearchText(){
        return driver.findElement(search).getText();
    }
    public String getSearchName(){
        return driver.findElement(productName).getText();
    }


    public void selectTopDeals(){
        driver.findElement(topDeals).click();

    }
    public void addToCart(){
        driver.findElement(addToCartBtn).click();
        String addedText = driver.findElement(addToCartBtn).getText();
        Assert.assertTrue(addedText.contains("ADDED"));

    }
    public void increaseQuantity(int num){
        for (int i = 1; i < num; i++) {
            driver.findElement(addProductBtn).click();
            driver.findElement(addToCartBtn).click();
            String addedText = driver.findElement(addToCartBtn).getText();
            Assert.assertTrue(addedText.contains("ADDED"));
        }
    }

    public void proceedToCheckout(){
        driver.findElement(cartBtn).click();
    }

    public void CheckoutItems(){
        driver.findElement(cartBtn).click();
        driver.findElement(proceedToCheckoutBtn).click();

    }

    public String getTitle(){
        return driver.getTitle();
    }




}
