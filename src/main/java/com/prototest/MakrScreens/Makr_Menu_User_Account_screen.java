package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
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
public class Makr_Menu_User_Account_screen extends Makr_MenuBar_HeaderScreen{
       //Makr_Menu_User_Account
       appElement Signed_in_as = new appElement("Signed_in_as",By.xpath("//window[1]/text[3]"));
       appElement OrderHistory = new appElement("OrderHistory",By.xpath("//window[1]/button[13]"));
       appElement MyPromoCodes = new appElement("MyPromoCodes",By.xpath("//window[1]/button[14]"));
       appElement ChangePassword = new appElement("ChangePassword",By.xpath("//window[1]/button[15]"));
       appElement LogOut = new appElement("LogOut",By.xpath("//window[1]/button[16]"));

       List<appElement> ScreenElements;

    public Makr_Menu_User_Account_screen(){
        InitList();
        VerifyContent(ScreenElements);

    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Signed_in_as);
        ScreenElements.add(OrderHistory);
        ScreenElements.add(MyPromoCodes);
        ScreenElements.add(ChangePassword);
        ScreenElements.add(LogOut);
        }
    public void TapOrderHistory() {
        OrderHistory.tap();
}

    public void TapMyPromoCodes() {
        MyPromoCodes.tap();
    }
    public void TapChangePassword() {
        ChangePassword.tap();
    }
    public void TapLogOut() {
        LogOut.tap();
    }



}