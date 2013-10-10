package com.prototest.MakrScreens;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/9/13
 * Time: 11:47 AM
 * This screen is used to confirm orders - this should be the last screen in the shopping cart
 */
public class Makr_ShoppingCart_FinishOrder_Screen extends appiumScreenBase {
    //todo finish this screen --again a shopping cart base might be a good idea
    appElement BillingInfo = new appElement("BillingInfo", By.xpath("//window[1]/tableview[1]/cell[2]/text[1]"));
    appElement BillingEditButton = new appElement("BillingEdit", By.xpath("//window[1]/tableview[1]/cell[2]/button[1]"));

    appElement ShippingInfo = new appElement("ShippingInfo", By.xpath("//window[1]/tableview[1]/cell[3]/text[1]"));
    appElement ShippingEdit = new appElement("ShippingEdit", By.xpath("//window[1]/tableview[1]/cell[3]/button[1]"));

    appElement ItemEdit = new appElement("ItemEdit", By.xpath("//window[1]/tableview[1]/cell[4]/button[1]"));

    appElement SubmitOrder = new appElement("SubmitOrder", By.xpath("//window[1]/button[18]"));

    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath("/window[1]/text[18]"));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath("//window[1]/text[20]"));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath("//window[1]/text[22]"));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath("//window[1]/text[24]"));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath("//window[1]/text[26]"));

    private Makr_ShoppingCart_Base.ShoppingCalculator ShopCalc;

    List<appElement> ScreenElements;

    public Makr_ShoppingCart_FinishOrder_Screen(Makr_ShoppingCart_Base.ShoppingCalculator shop){
        InitList();
        VerifyContent(ScreenElements);
        ShopCalc = shop;
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(BillingInfo);
        ScreenElements.add(BillingEditButton);
        ScreenElements.add(ShippingInfo);
        ScreenElements.add(ShippingEdit);
        ScreenElements.add(ItemEdit);
        ScreenElements.add(SubmitOrder);
    }

    public Makr_ShoppingCart_PaymentInfo_Screen EditBilling(){
        BillingEditButton.tap();
        return new Makr_ShoppingCart_PaymentInfo_Screen(ShopCalc);
    }
    public Makr_ShoppingCart_ConfirmAddress_Screen EditShipping(){
        ShippingEdit.tap();
        return new Makr_ShoppingCart_ConfirmAddress_Screen(ShopCalc);
    }



}
