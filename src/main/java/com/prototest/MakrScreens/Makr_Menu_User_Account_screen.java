package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import org.junit.Assert;
import org.junit.Assert.*;
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
public class Makr_Menu_User_Account_screen extends Makr_Menu_User_Screen{
    //Makr_Menu_User_Account
    appElement Signed_in_as = new appElement("Signed_in_as",By.xpath("//window[1]/text[3]"));
    appElement OrderHistory = new appElement("OrderHistory",By.xpath("//window[1]/button[13]"));
    appElement MyPromoCodes = new appElement("MyPromoCodes",By.xpath("//window[1]/button[14]"));
    appElement ChangePassword = new appElement("ChangePassword",By.xpath("//window[1]/button[15]"));
    appElement LogOut = new appElement("LogOut",By.xpath("//window[1]/button[16]"));
    appElement BackToAccount = new appElement("BackToAccount", By.xpath("//window[1]/button[13]"));

    //Log out confirmation pop-up
    appElement Cancel = new appElement("Cancel",By.name("CANCEL"));
    appElement Yes = new appElement("Yes",By.name("YES"));

    //ChangePassword Popup
    appElement oldPassword = new appElement("oldPassword", By.xpath("//window[1]/secure[1]"));
    appElement NewPassword1 = new appElement("NewPassword1", By.xpath("//window[1]/secure[2]"));
    appElement NewPassword2 = new appElement("NewPassword2", By.xpath("//window[1]/secure[3]"));
    appElement NewPasswordHint = new appElement("New Password Hint", By.xpath("//window[1]/textfield[1]"));
    appElement CancelChangePass = new appElement("CancelChangePassword", By.xpath("//window[1]/button[7]"));
    appElement ChangePassButton = new appElement("ChangePasswordButton", By.xpath("//window[1]/button[8]"));

    //ChangePassword Expected errors
    appElement OkButtonError = new appElement("OKButton", By.xpath("//window[3]/image[2]/button[1]"));
    appElement OkButtonSuccess = new appElement("OkButton", By.xpath("//window[3]/image[1]/button[1]"));
    private String errorTextLocator = "//window[3]/image[1]/text[1]";
    appElement newPasswordToShort = new appElement("New password is too short!", By.xpath(errorTextLocator));
    appElement OldPasswordIncorrect = new appElement("Old password is incorrect", By.xpath(errorTextLocator));
    appElement PasswordsDontMatch = new appElement("Passwords don't match!", By.xpath(errorTextLocator));
    appElement OldPasswordMissing = new appElement("Please enter your old password.", By.xpath(errorTextLocator));
    appElement CantChangeFacebooKPassword = new appElement("You cannot change your password if you signed in with Facebook", By.xpath(errorTextLocator));
    appElement SuccessfulChange = new appElement("Your password has been changed.", By.xpath("/window[3]/image[1]/text[1]"));



    List<appElement> ScreenElements;

    public Makr_Menu_User_Account_screen(){
        InitList();
        VerifyContent(ScreenElements);

    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Signed_in_as);
        ScreenElements.add(OrderHistory);
        ScreenElements.add(MyPromoCodes);
        ScreenElements.add(ChangePassword);
        ScreenElements.add(LogOut);
        ScreenElements.add(Cancel);
        ScreenElements.add(Yes);
        }
    public void tapOrderHistory() {
        OrderHistory.tap();
        BackToAccount.tap();
    }

    public void tapMyPromoCodes() {
        MyPromoCodes.tap();
        BackToAccount.tap();
    }
    public void tapChangePassword(String oldpass, String expectedOld, String newpass1, String newpass2, String hint) {
        ChangePassword.tap();
        if(CantChangeFacebooKPassword.isDisplayed()){
            //TODO need to add some check to see if we logged in as a facebook user
        }
        if(oldPassword.isDisplayed()){
            //These are the expected error messages there will need to be a test created for each circumstance
            if((newpass1.length() < 5) && (oldpass.length() > 0))
            {
                //Expect to see a new password to short message
                enterChangePasswordInfo(oldpass, newpass1, newpass2);

                if(newPasswordToShort.isDisplayed()){
                    Assert.assertTrue("Verify Change Password is to short message is displayed", newPasswordToShort.isDisplayed());
                    Assert.assertEquals(newPasswordToShort.GetElementName(), newPasswordToShort.GetAttribute("value"));
                }
                else{
                    Assert.fail("New Password to short message was not displayed as expected");
                }
            }
            if((newpass1 != newpass2) && (oldpass.length() > 0))
            {
                enterChangePasswordInfo(oldpass, newpass1, newpass2);
                if(PasswordsDontMatch.isDisplayed()){
                    Assert.assertTrue("Passwords Don't match error is displayed", PasswordsDontMatch.isDisplayed());
                    Assert.assertEquals(PasswordsDontMatch.GetElementName(), PasswordsDontMatch.GetAttribute("value"));
                }
                else{
                    Assert.fail("Passwords don't match message was not displayed as expected!");
                }
            }
            if((oldpass != expectedOld) && (oldpass.length() > 0)){
                //This test counts on the Tester entering the expected old password correctly
                enterChangePasswordInfo(oldpass, newpass1, newpass2);
                if(OldPasswordIncorrect.isDisplayed()){
                    Assert.assertTrue("Old password incorrect message is displayed", OldPasswordIncorrect.isDisplayed());
                    Assert.assertEquals(OldPasswordIncorrect.GetElementName(), OldPasswordIncorrect.GetAttribute("value"));
                }
                else{
                    Assert.fail("Old password's dont' match message was not displayed as expected!");
                }
            }
            if(oldpass == ""){
                enterChangePasswordInfo(oldpass, newpass1, newpass2);
                if(OldPasswordMissing.isDisplayed()){
                    Assert.assertTrue("Old Password Missing message is displayed", OldPasswordMissing.isDisplayed());
                    Assert.assertEquals(OldPasswordMissing.GetElementName(), OldPasswordMissing.GetAttribute("value"));
                }
                else{
                    Assert.fail("Old password missing message was not dispalyed as expected!");
                }
            }
            if((oldpass == expectedOld) && (newpass1 == newpass2) && (newpass1.length() > 5)){
                //This make sure that the new password will be changed correctly
                enterChangePasswordInfo(oldpass, newpass1, newpass2);
                if(SuccessfulChange.isDisplayed()){
                    Assert.assertTrue("Password changes message is displayed correctly", SuccessfulChange.isDisplayed());
                    Assert.assertEquals(SuccessfulChange.GetElementName(), SuccessfulChange.GetAttribute("value"));
                }
                else{
                    Assert.fail("Password change success message was not displayed as expected!");
                }
            }
            //These statements will tap the OK button on the error messages or the confirmation message
            if(OkButtonError.isDisplayed()){
                OkButtonError.tap();
            }
            else{
                OkButtonSuccess.tap();
            }
        }else{
            Assert.fail("Tapping change password button does not present change password popup");
        }
    }
    private void enterChangePasswordInfo(String oldpass, String newpass1, String newpass2){
        //function used for If statements in changepassword function
        oldPassword.SendKeys(oldpass);
        NewPassword1.SendKeys(newpass1);
        NewPassword2.SendKeys(newpass2);
        ChangePassButton.tap();
    }
    public Makr_Menu_User_Account_screen tapLogOut() {
        LogOut.tap();
        return this;
    }
    public void tapCancel() {
        Cancel.tap();
    }
    public Makr_Menu_User_Account_screen tapYes() {
        Yes.tap();
        return this;
    }




}