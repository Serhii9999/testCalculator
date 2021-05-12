package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "pixel");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("udid", "emulator-5556");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test
    public void testAddition() {

        MobileElement buttonTwo = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        buttonTwo.click();
        MobileElement buttonAdd = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        buttonAdd.click();
        MobileElement buttonThree = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        buttonThree.click();
        MobileElement results = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_preview");

        Assert.assertEquals("5", results.getText(), "Result should be equals 5");
      

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}