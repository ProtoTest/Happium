package com.prototest.appiumcore;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/11/13
 * Time: 11:27 AM
 * Base Screen object for appiumTests
 */
public class appiumScreenBase {
    protected appElement AppMainWindow = new appElement("AppMainWindow", By.xpath("//window[1]"));
    protected appElement HideKeyboard = new appElement("HideKeyboard", By.xpath("//window[2]/UIAKeyboard[1]/button[6]"));

    protected appiumScreenHistory.ScreenHistory ScreenHS = new appiumScreenHistory.ScreenHistory();
    appElement SurveyHeader = new appElement("SurveyHeader", By.xpath("//window[1]/navigationBar[1]/text[1]")); //This should be present on both surveys

    appiumElementRepo.ElementRepo WebElementList = appiumTestBase.elementRepo;




    public appiumScreenBase(){
        JavascriptExecutor js = (JavascriptExecutor) appiumTestBase.getDriver();
        String pagesource = (String) js.executeScript("wd_frame.getPageSource()");
        String[] pagestrings;
        pagestrings = pagesource.split("type");

    }

    public appElement FindElement(String type, int x, int y){
        //This takes a long time to find objects like this
        Point location = new Point(x, y);
        appElement item = null;
        if(type == "UIAButton"){
            //item = WebElementList.getButton(location);
            item = appiumTestBase.elementRepo.getButton(location);
        }
        if(type == "UIASecureTextField"){
            item = WebElementList.getSecure(location);
        }
        if(type == "UIAStaticText"){
            item = WebElementList.getStatic(location);
        }
        if(type == "UIATextField"){
            item = WebElementList.getText(location);
        }

        return item;

        //This didn't work for appium - :(
        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement foundthing = (WebElement) js.executeScript("document.elementFromPoint("+ String.valueOf(x)+ "," + String.valueOf(y) + ")");
        return foundthing;   */
    }
    public void addScreenHistory(Object obj){
        ScreenHS.addScreen(obj);
        Object last = ScreenHS.getLast();
        String className = last.getClass().getSimpleName();
        System.out.print(className);

    }
    /*This function has the list of elements passed into it to verify they are present on any given screen */
    protected void VerifyContent(List<appElement> elements){
        //commented out to make tests run faster
        /*if(elements.size() > 0){
            for(int i = 0; i < elements.size(); i++){
                if(elements.get(i).isDisplayed()){
                    System.out.println(elements.get(i).GetElementName() + " is displayed");
                }
                else{
                    System.out.println(elements.get(i).GetElementName() + " is NOT displayed");
                }

            }
        } */
    }


}
