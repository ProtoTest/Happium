package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/11/13
 * Time: 7:06 PM
 * This represents the object that get's called when the menu "M" button is pressed from the HeaderScreen
 */
public class Makr_Menu_User_Screen extends appiumScreenBase {
    appElement LoginButton = new appElement("LoginButton", By.xpath("//window[1]/button[1]"));
    appElement AccountButton = new appElement("AccountButton", By.xpath("//window[1]/button[2]"));
    appElement AppSettingsButton = new appElement("AppSettingsButton", By.xpath("//window[1]/button[3]"));
    appElement HelpButton = new appElement("HelpButton", By.xpath("//window[1]/button[4]"));
    appElement TermsandConditionsButton = new appElement("TermsandCondsButton", By.xpath("//window[1]/button[5]"));


    List<appElement> MenuElements;
    private boolean loggedIn;

    public Makr_Menu_User_Screen(){
        InitList();
        VerifyContent(MenuElements);
        //addScreenHistory(new Makr_Menu_User_Screen());
    }

    private void InitList() {
        MenuElements = new ArrayList<appElement>();
        MenuElements.add(AppSettingsButton);
        MenuElements.add(HelpButton);
        MenuElements.add(TermsandConditionsButton);
    }

    public Makr_Menu_User_Account_screen tapAccountButton(){
        AccountButton.tap();
        return new Makr_Menu_User_Account_screen();
    }

    public Makr_Login_Screen tapLogin(){
        LoginButton.tap();
        return new Makr_Login_Screen();
    }
    public Makr_Menu_User_App_Settings tapAppSettings() {
        AppSettingsButton.tap();
        return new Makr_Menu_User_App_Settings();
    }
    public Makr_Menu_User_Help tapHelp() {
        HelpButton.tap();
        return new Makr_Menu_User_Help();
    }
    public Makr_Menu_User_Terms_Conditions tapTerms(){
        TermsandConditionsButton.tap();
        return new Makr_Menu_User_Terms_Conditions();
    }


    /* This stuff was removed in the latest version
    private void InitList_login() {
        //need to do a check here to see if the login button, or the logout button is present
        MenuElements = new ArrayList<appElement>();
        MenuElements.add(LoginButton);
        MenuElements.add(AccountSettings);
        //no longer present MenuElements.add(InviteFriends);
        MenuElements.add(TermsandConditions);
    }

    private void InitList_logout(){
        MenuElements = new ArrayList<appElement>();
        MenuElements.add(LogoutButton);
        MenuElements.add(AccountSettings);
        //No Longer Present MenuElements.add(InviteFriends);
        MenuElements.add(TermsandConditions);
    }

    public Makr_Login_Screen Login(){
        if(!loggedIn){
            LoginButton.tap();
        }
        return new Makr_Login_Screen();
    }  */


}
