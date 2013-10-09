package com.prototest.appiumcore;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:02 PM
 * TestBase Class for appium Tests
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class appiumTestBase {
    private static  WebDriver driver;
    private appElement window;
    //protected appiumScreenBase base;
    protected appiumTestLog.logger logFile;
    //public appiumTestLog.logger logFile;

    @Before
    public void setUp() throws Exception {
        System.out.println("Running Setup");
        //logFile = new appiumTestLog.logger();
        launchBrowser();
        //base = new appiumScreenBase();
        logFile = appiumScreenBase.logFile;
    }

    private void launchBrowser() throws Exception{
        //File app = new File("/Users/sethurban/Library/Developer/Xcode/DerivedData/Makr-cvsoqtvihpokiseidyefsjxwedqw/Build/Products/Debug-iphonesimulator/Makr.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "6.1");
        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");

        //capabilities.setCapability("app", app.getAbsolutePath());

        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        window = new appElement("Main_Window", By.xpath("//window[1]"));
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public void addTestEntry(String result){
        logFile.AddLog(result + this.getClass().getSimpleName());
    }

    @After
    public void TearDown(){
        //driver.close();
        driver.quit();
        System.out.println("**** Tear Down Method ****");
        logFile.printResults();
    }








}
