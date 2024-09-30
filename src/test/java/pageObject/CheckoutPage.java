package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By promoCode = By.xpath("//input[@placeholder='Enter promo code']");

    By applyBtn = By.cssSelector(".promoBtn");
    By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
    By productName = By.cssSelector(".product-name");

    public void proceedPromo(String code){
        driver.findElement(promoCode).sendKeys(code);
        driver.findElement(applyBtn).click();
        driver.findElement(placeOrderBtn).click();

    }
    public void assertProductName(String name){
        String orderdProductName = driver.findElement(productName).getText();
        Assert.assertTrue(orderdProductName.contains(name));

    }












}
