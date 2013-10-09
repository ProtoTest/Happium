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
public class Terms_Conditions extends appiumScreenBase {
    //Terms & Conditions
    appElement Terms = new appElement("Terms",By.xpath("//window[1]/button[5]"));


    List<appElement> ScreenElements;

    public Terms_Conditions(){
        InitList();
        VerifyContent(ScreenElements);

    }


    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Terms);
    }
}

