package com.prototest.MakrTests;

import com.prototest.MakrScreens.*;
import com.prototest.appiumcore.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/7/13
 * Time: 12:51 PM
 * Navigation Tests
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Makr_Navigation_suite extends appiumTestBase {
    private String Username = "surban@prototest.com";
    private String Password = "happiest";

    @Test
    public void Nav_001_Login() {
        logFile.AddLog("Starting Test: Login");
        //Preconditions: user can't be logged in or this test will fail
        Makr_Home_Screen.StartMaker().tapUserMenu().tapLogin().emailLogin(Username, Password);
    }

    @Test
    public void Nav_002_Projects() {
        logFile.AddLog("Starting Test: Navigation Project");
       //This test checks the sidebar in Projects and Blog
       Makr_Home_Screen.StartMaker().tapProjectMenu().OpenSidebar();
    }


    @Test
    public void Nav_003_Blog(){
        logFile.AddLog("Starting Test: Navigation Blog");
        Makr_Home_Screen.StartMaker().tapBlog().Openblogsidebar();
    }

    @Test
    public void Nav_004_BlogView() {
        logFile.AddLog("Start Test: Blog View");
        //Verify that Blog tiles take the user to the appropriate blog entry and that users can navigate back and forth between the blog screen and the blog view.
        Makr_Home_Screen.StartMaker().tapBlog().SelectBlog(2);
    }

    @Test
    public void Nav_005_ProjectsMenu(){
        logFile.AddLog("Start Test: Navigation Projects Menu");
        //Verify that all the project menu items can be clicked and navigate to the appropriate screen
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().ProjectMenuNavigationLoopTest();
    }

    @Test
    public void Nav_006_CreateProject(){
        logFile.AddLog("Start Test: Create new project");
        //From here users can get to the shoppping cart tests
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().OpenFormatItem(1).SelectTemplateOne().CreateThis().MakeItem("");
    }

    @Test
    public void Nav_006_UserMenu_UserLoggedIn(){
        logFile.AddLog("Start Test: Navigation User Menu - User logged in");
        //Pre-Conditions: User needs to be logged in
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton().tapAppSettings().tapHelp().tapTerms();
    }

    @Test
    public void Nav_007_Logout() {
        logFile.AddLog("Start Test: Navigation Logout");
        //Preconditions: User must be logged in for this test to run
       Makr_Home_Screen.StartMaker().tapUserMenu().tapAccountButton().tapLogOut().tapYes();
    }

    @Test
    public void Nav_008_UserMenu_UserLoggedOut(){
        logFile.AddLog("Start Test: Navigation User Menu - User logged out");
        Makr_Home_Screen.StartMaker().tapUserMenu().tapAppSettings().tapHelp().tapTerms();
    }

  }
