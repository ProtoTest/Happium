package com.prototest.appiumcore;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:02 PM
 * TestBase Class for appium Tests
 * 101113: SU - Added test logging
 */

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class appiumTestBase {
    private static  WebDriver driver;
    private appElement window;
    public static appiumTestLog.logger logFile;
    public static appiumElementRepo.ElementRepo elementRepo;

    public appiumTestBase(){
        logFile = new appiumTestLog.logger();

    }
    @Before
    public void setUp() throws Exception {
        System.out.println("Running Setup");
        logFile.AddLog("Initiating test suite: " + this.getClass().getSimpleName().toString());
        launchBrowser();
        //elementRepo = new appiumElementRepo.ElementRepo();
    }

    private void launchBrowser() throws Exception{
        //File app = new File("/Users/sethurban/Library/Developer/Xcode/DerivedData/Makr-cvsoqtvihpokiseidyefsjxwedqw/Build/Products/Debug-iphonesimulator/Makr.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "7.0");
        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");

        //capabilities.setCapability("app", app.getAbsolutePath());

        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        window = new appElement("Main_Window", By.xpath("//window[1]"));
    }

    public static WebDriver getDriver(){
        return driver;
    }




    @After
    public void TearDown(){
        //get here bitch
        System.out.println("*****************************************************");

    }





}
