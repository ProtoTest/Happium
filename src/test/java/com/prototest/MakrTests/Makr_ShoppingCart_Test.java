package com.prototest.MakrTests;

import com.prototest.appiumcore.*;
import com.prototest.MakrScreens.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/10/13
 * Time: 4:13 PM
 * Shopping cart tests will be stored here - make not of preconditions order should run from top to bottom
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Makr_ShoppingCart_Test extends appiumTestBase  {
    //Global Pre-conditions: User must be logged into the application as an email user


    private String Username = "surban@prototest.com";
    private String Password = "happiest";

    @Test
    public void Cart_001_EmptyShoppingCart(){
        logFile.AddLog("Starting Test: Verify Empty Shopping Cart");
        //Pre-conditions: User must be logged in first
        Makr_Home_Screen.StartMaker().ClickShoppingCart().BackHome();
    }

    @Test
    public void Cart_002_ShippingInformation(){
        //Pre-conditions: User must have previously non-ordered project in slot 1
        logFile.AddLog("Starting Test: Verify Shipping Information");
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrintsandProof().addZipCode("80123").tapCheckout(Password).EnterNewAddress("Seth",
                "Urban", "ProtoTest", "1999 Broadway", "suite 1410", "Denver","CO", "80202", "3039168683", "TestAddress").TapSaveBilling().TapContinue();
    }

    @Test
    public void Cart_003_SelectExistingAddress(){
        //The previous test must pass and there needs to be items in the shopping cart
        logFile.AddLog("Starting Test: Select Existing Address");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue();
    }

    @Test
    public void Cart_004_RemoveItemFromShoppingCart(){
        //Pre-Conditions: The previous test should pass with at least one item in the shopping cart
        logFile.AddLog("Starting Test: Remove Item from shopping cart");
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrintsandProof().tapProjectMenu().SelectProject(1).OrderPrintsandProof().VerifyExpectedItems(2).RemoveItemFromCart()
                .VerifyExpectedItems(1);
    }

    @Test
    public void Cart_005_PaymentMethodInvalidCC(){
        //Pre-Conditions: The previous Test needs to have passed, or at least have one item in the shopping cart at the start of the test
        logFile.AddLog("Starting Test: Payment Method invalid CreditCart");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).EnterNewAddress("ProtoTest", "TestUser", "ProtoTest", "1999 Broadway", "suite 1410", "Denver", "CO", "80001", "3039168683", "PT-TST-01")
                .TapContinue().ChangeShipping(3).ClickContinuetoPay().EnterCCInfo("0716", "4470452880033455", "999").EnterBillingInfo("1999 Broadway", "suite 1410", "Denver", "CO", "80202").KnownInvalidCC();
    }

    @Test
    public void Cart_006_PaymentMethodValidCC(){
        //Pre-Conditions: The previous test needs to have passed and at least have one item in the shopping cart
        //TODO in order to order with an actual CREDIT CARD we need to keep track of order confirmation numbers
        logFile.AddLog("Starting Test: Payment Method with VALID CreditCard");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).EnterNewAddress("ProtoTest", "TestUser", "ProtoTest", "1999 Broadway", "suite 1410", "Denver", "CO", "80001", "3039168683", "PT-TST-01")
                .TapSaveBilling().TapContinue().ChangeShipping(4).ClickContinuetoPay().EnterCCInfo("0716", "CREDIT CARD INFO", "9987").EnterBillingInfo("1999 Broadway", "suite 1410", "Denver", "CO", "80001").KnownValidCC();
    }

    @Test
    public void Cart_007_EditShippingAddressOnConfirmation(){
        //Pre-Conditions: The previous test needs to have passed but an order NOT be submitted.  This test requires an item be present in the shopping cart
        logFile.AddLog("Starting Test: Edit Address on Confirmation Screen");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinuetoPay().EnterCCInfo("0716", "4470452880033184", "996")
                .EnterCCInfo("0716", "CREDIT CARD INFO", "9987").EnterBillingInfo("1999 Broadway", "suite 1410", "Denver", "CO", "80001").KnownValidCC().EditShipping().EnterNewAddress("ProtoTest", "TestUser", "ProtoTest", "2000 Broadway", "", "Denver", "CO", "80202", "3039168683", "Edited From Confirmation Screen")
                .TapContinue().ClickContinuetoPay().KnownValidCC();
    }

    @Test
    public void Cart_008_EditPaymentInfoOnConfirmation(){
        //Pre-Conditions: There needs to be at least one item in the shopping cart
        logFile.AddLog("Starting Test: Edit Payment info on Confirmation screen");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinuetoPay().EnterCCInfo("0716", "4470452880033184", "996")
                .EnterCCInfo("0716", "CREDIT CARD INFO", "9987").EnterBillingInfo("1999 Broadway", "suite 1410", "Denver", "CO", "80001").KnownValidCC().EditBilling().EnterCCInfo("EXP", "CREDITCARD", "996")
                .KnownValidCC();

    }

    @Test
    public void Cart_009_CheckoutCreditCard(){
        //Pre-Conditions: There needs to be at least one item in the shopping cart
        logFile.AddLog("Starting Test: Checkout Credit Card Confirmation");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinuetoPay().EnterCCInfo("0715", "4388576054167617", "279")
                .EnterBillingInfo("1999 Broadway", "suite 1410", "Denver", "CO", "80202").KnownValidCC().ClickSubmit();
    }


    /*
    @Test
    public void Checkout(){
        logFile.AddLog("Starting Test: Shopping Cart Checkout");
        //Pre-conditions: User must have previously non-ordered project in slot 1
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrintsandProof().tapProjectMenu().SelectProject(1).OrderPrintsandProof().addPromoCode("ADMIN").addZipCode("80123")
                .RemoveItemFromCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinueToFinish().ClickSubmit().TapBackHome();

    } */

    @Test
    public void Cart_010_foo(){
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrintsandProof();
    }


}
