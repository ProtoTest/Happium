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
public class Makr_ShoppingCart_ConfirmAddress_Screen extends appiumScreenBase {
    appElement BackButton = new appElement("ShoppingCart_Address_BackButton", By.xpath("//window[7]/button[7]"));
    appElement CancelOrderButton = new appElement("ShoppingCart_CancelOrder_Button", By.xpath("//window[7]/button[8]"));
    appElement NewAddress = new appElement("NewAddress", By.xpath("//window[1]/button[10]"));
    appElement ContinueButton = new appElement("ContinueButton", By.xpath("//window[1]/button[21]"));

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

    List<appElement> ScreenElements;
    private Boolean addressEntered = false;

    public Makr_ShoppingCart_ConfirmAddress_Screen(){
        InitList();
        VerifyContent(ScreenElements);

    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(BackButton);
        ScreenElements.add(CancelOrderButton);
        ScreenElements.add(NewAddress);
        ScreenElements.add(ContinueButton);
    }

    public Makr_ShoppingCart_ConfirmAddress_Screen SelectExistingAddress(int addressNum){
        String ExistingAddressLocator = "//window[1]/UIACollectionView[1]/UIACollectionCell["+ String.valueOf(addressNum) +"]/text[3]";
        appElement SelectedAddress = new appElement("SelectedAddress"+ String.valueOf(addressNum), By.xpath(ExistingAddressLocator));
        if(SelectedAddress.verifyPresent())
        {
            SelectedAddress.tap();
            addressEntered = true;
        }
        else{
            if(FirstExistingAddress.verifyPresent()){
                FirstExistingAddress.tap();
                addressEntered = true;
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
        return this;
    }

    public Makr_ShoppingCart_ConfirmAddress_Screen TapSaveBilling(){
        AddressUseBilling.tap();
        return this;
    }

    public Makr_ShoppingCart_ShippingMethod_Screen TapContinue(){
        if(addressEntered){
            ContinueButton.tap();
        }
        else{
            Assert.fail("Tried to click on continue button without an address selected - Test Script Logic Error");
        }
        return new Makr_ShoppingCart_ShippingMethod_Screen();
    }
    //SubtotalAmount = //window[1]/text[11]


}