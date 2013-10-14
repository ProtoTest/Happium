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
public class Makr_Menu_User_Help extends Makr_Menu_User_Screen {
    //Makr_Menu_User_Help
    appElement Help = new appElement("Makr_Menu_User_Help",By.xpath("//windown[1]/button[4]"));
    appElement FAQs = new appElement("FAQs",By.xpath("//window[1]/button[13]"));
    appElement ContactUs = new appElement("ContactUs",By.xpath("//window[1]button[14]"));
    //FAQs Sub Screen
    appElement FirstTopic = new appElement("FirstTopic",By.xpath("//window[1]/button[14]"));
    appElement SecondTopic = new appElement("SecondTopic",By.xpath("//window{1}/button[15]"));
    appElement ThirdTopic = new appElement("ThirdTopic",By.xpath("//window[1]/button[16]"));

    List<appElement> ScreenElements;
    List<appElement> FAQElements;

    public Makr_Menu_User_Help(){
        InitList();
        VerifyContent(ScreenElements);

    }


    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Help);
        ScreenElements.add(FAQs);
        ScreenElements.add(ContactUs);
        FAQElements = new ArrayList<appElement>();
        FAQElements.add(FirstTopic);
        FAQElements.add(SecondTopic);
        FAQElements.add(ThirdTopic);
    }
    public void TapHelp() {
        Help.tap();
    }
    public Makr_Menu_User_Help OpenFAQs() {
        FAQs.tap();
        FirstTopic.verifyPresent();
        SecondTopic.verifyPresent();
        ThirdTopic.verifyPresent();
        return this;
    }
    public void TapContactUs() {
        ContactUs.tap();
    }
    public void TapFirstTopic() {
        FirstTopic.tap();
    }
    public void TapSecondTopic() {
        SecondTopic.tap();
    }
    public void TapThirdTopic() {
        ThirdTopic.tap();
    }
}