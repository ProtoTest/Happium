package com.prototest.MakrTests;

import com.prototest.MakrScreens.*;
import com.prototest.appiumcore.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/14/13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Makr_User_Menu_Suite extends appiumTestBase {
    private String oldPass = "happier";
    private String ShortPass = "1234";
    private String newPass = "Happiest";

    @Test
    public void User_001_AccountSettings(){
        //Need to build functions for Order History, May Avail Promo codes, and Change PW
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton();
    }

    @Test
    public void User_002_ChangePassword_NewShort(){
        //Need to be logged in as a non-facebook user
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton().tapChangePassword(oldPass, oldPass, ShortPass, ShortPass, "here's a hint");
    }

    @Test
    public void User_003_ChangePassword_NoMatch(){
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton().tapChangePassword(oldPass, oldPass, newPass, "Thisdontmatch", "passwords don't match");
    }

    @Test
    public void User_004_ChangePassword_WrongOld(){
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton().tapChangePassword("WRONGOLDPASS", oldPass, newPass, newPass, "Old password is wrong");
    }

    @Test
    public void User_005_ChangePassword_BlankOld(){
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton().tapChangePassword("", oldPass, newPass, newPass, "Blank old password");
    }

    @Test
    public void User_006_ChangePassword_Forrealzies(){
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton().tapChangePassword(oldPass, oldPass, newPass, newPass, "This will change");
    }

    @Test
    public void User_007_Appsettings() {
        //Need to add functions for Restore Purchases and Avery Print Alignment
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAppSettings().TapSmartguidesswitch().TapPushNotificationsswtich();
    }

    @Test
    public void User_008_Help() {
        //Opens Help screen, Then opens FAQ
        Makr_Home_Screen.StartMaker().tapUserMenu().tapHelp().OpenFAQs();
    }

}
