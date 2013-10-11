package com.prototest.MakrScreens;

import com.prototest.appiumcore.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/9/13
 * Time: 11:45 AM
 * This screen is used during the order process to select the shipping method
 */
public class Makr_ShoppingCart_ShippingMethod_Screen extends appiumScreenBase {
    appElement Continue = new appElement("ContinueButton", By.xpath("//window[1]/button[14]"));

    //Default shipping method - also a button
    appElement DefaultShipping = new appElement("DefaultShipping", By.xpath("//window[1]/button[13]"));

    //shipping methods that appear when clicking on the shipping method drop down menu
    appElement FedExGround = new appElement("FedExGround", By.xpath("//window[1]/tableview[1]/cell[1]/text[1]"));
    private final String FEDEX_GROUND_PRICE = "$8.00";
    appElement FedExExpress = new appElement("FedExExpress", By.xpath("//window[1]/tableview[1]/cell[2]/text[1]"));
    private final String FEDEX_EXPRESS_PRICE = "$20.00";
    appElement FedExTwoDay = new appElement("FedExTwoDay", By.xpath("//window[1]//tableview[1]/cell[3]/text[1]"));
    private final String FEDEX_TWODAY_PRICE = "$30.00";
    appElement FedExOverNight = new appElement("FedExOverNight", By.xpath("//window[1]//tableview[1]/cell[4]/text[1]"));
    private final String FEDEX_OVERNIGHT = "$40.00";

    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath("//window[1]/text[13]"));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath("/window[1]/text[15]"));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath("//window[1]/text[17]"));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath("//window[1]/text[19]"));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath("//window[1]/text[21]"));

    public static Makr_ShoppingCart_Base.ShoppingCalculator ShopCalc;
    List<appElement> ScreenElements;

    public Makr_ShoppingCart_ShippingMethod_Screen(Makr_ShoppingCart_Base.ShoppingCalculator shopcalc){
        InitList();
        VerifyContent(ScreenElements);
        ShopCalc = shopcalc;

    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Continue);
        ScreenElements.add(DefaultShipping);
    }

    public Makr_ShoppingCart_ShippingMethod_Screen ChangeShipping(int method){
        DefaultShipping.tap();
        switch (method){
            case 1:
                FedExGround.tap();
                ShopCalc.UpdateShipping(FEDEX_GROUND_PRICE);
                break;
            case 2:
                FedExExpress.tap();
                ShopCalc.UpdateShipping(FEDEX_EXPRESS_PRICE);
                break;
            case 3:
                FedExTwoDay.tap();
                ShopCalc.UpdateShipping(FEDEX_TWODAY_PRICE);
                break;
            case 4:
                FedExOverNight.tap();
                ShopCalc.UpdateShipping(FEDEX_OVERNIGHT);
                break;
            default:
                FedExGround.tap();
                ShopCalc.UpdateShipping(FEDEX_GROUND_PRICE);
                break;
        }
        return this;
    }

    public Makr_ShoppingCart_PaymentInfo_Screen ClickContinuetoPay(){
        Assert.assertEquals(ShopCalc.getShipping(), ShippingAmount_Field.GetAttribute("value"));
        Assert.assertEquals(ShopCalc.ExpectedTotal(), TotalAmount_Field.GetAttribute("value"));
        Continue.tap();
        return new Makr_ShoppingCart_PaymentInfo_Screen(ShopCalc);
    }

    public Makr_ShoppingCart_FinishOrder_Screen ClickContinueToFinish(){
        //Assert.assertEquals(ShopCalc.getShipping(), ShippingAmount_Field.GetAttribute("value"));
        //Assert.assertEquals(ShopCalc.ExpectedTotal(), TotalAmount_Field.GetAttribute("value"));
        Continue.tap();
        return new Makr_ShoppingCart_FinishOrder_Screen(ShopCalc);
    }


}
