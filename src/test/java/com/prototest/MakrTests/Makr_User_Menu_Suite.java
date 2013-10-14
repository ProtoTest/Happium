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
    public void AppSettings() {
        Makr_Home_Screen.StartMaker().OpenUserMenu().tapAppSettings();
    }
}
