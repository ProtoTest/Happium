package com.prototest.MakrTests;

import com.prototest.appiumcore.*;
import com.prototest.MakrScreens.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/10/13
 * Time: 4:13 PM
 * Shopping cart tests will be stored here - make not of preconditions order should run from top to bottom
 */
public class Makr_ShoppingCart_Test extends appiumTestBase  {

    @Test
    public void VerifyEmptyShoppingCart(){
        logFile.AddLog("Starting Test: Verify Empty Shopping Cart");
        //Pre-conditions: User must be logged in first
        Makr_Home_Screen.StartMaker().ClickShoppingCart().BackHome();
    }

    @Test
    public void Checkout(){
        logFile.AddLog("Starting Test: Shopping Cart Checkout");
        //Pre-conditions: User must have previously non-ordered project in slot 1
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrintsandProof().tapProjectMenu().SelectProject(1).OrderPrintsandProof().addPromoCode("ADMIN").addZipCode("80123")
                .RemoveItemFromCart().tapCheckout("happier").SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinueToFinish().ClickSubmit().TapBackHome();

    }

    @Test
    public void foo(){
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrintsandProof();
    }


}
