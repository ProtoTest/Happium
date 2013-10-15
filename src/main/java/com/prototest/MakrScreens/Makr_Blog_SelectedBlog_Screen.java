package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumTestBase;
import org.openqa.selenium.By;
import com.prototest.appiumcore.appiumScreenBase;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/9/13
 * Time: 11:39 AM
 * Screen used when blog is selected from the Makr_Blog_screen
 */
public class Makr_Blog_SelectedBlog_Screen extends appiumScreenBase {

    appElement BackButton = new appElement("BackButton", By.name("makBackButton normal"));
    appElement Pinterest =new appElement("Pinterest", By.name("shrIconPinterest normal"));
    appElement Facebook = new appElement("Facebook", By.name("shrIconFacebook normal"));
    appElement Twitter = new appElement("Twitter", By.name("shrIconTwitter normal"));
    appElement Email = new appElement("Email", By.name("shrIconEmail normal"));
    appElement PostButton = new appElement("PostToSharing", By.name("Post"));

    List<appElement> ScreenElements;

    public Makr_Blog_SelectedBlog_Screen() {
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(BackButton);
        ScreenElements.add(Pinterest);
        ScreenElements.add(Facebook);
        ScreenElements.add(Twitter);
        ScreenElements.add(Email);

   }
   public void BackButton() {
       BackButton.tap();
   }
    /*  Right now we're unable to automated posting to any social media because Appium can't see into the post window for Pinterest, Facebook and Twitter
   public void Pinterest() {
       Pinterest.tap();
   }
   public void Facebook() {
       Facebook.tap();
       PostButton.tap();
   }
   public void Twitter() {
       Twitter.tap();
   }  */
   public Makr_emailSharing_Screen Email() {
       Email.tap();
       return new Makr_emailSharing_Screen();
   }

}
