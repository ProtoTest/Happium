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
    private String FirstName = "";
    private String LastName = "";

    private String ValidCCName = "";
    private String validCC = "";
    private String validExpirey = "";
    private String validCCV = "";

    private String invalidCCName = "";
    private String invalidCC = "";
    private String invalidExpirey = "";
    private String invalidCCV = "";

    private String Address1 = "";
    private String Address2 = "";
    private String City = "";
    private String State = "";
    private String Zip = "";
    private String Phone = "";

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
        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(1).OrderPrintsandProof().addZipCode(Zip).tapCheckout(Password).EnterNewAddress(FirstName,
                LastName, "ProtoTest", Address1, Address2, City, State, Zip, Phone, "TestAddress").TapSaveBilling().TapContinue();
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
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).EnterNewAddress("ProtoTest", "TestUser", "ProtoTest", Address1, Address2, City, State, Zip, Phone, "PT-TST-01")
                .TapContinue().ChangeShipping(3).ClickContinuetoPay().EnterCCInfo(invalidExpirey, invalidCC, invalidCCV).EnterBillingInfo(Address1, Address2, City, State, Zip).KnownInvalidCC();
    }

    @Test
    public void Cart_006_PaymentMethodValidCC(){
        //Pre-Conditions: The previous test needs to have passed and at least have one item in the shopping cart
        //TODO in order to order with an actual CREDIT CARD we need to keep track of order confirmation numbers
        logFile.AddLog("Starting Test: Payment Method with VALID CreditCard");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).EnterNewAddress("ProtoTest", "TestUser", "ProtoTest", Address1, Address2, City, State, Zip, Phone, "PT-TST-01")
                .TapSaveBilling().TapContinue().ChangeShipping(4).ClickContinuetoPay().EnterCCInfo(validExpirey, validCC, validCCV).EnterBillingInfo(Address1, Address2, City, State, Zip).KnownValidCC();
    }

    @Test
    public void Cart_007_EditShippingAddressOnConfirmation(){
        //Pre-Conditions: The previous test needs to have passed but an order NOT be submitted.  This test requires an item be present in the shopping cart
        logFile.AddLog("Starting Test: Edit Address on Confirmation Screen");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinuetoPay().EnterCCInfo(validExpirey, validCC, validCCV)
                .EnterBillingInfo(Address1, Address2, City, State, Zip).KnownValidCC().EditShipping().EnterNewAddress("ProtoTest", "TestUser", "ProtoTest", "2000 Broadway", "", "Denver", "CO", "80202", "3039168683", "Edited From Confirmation Screen")
                .TapContinue().ClickContinuetoPay().KnownValidCC();
    }

    @Test
    public void Cart_008_EditPaymentInfoOnConfirmation(){
        //Pre-Conditions: There needs to be at least one item in the shopping cart
        logFile.AddLog("Starting Test: Edit Payment info on Confirmation screen");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinuetoPay().EnterCCInfo(validExpirey, validCC, validCCV)
                .EnterBillingInfo(Address1, Address2, City, State, Zip).KnownValidCC().EditBilling().EnterCCInfo(validExpirey, validCC, validCCV)
                .KnownValidCC();

    }

    @Test
    public void Cart_009_CheckoutCreditCard(){
        //Pre-Conditions: There needs to be at least one item in the shopping cart
        logFile.AddLog("Starting Test: Checkout Credit Card Confirmation");
        Makr_Home_Screen.StartMaker().tapShoppingCart().tapCheckout(Password).SelectExistingAddress(1).TapContinue().ChangeShipping(2).ClickContinuetoPay().EnterCCInfo(validExpirey, validCC, validCCV)
                .EnterBillingInfo(Address1, Address2, City, State, Zip).KnownValidCC().ClickSubmit();
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
