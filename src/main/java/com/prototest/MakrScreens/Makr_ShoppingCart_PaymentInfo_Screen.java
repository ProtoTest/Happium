package com.prototest.MakrScreens;
import com.prototest.appiumcore.appElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/9/13
 * Time: 11:46 AM
 * This screen is used to enter payment information when ordering prints
 * when logged in as a facebook user this screen will not have the save payment checkbox present
 */
public class Makr_ShoppingCart_PaymentInfo_Screen {
    //TODO finish this screen!
    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath(""));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath(""));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath(""));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath(""));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath(""));
}
