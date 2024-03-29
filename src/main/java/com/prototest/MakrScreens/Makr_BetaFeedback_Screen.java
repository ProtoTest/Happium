package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;

import org.junit.Assert;
import org.openqa.selenium.By;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/12/13
 * Time: 10:20 AM
 * This is the screen that is displayed when the user clicks the beta feedback button
 */

/*
THIS SCREEN WAS REMOVED
 */
public class Makr_BetaFeedback_Screen extends appiumScreenBase {
    appElement CancelButton = new appElement("Cancel Button", By.name("Cancel"));
    appElement SendButton = new appElement("SendButton", By.name("Send"));
    appElement GiveFeedback = new appElement("GiveFeedBack_text", By.name("Give Feedback"));
    appElement LetusKnow_Txt = new appElement("LetUsKnow_Text", By.xpath("//window[1]/scrollview[1]/text[1]"));
    appElement FeedBackText = new appElement("FeedBack_TextView", By.xpath("//window[1]/scrollview[1]/textview[1]"));
    //Thanks Alert
    appElement ThanksText = new appElement("Thanks", By.name("Thanks!"));
    appElement ConfirmText = new appElement("ConfirmText", By.xpath("//window[4]/alert[1]/text[2]"));
    appElement CloseButton = new appElement("CloseButton", By.name("Close"));
    appElement ViewMessageButton = new appElement("ViewMessages", By.name("View Messages"));

    List<appElement> ScreenElements;

    public Makr_BetaFeedback_Screen(){
        InitList();
        VerifyContent(ScreenElements);
        //addScreenHistory(new Makr_BetaFeedback_Screen());
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(CancelButton);
        ScreenElements.add(SendButton);
        ScreenElements.add(GiveFeedback);
        ScreenElements.add(LetusKnow_Txt);
        ScreenElements.add(FeedBackText);
    }

    public void setFeedBackText(String feedback){
        FeedBackText.SendKeys(feedback);
        SendButton.tap();
        ThanksText.verifyPresent();
        Assert.assertEquals(ConfirmText.getText(), "Your response has been saved in this app's Message Center, where you may get a reply from us.");
        CloseButton.tap();
    }
}
