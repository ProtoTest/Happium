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
    private String Username = "chancock@prototest.com";
    private String Password = "happy!";

    @Test
    public void Nav_001_Login() {
        //Preconditions: user can't be logged in or this test will fail
        Makr_Home_Screen.StartMaker().OpenUserMenu().tapLogin().emailLogin(Username, Password);
    }

    @Test
    public void Nav_002_Sidebar() {
       //This test checks the sidebar in Projects and Blog
       Makr_Home_Screen.StartMaker().tapProjectMenu().OpenSidebar().OpenBlog().Openblogsidebar();
    }

    @Test
    public void Nav_003_BlogView() {
        //Verify that Blog tiles take the user to the appropriate blog entry and that users can navigate back and forth between the blog screen and the blog view.
        //TODO fix this test
        Makr_Home_Screen.StartMaker().OpenBlog().SelectedBlog(2).BackButton();
    }

    @Test
    public void Nav_004_ProjectsMenu(){
        //Verify that all the project menu items can be clicked and navigate to the appropriate screen
        Makr_Home_Screen.StartMaker().tapNewProjectMenu().ProjectMenuNavigationLoopTest();
    }

    @Test
    public void Nav_005_Logout() {
        //Preconditions: User must be logged in for this test to run
       Makr_Home_Screen.StartMaker().OpenMenu().tapAccountButton().TapLogOut().TapYes();
    }

  }
