package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/27/13
 * Time: 8:35 PM
 * This screen is used to create some content
 */
public class Makr_Content_Creation_Screen extends appiumScreenBase {
    //TODO finish the sub-menus for art and text
    //This is actually on the screen before this screen -- this is the button to get to the content screen
    appElement SelectTemplate = new appElement("SelectTemplate", By.xpath("//window[1]/button[9]"));

    appElement UserMenu = new appElement("UserMenu", By.xpath("//window[1]/button[1]"));
    appElement CloseButton = new appElement("CloseButton", By.name("CLOSE"));
    appElement SaveButton = new appElement("SaveButton", By.name("SAVE"));
    appElement MakeButton = new appElement("MakeButton", By.name("make!"));

    appElement ProjectTitle = new appElement("ProjectTitle", By.xpath("//window[1]/textfield[1]"));
    appElement ProjectTitle_Clear = new appElement("ProjectTitle_Clear", By.xpath("/window[1]/textfield[1]/button[1]"));
    appElement ProjectOk = new appElement("ProjectOK", By.xpath("//window[1]/button[1]"));


    appElement UndoButton = new appElement("UndoButton", By.xpath("//window[1]/button[5]"));
    appElement RedoButton = new appElement("RedoButton", By.xpath("//window[1]/button[6]"));

    appElement CreationTitle = new appElement("CreationTitle", By.xpath("//window[1]/text[2]"));
    appElement FrontButton = new appElement("FrontButton", By.name("FRONT"));
    appElement BackButton = new appElement("BackButton", By.name("BACK"));

    appElement addText = new appElement("AddText", By.xpath("//window[1]/button[9]"));
    appElement addArt = new appElement("addArt", By.xpath("//window[1]/button[9]"));

    List<appElement> ScreenElements;

    public Makr_Content_Creation_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(UserMenu);
        ScreenElements.add(CloseButton);
        ScreenElements.add(SaveButton);
        ScreenElements.add(MakeButton);
        ScreenElements.add(UndoButton);
        ScreenElements.add(RedoButton);
        ScreenElements.add(CreationTitle);
        ScreenElements.add(addArt);
        ScreenElements.add(addText);
    }

    public Makr_Menu_User_Screen tapUsermenu(){
        UserMenu.tap();
        return new Makr_Menu_User_Screen();
    }

    public Makr_Projects_SelectedProject_Screen MakeItem(String itemname){
        MakeButton.tap();
        if(itemname != ""){
            ProjectTitle_Clear.tap();
            ProjectTitle.SendKeys(itemname);
        }
        ProjectOk.tap();
        return new Makr_Projects_SelectedProject_Screen();
    }



}
