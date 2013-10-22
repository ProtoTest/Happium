package com.prototest.appiumcore;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 6:03 PM
 * Elements for appium
 * 101113: Attempted to add logFile entries
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class appElement {
    private By by;
    private WebDriver driver;
    private String name;
    private WebElement element;
    private Integer Xloc;
    private Integer Yloc;
    private Integer Xsize;
    private Integer Ysize;
    private static appiumTestLog.logger logFile;


    public appElement(String n, By b){
        this.name = n;
        this.by = b;
        this.driver = appiumTestBase.getDriver();
        logFile = appiumTestBase.logFile;

        //this.element = driver.findElement(b);
    }

    public appElement(String n, int x_loc, int y_loc, int x_size, int y_size){
        this.name = n;
        this.Xloc = x_loc;
        this.Yloc = y_loc;
        this.Xsize = x_size;
        this.Ysize = y_size;

        this.driver = appiumTestBase.getDriver();
        logFile = appiumTestBase.logFile;
    }

    public WebElement getAppElement(){
        return element;
    }

    public void setAppElement(){
        element = driver.findElement(by);
    }

    public String GetElementName(){
        return this.name;
    }

    public String GetAttribute(String attr){
        setAppElement();
        return element.getAttribute(attr);
    }

    public boolean isDisplayed(){
        setAppElement();
        if(element.isDisplayed()){
            logFile.AddLog("Element: " + this.name + " is displayed on screen");
        }
        else{
            logFile.AddLog("Element: " + this.name + " is NOT displayed on screen");
        }
        return element.isDisplayed();
    }

    public void tap(){
        logFile.AddLog("Tap on Element: "+ this.name + " with locator:\t"+ this.by.toString());
        setAppElement();
        element.click();
    }

    public void tapLoc(){
        //This will only be usefull if we just need to tap something specific
        int xcenter;
        int ycenter;
        //This function will attempt to tap on an object by screen location
        //First need to check that all the values we need to do this are not null
        if((Xsize != null) && (Ysize != null) && (Xloc != null) && (Yloc != null)){
            //so the values are not equal to null we can attempt the tap
            //We need to figure out the center of the element relative to the screen
            xcenter = Xsize/2; //This value will be added to Xloc for the tap location
            ycenter = Ysize/2; //This value will be added to Yloc for the tap location
            Xloc += xcenter;
            Yloc += ycenter;
            //Now that we know where to tap, let's set up the stuff to do the tap
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //We have to convert our computed values to doubles to execute the javascript --lame
            Double X = (double) Xloc;
            Double Y = (double) Yloc;
            logFile.AddLog("Attempting to tap on Element: " + this.name + " by Screen Location Tap at X: " + String.valueOf(X) + " Y: " + String.valueOf(Y));
            HashMap<String, Double> tapObject = new HashMap<String, Double>();
            tapObject.put("x", X); //Pixels from left
            tapObject.put("y", Y); //Pixels from top
            js.executeScript("mobile: tap", tapObject);
        }
        else{
            logFile.AddLog("Attempted to Tap on Screen Location for Element: " + this.name + " with no location variables set!");
        }
    }

    public boolean verifyPresent(){
        //setAppElement();
        boolean exists;
        if(driver.findElements(by).size() != 0)
        {
            exists = true;
        }
        else {
            exists = false;
        }
        if(exists){
            logFile.AddLog("Element: " + name + " with Locator: " + by.toString() + " is present.");
        }
        else{
            logFile.AddLog("Element: " + name + " with Locator: " + by.toString() + " is MISSING!");
        }
        return exists;

    }

    public void waitforElementPresent(){
        boolean present = false;

        while(!present){
            logFile.AddLog("Trying to find element:" + name + " with locator: " + by.toString());
            if(!driver.findElements(by).isEmpty()){
                present = true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logFile.AddLog(e.getStackTrace().toString());

            }
        }
    }

    public void AcceptAlert(){
        driver.switchTo().alert().accept();

    }

    public void Swipe(String direction) {
        double SwipeDuration = 0.5; //This is the minimum amount, anything less crashes the app
        direction.toUpperCase();
        if ((direction.equals("LEFT")) || (direction.equals("L"))) {
            SwipeDirection(0.95, 0.5, 0.05, 0.5, SwipeDuration);
        } else if ((direction.equals("RIGHT")) || (direction.equals("R"))) {
            SwipeDirection(0.05, 0.5, 0.95, 0.5, SwipeDuration);
        } else if ((direction.equals("UP")) || (direction.equals("U"))) {
            SwipeDirection(0.5, 0.95, 0.5, 0.05, SwipeDuration);
        } else if ((direction.equals("DOWN")) || (direction.equals("D"))) {
            SwipeDirection(0.5, 0.05, 0.5, 0.95, SwipeDuration);
        } else {
            System.out.println("Invalid Swipe Direction called.");
        }
    }

    public void SendKeys(String text){
        setAppElement();
        element.sendKeys(text);

    }
    public String getText(){
        return element.getText();
    }

    public void ScrollUp(){
       SwipeDirection(0.0, 0.0, 0.5, 0.95, 0.0);
    }

    public void ScrollDown(){
        SwipeDirection(0.0, 0.0, 0.5, 0.20, 0.0);
    }
    private void SwipeDirection(Double SrtX, Double SrtY, Double endX, Double endY, Double duration){

        setAppElement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();

        if(duration > 0.0)
        {
            swipeObject.put("startX", SrtX);
            swipeObject.put("startY", SrtY);
            swipeObject.put("endX", endX);
            swipeObject.put("endY", endY);
            swipeObject.put("duration", duration);
            js.executeScript("mobile: swipe", swipeObject);
        }
        else {

            swipeObject.put("endX", endX);
            swipeObject.put("endY", endY);
            js.executeScript("mobile: flick", swipeObject);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread Sleep in SwipeDirection() Interrupted");
        }
    }



}
