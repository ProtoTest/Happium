package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumTestBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/9/13
 * Time: 11:39 AM
 * Screen used when blog is selected from the Makr_Blog_screen
 */
public class Makr_Blog_SelectedBlog_Screen extends appiumTestBase {

    appElement BackButton = new appElement("BackButton", By.name("makBackButton normal"));
    appElement Pinterest =new appElement("Pinterest", By.name("shriconPinterest normal"));
    appElement Facebook = new appElement("Facebook", By.name("shriconFacebook normal"));
    appElement Twitter = new appElement("Twitter", By.name("shriconTwitter normal"));
    appElement Email = new appElement("Email", By.name("shriconEmail normal"));

    List<appElement> ScreenElements;

    public Makr_Blog_SelectedBlog_Screen() {
        InitList();

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
   public void Pinterest() {
       Pinterest.tap();
   }
   public void Facebook() {
       Facebook.tap();
   }
   public void Twitter() {
       Twitter.tap();
   }
   public void Email() {
       Email.tap();
   }

}
