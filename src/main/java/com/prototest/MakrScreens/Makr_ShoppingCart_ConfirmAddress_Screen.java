package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/9/13
 * Time: 11:43 AM
 * Screen used during ordering process to allow users to enter or confirm address
 * addresses already entered and saved should be presented to the users
 */
public class Makr_ShoppingCart_ConfirmAddress_Screen extends Makr_MenuBar_HeaderScreen {
    appElement BackButton = new appElement("ShoppingCart_Address_BackButton", By.xpath("//window[1]/button[7]"));
    appElement CancelOrderButton = new appElement("ShoppingCart_CancelOrder_Button", By.xpath("//window[1]/button[8]"));
    appElement NewAddress = new appElement("NewAddress", By.xpath("//window[1]/button[10]"));
    appElement ContinueSelectedButton = new appElement("ContinueButton", By.xpath("//window[1]/button[12]")); //this button is only valid when an address is selected
    appElement ContinueEnteredButton = new appElement("ContinueButton", By.xpath("//window[1]/button[11]"));


    //New address fields go here these will only show up if no other address has been entered previously or user taps new address
    appElement AddressFName = new appElement("AddressFName", By.xpath("//window[1]/textfield[1]"));
    appElement AddressLName = new appElement("AddressLName", By.xpath("//window[1]/textfield[2]"));
    appElement AddressCompany = new appElement("AddressCompany", By.xpath("//window[1]/textfield[3]"));
    appElement AddressLine1 = new appElement("AddressLine1", By.xpath("//window[1]/textfield[4]"));
    appElement AddressLine2 = new appElement("AddressLine2", By.xpath("//window[1]/textfield[5]"));
    appElement AddressCity = new appElement("AddressCity", By.xpath("//window[1]/textfield[6]"));
    appElement AddressState = new appElement("AddressState", By.xpath("//window[1]/textfield[7]"));
    appElement AddressZip = new appElement("AddressZip", By.xpath("//window[1]/textfield[8]"));
    appElement AddressPhone = new appElement("AddressPhone", By.xpath("//window[1]/textfield[9]"));
    appElement AddressDescription = new appElement("AddressDescription", By.xpath("//window[1]/textfield[10]")); //If SaveShipping is unchecked shipping will disappear
    appElement AddressSaveShipping = new appElement("AddressSaveShipping", By.xpath("//window[1]/button[17]")); //If this is checked Description will appear
    appElement AddressUseBilling = new appElement("AddressUseBilling", By.xpath("//window[1]/button[17]"));

    //Not sure if I can tap on this thing or not - this will not be displayed if the user taps the new address button
    appElement FirstExistingAddress = new appElement("FirstExistingAddress", By.xpath("//window[1]/UIACollectionView[1]/UIACollectionCell[1]/text[3]"));

    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath("//window[1]/text[13]"));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath("/window[1]/text[15]"));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath("//window[1]/text[17]"));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath("//window[1]/text[19]"));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath("//window[1]/text[21]"));

    List<appElement> ScreenElements;
    private boolean addressEntered = false;
    private boolean addressSelected = false;

    //this is used to determine if the shipping address will be used for billing
    private boolean saveShipping = false;
    private Makr_ShoppingCart_Base.ShoppingCalculator ShopCalc;


    public Makr_ShoppingCart_ConfirmAddress_Screen(Makr_ShoppingCart_Base.ShoppingCalculator calc){
        InitList();
        VerifyContent(ScreenElements);
        ShopCalc = calc;
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(BackButton);
        ScreenElements.add(CancelOrderButton);
        ScreenElements.add(NewAddress);

    }

    public Makr_ShoppingCart_ConfirmAddress_Screen SelectExistingAddress(int addressNum){
        String ExistingAddressLocator = "//window[1]/UIACollectionView[1]/UIACollectionCell["+ String.valueOf(addressNum) +"]/text[3]";
        appElement SelectedAddress = new appElement("SelectedAddress"+ String.valueOf(addressNum), By.xpath(ExistingAddressLocator));
        if(SelectedAddress.verifyPresent())
        {
            SelectedAddress.tap();
            addressSelected = true;
        }
        else{
            if(FirstExistingAddress.verifyPresent()){
                FirstExistingAddress.tap();
                addressSelected = true;
            }
            else{
                Assert.fail("The selected address located at: " + ExistingAddressLocator + " or " + FirstExistingAddress.GetElementName());
            }
        }
        return this; //we don't want to revalidate the entire screen by returning a new
    }

    public Makr_ShoppingCart_ConfirmAddress_Screen EnterNewAddress(String FName, String LName, String Company, String Line1, String Line2,
                                                                   String City, String State, String Zip, String Phone, String Description){

        AddressFName.SendKeys(FName);
        AddressLName.SendKeys(LName);
        AddressCompany.SendKeys(Company);
        AddressLine1.SendKeys(Line1);
        AddressLine2.SendKeys(Line2);
        AddressCity.SendKeys(City);
        AddressState.SendKeys(State);
        AddressZip.SendKeys(Zip);
        AddressPhone.SendKeys(Phone);
        AddressDescription.SendKeys(Description);
        addressEntered = true;
        return this; //we dont' want to revalidate the entire screen by returning a new
    }

    public Makr_ShoppingCart_ConfirmAddress_Screen TapSaveShipping(){
        AddressSaveShipping.tap();
        //since the AddressSaveShipping is a UIAButton and not a UIASwitch we'll have to figure out what state it's in by guessing
        //we know that it starts as unchecked, so the saveShipping bool is set to false by default.  We'll have to change the state of the bool
        //everytime this function is called in the same instance of this screen
        if(saveShipping){
            saveShipping = false;
        }
        else{
            saveShipping = true;
        }

        return this;
    }

    private void SaveShipping(){
        ShopCalc.UpdateShipping(AddressLine1.GetAttribute("value"), AddressLine2.GetAttribute("value"), AddressCity.GetAttribute("value"), AddressState.GetAttribute("value"),
                AddressZip.GetAttribute("value"));
    }

    public Makr_ShoppingCart_ConfirmAddress_Screen TapSaveBilling(){
        AddressUseBilling.tap();
        return this;
    }

    public Makr_ShoppingCart_ShippingMethod_Screen TapContinue(){
        if(addressEntered){
            ContinueEnteredButton.tap();
        }
        if(addressSelected){
            ContinueSelectedButton.tap();
        }
        else{
            Assert.fail("Tried to click on continue button without an address selected - Test Script Logic Error");
        }
        //Before leaving this screen we should check to make sure that none of the prices changed
        VerifyPricesUnchanged();
        if(saveShipping){
            //This is to make sure the shipping information is passed into the payment screen properly
            SaveShipping();
        }
        return new Makr_ShoppingCart_ShippingMethod_Screen(ShopCalc);
    }
    //SubtotalAmount = //window[1]/text[11]

    private void VerifyPricesUnchanged(){
        Assert.assertEquals(ShopCalc.getSubTotal(), SubTotalAmount_Field.GetAttribute("value"));
        Assert.assertEquals(ShopCalc.getShipping(), ShippingAmount_Field.GetAttribute("value"));
        Assert.assertEquals(ShopCalc.getTax(), TaxAmount_Field.GetAttribute("value"));
        Assert.assertEquals(ShopCalc.getPromo(), PromoDiscount_Field.GetAttribute("value"));
        Assert.assertEquals(ShopCalc.ExpectedTotal(), TotalAmount_Field.GetAttribute("value"));
    }

}
