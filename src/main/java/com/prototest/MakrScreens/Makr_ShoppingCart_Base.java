package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/10/13
 * Time: 10:20 AM
 * This is the base Shopping cart screen to do all the calculations when the prices are affected.
 * Since all the total fields are different on every screen, these values need to be passed around to every shopping cart screen.
 * So this will be a static class, since once it's instantiated, the values should only be changed by the ShoppingCart screens.
 */
public class Makr_ShoppingCart_Base {
    public static class ShoppingCalculator{
        //Going to use these to set the initial values
        //TODO need to get these values and convert from strings
        private String SubTotal_str;
        private String Shipping_str;
        private String Tax_str;
        private String Promo_str;
        private String Total_str;
        private List<String> PriceStrings;

        private Float SubTotalAmount;
        private Float ShippingAmount;
        private Float TaxAmount;
        private Float PromoDiscountAmount;
        private Float TotalAmount;
        private List<Float> Prices;

        public ShoppingCalculator(){
            PriceStrings = new ArrayList<String>();
            Prices = new ArrayList<Float>();

        }

        public void SetAmounts(String sub, String Ship, String Tax, String Promo, String Total){
            //This really only should be called by the Makr_ShoppingCart_Items_Screen IF there are items in the shopping cart
            SubTotal_str = sub;
            PriceStrings.add(SubTotal_str);
            Shipping_str = Ship;
            PriceStrings.add(Shipping_str);
            Tax_str = Tax;
            PriceStrings.add(Tax_str);
            Promo_str = Promo;
            PriceStrings.add(Promo_str);
            Total_str = Total;
            PriceStrings.add(Total_str);
            ConvertToFloat();
        }

        private void ConvertToFloat() {
            for(int i = 0; i < PriceStrings.size(); i++){
                PriceStrings.get(i).replace("$", "");
                Prices.add(Float.valueOf(PriceStrings.get(i)));
            }
            //now we'll set all the Float objects to their expected value
            SubTotalAmount = Prices.get(0);
            ShippingAmount = Prices.get(1);
            TaxAmount = Prices.get(2);
            PromoDiscountAmount = Prices.get(3);
            TotalAmount = Prices.get(4);
        }

        private Float ConvertToFloat(String price){
            price.replace("$", "");
            Float fPrice = Float.valueOf(price);
            return fPrice;
        }

        public void UpdateSubTotal(String sub){
            SubTotalAmount = ConvertToFloat(sub);
        }
        public void UpdateShipping(String ship){
            ShippingAmount = ConvertToFloat(ship);
        }
        public void UpdateTax(String tax){
            TaxAmount = ConvertToFloat(tax);
        }
        public void UpdatePromo(String prom){
            PromoDiscountAmount = ConvertToFloat(prom);
        }

        public String ExpectedTotal(){
            Float Expected = SubTotalAmount + ShippingAmount + TaxAmount + PromoDiscountAmount;
            String Price = "$" + String.valueOf(Expected);
            return Price;
        }
    }
}
