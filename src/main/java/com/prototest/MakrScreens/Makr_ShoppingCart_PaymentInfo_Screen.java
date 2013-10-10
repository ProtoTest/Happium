package com.prototest.MakrScreens;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/9/13
 * Time: 11:46 AM
 * This screen is used to enter payment information when ordering prints
 * when logged in as a facebook user this screen will not have the save payment checkbox present
 */
public class Makr_ShoppingCart_PaymentInfo_Screen extends appiumScreenBase {
    //TODO Need to figure out a way to pass billing address into this screen -- might be able to handle this with a shopping cart base class
    appElement NameOnCard = new appElement("NameOnCard", By.xpath("//window[1]/textfield[1]"));
    appElement ExpiryDate = new appElement("ExpiryDate", By.xpath("//window[1]/textfield[2]"));
    appElement CardNumber = new appElement("CardNumber", By.xpath("//window[1]/textfield[3]"));
    appElement CVCCode = new appElement("CVCCode", By.xpath("//window[1]/textfield[4]"));

    //Billing address info -- this is passed over from previous screens if the use billing info box is checked
    appElement AddressLine1 = new appElement("AddressLine1", By.xpath("//window[1]/textfield[5]"));
    appElement AddressCity = new appElement("AddressCity", By.xpath("//window[1]/textfield[6]"));
    appElement AddressLine2 = new appElement("AddressLine2", By.xpath("//window[1]/textfield[7]"));
    appElement AddressState = new appElement("AddressState", By.xpath("//window[1]/textfield[8]"));
    appElement AddressZip = new appElement("AddressZip", By.xpath("//window[1]/textfield[9]"));

    //This will not be visible for facebook logins
    appElement SavePaymentMethod = new appElement("SavePaymentMethod", By.xpath("//window[1]/button[15]"));
    appElement ContinueButton = new appElement("ContinueButton", By.xpath("//window[1]/button[17]"));

    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath("//window[1]/text[18]"));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath("//window[1]/text[20]"));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath("//window[1]/text[22]"));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath("//window[1]/text[24]"));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath("/window[1]/text[26]"));

    //invalid Credit card warning
    appElement ConfirmInvalidCC = new appElement("ConfirmInvalidCCButton", By.xpath("//window[3]/image[1]/button[1]"));

    List<appElement> ScreenElements;
    private boolean EnteredPaymentInfo = false;
    private boolean EnteredBillingInfo = false;

    public Makr_ShoppingCart_PaymentInfo_Screen(){
        InitList();
        VerifyContent(ScreenElements);

    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(NameOnCard);
        ScreenElements.add(ExpiryDate);
        ScreenElements.add(CardNumber);
        ScreenElements.add(CVCCode);
        ScreenElements.add(AddressLine1);
        ScreenElements.add(AddressCity);
        ScreenElements.add(AddressLine2);
        ScreenElements.add(AddressState);
        ScreenElements.add(AddressZip);
        ScreenElements.add(ContinueButton);
        ScreenElements.add(SubTotalAmount_Field);
        ScreenElements.add(ShippingAmount_Field);
        ScreenElements.add(TaxAmount_Field);
        ScreenElements.add(PromoDiscount_Field);
        ScreenElements.add(TotalAmount_Field);
    }

    public Makr_ShoppingCart_PaymentInfo_Screen EnterCCInfo(String expire, String CCNum, String CVC){
        ExpiryDate.SendKeys(expire);
        CardNumber.SendKeys(CCNum);
        CVCCode.SendKeys(CVC);
        EnteredPaymentInfo = true;
        return this;
    }

    public Makr_ShoppingCart_PaymentInfo_Screen EnterBillingInfo(String Address1, String Address2, String City, String State, String Zip){
        AddressLine1.SendKeys(Address1);
        AddressCity.SendKeys(City);
        AddressLine2.SendKeys(Address2);
        AddressState.SendKeys(State);
        AddressZip.SendKeys(Zip);
        EnteredBillingInfo = true;
        return this;
    }

    public Makr_ShoppingCart_PaymentInfo_Screen KnownInvalidCC(){
        //This method will be called when a known invalid CC number is provided
        if(EnteredPaymentInfo && EnteredBillingInfo){
            ContinueButton.tap();
            if(ConfirmInvalidCC.isDisplayed()){
                ConfirmInvalidCC.tap();
                Assert.assertTrue(ConfirmInvalidCC.isDisplayed());
            }
            else{
                Assert.fail("Invalid Credit Card was not validated");
            }
        }
        return this;
    }

    public Makr_ShoppingCart_FinishOrder_Screen KnownValidCC(){
        //this method will be called when a known valid cc number is provided
        if(EnteredPaymentInfo && EnteredBillingInfo){
            ContinueButton.tap();
            if(ConfirmInvalidCC.isDisplayed()){
                Assert.fail("Valid Credit Card was not validated -- or device lost connection to the internet");
            }
        }

        return new Makr_ShoppingCart_FinishOrder_Screen();
    }



}
