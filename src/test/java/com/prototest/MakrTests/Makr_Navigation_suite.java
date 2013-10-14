package com.prototest.MakrTests;

import com.prototest.MakrScreens.*;
import com.prototest.appiumcore.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/7/13
 * Time: 12:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Makr_Navigation_suite extends appiumTestBase {

    @Test
    public void Login() {
        //Preconditions: user can't be logged in or this test will fail
        Makr_Home_Screen.StartMaker().OpenUserMenu().tapLogin().emailLogin("chancock@prototest.com", "happy!");
    }

    @Test
    public void Sidebar() {
       //This test checks the sidebar in Projects and Blog
       Makr_Home_Screen.StartMaker().tapProjectMenu().OpenSidebar().OpenBlog().Openblogsidebar();
    }

    @Test
    public void BlogView() {
        //Verify that Blog tiles take the user to the appropriate blog entry and that users can navigate back and forth between the blog screen and the blog view.
        Makr_Home_Screen.StartMaker().OpenBlog().SelectedBlog(2).BackButton();
    }

    @Test
    public void Logout() {
        //Preconditions: User must be logged in for this test to run
       Makr_Home_Screen.StartMaker().OpenMenu().tapAccountButton().TapLogOut().TapYes();
    }

  }
