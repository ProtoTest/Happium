package com.prototest.MakrTests;

import com.prototest.MakrScreens.Makr_Blog_Screen;
import com.prototest.MakrScreens.Makr_Home_Screen;
import com.prototest.MakrScreens.Makr_Menu_User_Account_screen;
import com.prototest.appiumcore.appiumTestBase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/7/13
 * Time: 12:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Makr_Navigation_suite extends appiumTestBase {

    @Test
    public void Login() {
        //Preconditions: user can't be logged in or this test will fail
        Makr_Home_Screen.StartMaker().OpenUserMenu().tapLogin().emailLogin("surban@prototest.com", "happier!");
    }

    @Test
    public void Logout() {
       Makr_Home_Screen.StartMaker().OpenMenu().tapAccountButton().TapLogOut();
    }

}
