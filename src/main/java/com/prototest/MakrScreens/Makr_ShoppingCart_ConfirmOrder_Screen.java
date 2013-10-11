package com.prototest.MakrScreens;
import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/10/13
 * Time: 3:53 PM
 * This screen is displayed when an order is confirmed.
 */
public class Makr_ShoppingCart_ConfirmOrder_Screen extends Makr_MenuBar_HeaderScreen {

    appElement ConfirmationNumber = new appElement("ConfirmationNumber", By.xpath("//window[1]/text[4]"));
    appElement BacktoHome = new appElement("BackToHome", By.xpath("//window[1]/button[9]"));

    List<appElement> ScreenElements;

    public Makr_ShoppingCart_ConfirmOrder_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(ConfirmationNumber);
        ScreenElements.add(BacktoHome);
    }

    public Makr_Home_Screen TapBackHome(){
        BacktoHome.tap();
        return new Makr_Home_Screen();
    }

}
