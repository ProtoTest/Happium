package com.prototest.MakrScreens;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/22/13
 * Time: 11:08 AM
 * This screen is displayed when the user first logs into the application
 */
public class Makr_LoadingProject_Screen extends appiumScreenBase {
    appElement LoadingText = new appElement("Loading Your Projects", By.xpath("//window[1]/text[2]"));

    public boolean VerifyLoadingScreenPresent(){
        boolean present;
        if(LoadingText.isDisplayed()){
            present = true;
        }
        else{
            present = false;
        }
        return present;
    }
}
