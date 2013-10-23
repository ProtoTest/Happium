package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import com.prototest.appiumcore.appiumTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/15/13
 * Time: 12:33 PM
 * This is the login screen, displayed before the Main screen sometimes.
 */
public class Makr_Login_Screen extends appiumScreenBase {
    appElement usernameField = new appElement("UserNameField", By.tagName("UIATextField"));
    appElement PasswordField = new appElement("PasswordField", By.tagName("UIASecureTextField"));
    appElement LoginButton = new appElement("LoginButton", FindElement(452, 500));
    appElement NewUserButton = new appElement("RegisterButton", By.xpath("//window[1]/button[27]"));
    appElement FaceBookLogin = new appElement("FaceBook_Login", By.name("lgnFacebookLoginButton normal"));
    appElement ForgotPassword = new appElement("ForgotPassword", By.name("FORGOT PASSWORD"));





    List<appElement> ScreenElements;
    public Makr_Login_Screen(){
        InitList();
        VerifyContent(ScreenElements);
        //addScreenHistory(new Makr_Login_Screen());
        //AppMainWindow.tap();

    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(usernameField);
        ScreenElements.add(PasswordField);
        ScreenElements.add(LoginButton);
        ScreenElements.add(NewUserButton);
        ScreenElements.add(FaceBookLogin);
        ScreenElements.add(ForgotPassword);

    }

    public Makr_Home_Screen emailLogin(String username, String password){
        //AppMainWindow.tap(); //this needs to be done to get the login screen elements to be visible

        //usernameField.tapLoc(252, 420);

        usernameField.SendKeys(username);
        System.out.println(usernameField.GetLocation());
        PasswordField.SendKeys(password);
        //HideKeyboard.tap();
        LoginButton.tap();

        Makr_LoadingProject_Screen LoadingProjects = new Makr_LoadingProject_Screen();
        while(LoadingProjects.VerifyLoadingScreenPresent()){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return new Makr_Home_Screen();
    }




}
