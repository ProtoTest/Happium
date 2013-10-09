package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
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
public class Makr_ShoppingCart_FinishOrder_Screen {
    //todo finish this screen
    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath(""));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath(""));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath(""));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath(""));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath(""));
}
