package com.prototest.MakrScreens;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/15/13
 * Time: 4:18 PM
 * This is the screen displayed to the user before they select the item template they want to create
 */
public class Makr_Content_TemplatePreview_Screen extends Makr_MenuBar_HeaderScreen {

    //This is the bare bones screen needed to create a project
    appElement ItemType = new appElement("ItemType", By.xpath("//window[1]/text[2]"));
    appElement OtherFormats = new appElement("OtherFormats", By.xpath("//window[1]/text[3]"));
    appElement BackButton = new appElement("BackButton", By.xpath("//window[1]/button[8]"));

    appElement CreateThisButton = new appElement("CreateThisButton", By.xpath("//window[1]/button[9]"));
    appElement InfoButton = new appElement("InfoButton", By.xpath("//window[1]/button[10]"));

    List<appElement> ScreenElements;

    public Makr_Content_TemplatePreview_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(ItemType);
        ScreenElements.add(OtherFormats);
        ScreenElements.add(BackButton);
        ScreenElements.add(CreateThisButton);
        ScreenElements.add(InfoButton);
    }

    public Makr_Content_Creation_Screen CreateThis(){
        CreateThisButton.tap();
        return new Makr_Content_Creation_Screen();
    }

}
