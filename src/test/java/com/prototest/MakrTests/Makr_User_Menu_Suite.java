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

    @Test
    public void AccountSettings(){
        //Need to build functions for Order History, May Avail Promo codes, and Change PW
        Makr_Home_Screen.StartMaker().OpenUserMenu().tapAccountButton();
    }

    @Test
    public void Appsettings() {
        //Need to add functions for Restore Purchases and Avery Print Alignment
        Makr_Home_Screen.StartMaker().OpenUserMenu().tapAppSettings().TapSmartguidesswitch().TapPushNotificationsswtich();
    }

    @Test
    public void Help() {
        //Opens Help screen, Then opens FAQ
        Makr_Home_Screen.StartMaker().OpenUserMenu().tapHelp().OpenFAQs();
    }

}
