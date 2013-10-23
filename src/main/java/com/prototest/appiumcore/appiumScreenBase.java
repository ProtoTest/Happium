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

    WebDriver driver = appiumTestBase.getDriver();
    List<WebElement> WebElementList;
    List<appElement> VisibleAppElements;



    public appiumScreenBase(){
        WebElementList =  driver.findElements(By.tagName("UIAButton"));
        WebElementList.addAll(driver.findElements(By.tagName("UIATextField")));
        WebElementList.addAll(driver.findElements(By.tagName("UIASecureTextField")));
        WebElementList.addAll(driver.findElements(By.tagName("UIAStaticText")));
    }

    public WebElement FindElement(int x, int y){
        //This takes a long time to find objects like this
        Point location = new Point(x, y);
        int matchingIndex = 0;
        for(int i = 0; i < WebElementList.size(); i++){
            if(WebElementList.get(i).isDisplayed()){
                if(WebElementList.get(i).getLocation().equals(location)){
                    System.out.println("gonna try tapping " + WebElementList.get(i).getTagName() + " " + WebElementList.get(i).getLocation().toString());
                    matchingIndex = i;
                    i = WebElementList.size(); //get out of the loop when you find a match
                }
            }
        }
        return WebElementList.get(matchingIndex);

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
