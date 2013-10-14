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
public class Makr_Menu_User_App_Settings extends appiumScreenBase {
    //App Settings
    appElement Smartguidesswitch = new appElement("Smartguidesswitch",By.xpath("//window[1]/switch[1]"));
    appElement PushNotificationsswitch= new appElement("PushNotificationswitch",By.xpath("//window[1]/switch[2]"));


    List<appElement> ScreenElements;

    public Makr_Menu_User_App_Settings(){
        InitList();
        VerifyContent(ScreenElements);

    }


    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Smartguidesswitch);
        ScreenElements.add(PushNotificationsswitch);
}
    public void TapSmartguidesswitch() {
        Smartguidesswitch.tap();
    }
    public void TapPushNotificationsswtich() {
        PushNotificationsswitch.tap();
    }

}