package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
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
public class Makr_ShoppingCart_ShippingMethod_Screen {
    appElement Continue = new appElement("ContinueButton", By.xpath("//window[1]/button[13]"));

    //Default shipping method - also a button
    appElement DefaultShipping = new appElement("DefaultShipping", By.xpath("//window[1]/button[12]"));

    //shipping methods that appear when clicking on the shipping method drop down menu
    appElement FedExGround = new appElement("FedExGround", By.xpath("//window[1]/tableview[1]/cell[1]/text[1]"));
    appElement FedExExpress = new appElement("FedExExpress", By.xpath("//window[1]/tableview[1]/cell[2]/text[1]"));
    appElement FedExTwoDay = new appElement("FedExTwoDay", By.xpath("//window[1]//tableview[1]/cell[3]/text[1]"));
    appElement FedExStandard = new appElement("FedExStandard", By.xpath("//window[1]//tableview[1]/cell[4]/text[1]"));

    //these are different on each sub-screen --argh!
    appElement SubTotalAmount_Field = new appElement("SubTotalAmount", By.xpath(""));
    appElement ShippingAmount_Field = new appElement("ShippingAmount", By.xpath(""));
    appElement TaxAmount_Field = new appElement("TaxAmount", By.xpath(""));
    appElement PromoDiscount_Field = new appElement("PromoDiscount", By.xpath(""));
    appElement TotalAmount_Field = new appElement("TotalAmount", By.xpath(""));




}
