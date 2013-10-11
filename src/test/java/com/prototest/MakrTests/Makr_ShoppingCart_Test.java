package com.prototest.MakrTests;

import com.prototest.appiumcore.*;
import com.prototest.MakrScreens.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/10/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Makr_ShoppingCart_Test extends appiumTestBase  {

    @Test
    public void VerifyEmptyShoppingCart(){
        //Pre-conditions: User must be logged in first
        Makr_Home_Screen.StartMaker().ClickShoppingCart().BackHome();
    }

    @Test
    public void Checkout(){
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrints().VerifyItemsMatchCartIcon().addPromoCode("ADMIN").addZipCode("80123").RemoveItemFromCart();
    }

    @Test
    public void foo(){
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1);
    }


}
