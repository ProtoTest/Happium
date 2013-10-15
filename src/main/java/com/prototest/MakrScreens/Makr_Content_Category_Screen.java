package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/27/13
 * Time: 2:29 PM
 * This screen is used to load content creation categories such as Baby, or Business
 */
public class Makr_Content_Category_Screen extends appiumScreenBase {
    appElement ScreenTitle = new appElement("ScreenTitle", By.xpath("//window[1]/text[2]"));
    appElement BackButton = new appElement("BackButton", By.xpath("//window[1]/button[8]"));

    appElement DesignTemplate = new appElement("DesignTemplate", By.xpath("//window[1]/UIACollectionView[1]"));
    List<appElement> ScreenElements;

    public Makr_Content_Category_Screen(){
        InitList();
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(ScreenTitle);
        ScreenElements.add(BackButton);

    }


    private void ScrollIntoView()
    {
        AppMainWindow.Swipe("DOWN");
    }

}
