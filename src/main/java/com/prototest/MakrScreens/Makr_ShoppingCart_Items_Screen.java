package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/29/13
 * Time: 1:57 PM
 * The screen used to checkout when ordering prints only
 */
public class Makr_ShoppingCart_Items_Screen extends Makr_MenuBar_HeaderScreen {
    appElement ScreenTitle = new appElement("ScreenTitle", By.xpath("//window[1]/text[2]"));
    appElement Items = new appElement("Items", By.xpath("//window[1]/text[3]"));

    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath("//window[1]/text[8]"));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath("//window[1]/text[10]"));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath("//window[1]/text[12]"));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath("//window[1]/text[14]"));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath("//window[1]/text[16]"));

    appElement PromoCode = new appElement("PromoCode", By.xpath("//window[1]/textfield[1]"));
    appElement ZipCode = new appElement("ZipCode", By.xpath("//window[1]/textfield[2]"));
    appElement Checkout = new appElement("CheckoutButton", By.name("CHECKOUT"));

    //This is the password confirmation screen field that paypopup
    appElement Password = new appElement("Password", By.xpath("//window[1]/secure[7]"));
    appElement ConfirmButton = new appElement("ConfirmButton", By.xpath("//window[1]/button[28]"));



    //TODO need to also check to make sure there are items on this screen

    List<appElement> ScreenElements;

    public Makr_ShoppingCart_Items_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(ScreenTitle);
        ScreenElements.add(Items);

        ScreenElements.add(PromoCode);
        ScreenElements.add(ZipCode);
        ScreenElements.add(Checkout);
    }

    public Makr_ShoppingCart_Items_Screen addPromoCode(String pcode){
        //This is going to have to update the total to an expected value

        PromoCode.SendKeys(pcode);
        return new Makr_ShoppingCart_Items_Screen();
    }

    public Makr_ShoppingCart_Items_Screen addZipCode(String zip){
        //This is going to have to update the total to an expected value
        ZipCode.SendKeys(zip);
        return new Makr_ShoppingCart_Items_Screen();
    }

    public Makr_ShoppingCart_ConfirmAddress_Screen tapCheckout(String pass){
        Checkout.tap();
        if(ConfirmButton.isDisplayed()){
            Password.SendKeys(pass);
            ConfirmButton.tap();
        }
        return new Makr_ShoppingCart_ConfirmAddress_Screen();
    }

    public void GetSubTotal(){
        System.out.println("******====="+ String.valueOf(SubTotalAmount_Field.isDisplayed()));
    }




}
