package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/14/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Makr_Avery_PrinterAlignment_Screen extends Makr_Menu_User_App_Settings {

    appElement CloseButton = new appElement("CloseButton", By.xpath("//window[1]/button[6]"));
    appElement ArrowUp = new appElement("ArrowUp", By.xpath("//window[1]/button[7]"));
    appElement ArrowLeft = new appElement("ArrowLeft", By.xpath("//window[1]/button[8]"));
    appElement ArrowRight = new appElement("ArrowRight", By.xpath("window[1]/button[9]"));
    appElement ArrowDown = new appElement("ArrowDown", By.xpath("window[1]/button[10]"));
    appElement Readjust = new appElement("Readjust", By.xpath("//window[1]/button[11]"));

    List<appElement> ScreenElements;

    public Makr_Avery_PrinterAlignment_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(CloseButton);
        ScreenElements.add(ArrowUp);
        ScreenElements.add(ArrowLeft);
        ScreenElements.add(ArrowRight);
        ScreenElements.add(ArrowDown);
        ScreenElements.add(Readjust);
    }

    public Makr_Avery_PrinterAlignment_Screen Taparrow(int Numofpresses){
        for(int i=0; i < Numofpresses; i++)
        ArrowUp.tap();
        return this;
    }


    public Makr_Menu_User_App_Settings CloseButton() {
        CloseButton.tap();
        return new Makr_Menu_User_App_Settings();
    }
    public void ArrowUp() {
        ArrowUp.tap();;
    }
    public void ArrowLeft() {
        ArrowLeft.tap();
    }
    public void ArrowRight() {
        ArrowRight.tap();
    }
    public void ArrowDown () {
        ArrowDown.tap();
    }

    }







