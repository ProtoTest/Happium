package com.prototest.MakrTests;

import com.prototest.MakrScreens.*;
import com.prototest.appiumcore.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/16/13
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class New_Project_Create_Suite extends appiumTestBase {

    @Test
    public void New_Project_001() {
        logFile.AddLog("Start Test: Create new project");
        //Invitations
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(2).SelectTemplateOne().CreateThis().MakeItem("");
    }

    @Test
    public void New_Project_002() {
        logFile.AddLog("Start Test: Create new project");
        //Selects Announcements, Failing for unknown reason
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(3).SelectTemplateOne().CreateThis().MakeItem("");
    }

    @Test
    public void New_Project_003() {
        logFile.AddLog("Start Test: Create new project");
        //Place Cards
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(4).SelectTemplateOne().CreateThis().MakeItem("");
    }

    @Test
    public void New_Project_004() {
        logFile.AddLog("Start Test: Create new project");
        //Hang Tags
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(5).SelectTemplateOne().CreateThis().MakeItem("");
    }

    @Test
    public void New_Project_005() {
        logFile.AddLog("Start Test: Create new project");
        //Gift Tags
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(6).SelectTemplateOne().CreateThis().MakeItem("");
    }

    @Test
     public void New_Project_006() {
        logFile.AddLog("Start Test: Create new project");
        //Product Labels
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(7).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_007() {
        logFile.AddLog("Start Test: Create new project");
        //Mailing Labels, failing
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(8).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_008() {
        logFile.AddLog("Start Test: Create new project");
        //Return Address Labels
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(9).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_009() {
        logFile.AddLog("Start Test: Create new project");
        //Round Stickers
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(10).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_010() {
        logFile.AddLog("Start Test: Create new project");
        //Book Plates
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(11).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_011() {
        logFile.AddLog("Start Test: Create new project");
        //Bottle Labels
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(12).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_012() {
        logFile.AddLog("Start Test: Create new project");
        //Jar Labels
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(13).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_013() {
        logFile.AddLog("Start Test: Create new project");
        //Wine Labels, Fails, never hits wine label in list
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(14).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_014() {
        logFile.AddLog("Start Test: Create new project");
        //Size 3 1/2" x 2
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(1).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_015() {
        logFile.AddLog("Start Test: Create new project");
        //Size 5 1/2" x 4 1/4"
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(2).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_016() {
        logFile.AddLog("Start Test: Create new project");
        //Size 5" x 7"
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(3).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_017() {
        logFile.AddLog("Start Test: Create new project");
        //Size 3 1/2" x 4"
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(4).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_018() {
        logFile.AddLog("Start Test: Create new project");
        //Size 2 5/8 x 1"
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(5).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_019() {
        logFile.AddLog("Start Test: Create new project");
        //Size 2" x 2"
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(6).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_020() {
        logFile.AddLog("Start Test: Create new project");
        //Size 3 1/2" x 5"
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(7).SelectTemplateOne().CreateThis().MakeItem("");
    }
    @Test
    public void New_Project_021() {
        logFile.AddLog("Start Test: Create new project");
        //Size 3 1/2" x 2"
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenSizeItem(8).SelectTemplateOne().CreateThis().MakeItem("");
    }

}
