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

}
