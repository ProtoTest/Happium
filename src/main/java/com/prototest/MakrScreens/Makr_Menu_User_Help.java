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
 *Makr_Menu_User_Account Maint. screen
 */
public class Makr_Menu_User_Help extends appiumScreenBase {
    //Makr_Menu_User_Help
    appElement Help = new appElement("Makr_Menu_User_Help",By.xpath("//windown[1]/button[4]"));
    appElement FAQs = new appElement("FAQs",By.xpath("//window[1]/button[12]"));
    appElement ContactUs = new appElement("ContactUs",By.xpath("//window[1]button[13]"));

    List<appElement> ScreenElements;

    public Makr_Menu_User_Help(){
        InitList();
        VerifyContent(ScreenElements);

    }


    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Help);

    }
}