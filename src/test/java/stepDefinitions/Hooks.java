package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Text;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void AfterScenario() throws IOException {

         testContextSetup.testBase.WebDriverManager().close();
        System.out.println(">>>Browser is closed");
        testContextSetup.testBase.WebDriverManager().quit();
        System.out.println(">>>Driver  quits");

    }
    @AfterStep
    public void AddScreenShot(Scenario scenario) throws IOException {
        WebDriver webDriver = testContextSetup.testBase.WebDriverManager();
        if (scenario.isFailed()){
            File sourcePath = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            byte[] bytesScreenshot = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(bytesScreenshot,"image/png", "image");

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>AddScreenShot"+scenario.getName());
        }
    }
}
