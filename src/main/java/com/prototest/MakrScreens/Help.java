package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/2/13
 * Time: 1:41 PM
 *Account Maint. screen
 */
public class Help extends appiumScreenBase {
    //Help
    appElement Help = new appElement("Help",By.xpath("//windown[1]/button[4]"));
    appElement FAQs = new appElement("FAQs",By.xpath("//window[1]/button[12]"));
    appElement ContactUs = new appElement("ContactUs",By.xpath("//window[1]button[13]"));

    List<appElement> ScreenElements;

    public Help(){
        InitList();
        VerifyContent(ScreenElements);

    }


    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Help);

    }
}