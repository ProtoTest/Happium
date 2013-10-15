package com.prototest.MakrScreens;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/15/13
 * Time: 2:52 PM
 * This screen is used when sharing via email to other users.
 */
public class Makr_emailSharing_Screen extends appiumScreenBase {
    //This was created using the share blog post -- This is the same email screen layout that sharing content uses
    appElement CancelEmailButton = new appElement("CancelEmail", By.xpath("//window[1]/navigationBar[1]/button[2]"));
    appElement Cancel_DeleteDraft = new appElement("Cancel_DeleteDraft", By.xpath("//window[1]/popover[1]/actionsheet[1]/button[2]"));
    appElement Cancel_SaveDraft = new appElement("Cancel_SaveDraft", By.xpath("//window[1]/popover[1]/actionsheet[1]/button[3]"));

    appElement SendEmailButton = new appElement("SendEmail", By.xpath("//window[1]/navigationBar[1]/button[3]"));
    appElement EmailTitle = new appElement("EmailTitle", By.xpath("//window[1]/navigationBar[1]/text[1]"));

    //Email address fields
    appElement ToField = new appElement("ToField", By.xpath("//window[1]/scrollview[2]/textfield[1]"));
    appElement CCField = new appElement("CCField", By.xpath("//window[1]/scrollview[2]/text[7]"));
    appElement SubjectField = new appElement("SubjectField", By.xpath("//window[1]/scrollview[2]/textfield[4]"));
    appElement MessageBodyField = new appElement("MessageBodyField", By.xpath("/window[1]/scrollview[2]/textview[1]"));

    List<appElement> EmailItems;

    public Makr_emailSharing_Screen(){
        InitList();
        VerifyContent(EmailItems);
    }

    private void InitList() {
        EmailItems = new ArrayList<appElement>();
        EmailItems.add(CancelEmailButton);
        EmailItems.add(SendEmailButton);
        EmailItems.add(EmailTitle);
        EmailItems.add(ToField);
        EmailItems.add(CCField);
        EmailItems.add(SubjectField);
        EmailItems.add(MessageBodyField);
    }

    public void ToAddress(String toAddress){
        //This will not check the format
        ToField.SendKeys(toAddress);
    }
    public void CCAddress(String ccAddress){
        //This will not check the format of the address entered
        CCField.SendKeys(ccAddress);
    }
    public void ChangeSubject(String subject){
        SubjectField.SendKeys(subject);
    }
    public void EnterEmailMessage(String message){
        MessageBodyField.SendKeys(message);
    }
    public void CancelandDelete(){
        CancelEmailButton.tap();
        Cancel_DeleteDraft.tap();
    }
    public void CancelandSave(){
        CancelEmailButton.tap();
        Cancel_SaveDraft.tap();
    }




}
