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
public class Makr_Menu_User_Terms_Conditions extends Makr_Menu_User_Screen {
    //Terms & Conditions
    appElement Terms = new appElement("Terms",By.xpath("//window[1]/button[5]"));
    appElement TermsService = new appElement("TermsService",By.xpath("//window[1]/button[12]"));
    appElement Shipping = new appElement("Shipping",By.xpath("//window[1]/button[13]"));
    appElement Returns = new appElement("Returns",By.xpath("//window[1]/button[14]"));
    appElement PrivatePolicy = new appElement("PrivatePolicy",By.xpath("//window[1]/button[15]"));


    List<appElement> ScreenElements;

    public Makr_Menu_User_Terms_Conditions(){
        InitList();
        VerifyContent(ScreenElements);

    }


    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Terms);
        ScreenElements.add(TermsService);
        ScreenElements.add(Shipping);
        ScreenElements.add(Returns);
        ScreenElements.add(PrivatePolicy);
    }
    public void TapTerms() {
        Terms.tap();
    }
    public void TapTermsService() {
        TermsService.tap();
    }
    public void TapShipping() {
        Shipping.tap();
    }
    public void TapReturns() {
        Returns.tap();
    }
    public void TapPrivatePolicy() {
        PrivatePolicy.tap();
    }



}

