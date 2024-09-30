package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriver WebDriverManager() throws IOException {
        //Dynamic path => System.getProperty("user.dir")
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resource/global.properties");
        Properties prop = new Properties();
        prop.load(fileInputStream);
        String url = prop.getProperty("url");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
         String result = browser_maven != null ? browser_maven : browser_properties;


        if (driver == null ){
            if (result.equalsIgnoreCase( "chrome")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resource/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
            }
            if (result.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/resource/geckodriver");

                FirefoxOptions options = new FirefoxOptions();
                options.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver(options);
            }
            driver.get(url);
        }
        return driver;
    }
}
