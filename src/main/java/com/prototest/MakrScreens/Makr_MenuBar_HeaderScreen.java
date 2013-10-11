package com.prototest.MakrScreens;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 5:45 PM
 * This class should be present on almost all screens
 */

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class Makr_MenuBar_HeaderScreen extends appiumScreenBase {

    appElement MenuButton = new appElement("Menu", By.xpath("//window[1]/button[1]"));
    appElement WelcomeText = new appElement("WelcomeText", By.xpath("//window[1]/text[1]")); //hopefully there's a way to get this value
    appElement HomeButton = new appElement("HomeButton", By.xpath("//window[1]/button[1]"));
    appElement ProjectsButton = new appElement("Project Archive", By.xpath("//window[1]/button[3]"));
    appElement BlogButton = new appElement("Blog", By.xpath("//window[1]/button[4]"));
    appElement ShoppingCartButton = new appElement("ShoppingCart_Button", By.xpath("//window[1]/button[5]"));
    //appElement BetaFeedBack = new appElement("BetaFeedBack", By.name("wmbBetafeedbackButton normal")); //This doesn't exist anymore
    appElement PlusButton = new appElement("PlusButton", By.xpath("//window[1]/button[6]"));

    List<appElement> MenuBarElements;

    public Makr_MenuBar_HeaderScreen(){
        initList();
        VerifyContent(MenuBarElements);
    }

    private void initList(){
        MenuBarElements = new ArrayList<appElement>();
        MenuBarElements.add(MenuButton);
        MenuBarElements.add(WelcomeText);
        MenuBarElements.add(HomeButton);
        MenuBarElements.add(ProjectsButton);
        MenuBarElements.add(BlogButton);
        MenuBarElements.add(ShoppingCartButton);
        //MenuBarElements.add(BetaFeedBack);
        MenuBarElements.add(PlusButton);
    }

    public Makr_Menu_NewProject_Screen OpenProjectMenu(){
        PlusButton.tap();
        return new Makr_Menu_NewProject_Screen();
    }

    public int VerifyShoppingCartAmountIcon(){
        String value = ShoppingCartButton.GetAttribute("value");
        int val = Integer.parseInt(value);
        Assert.assertTrue("Verify that shopping cart icon is greater than zero", val > 0);
        return val;
    }





}
