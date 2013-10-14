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

        //Shipping information used for billing
        private boolean savedFromShipping = false;
        private String m_AddressLine1;
        private String m_AddressLine2;
        private String m_City;
        private String m_State;
        private String m_Zip;

        //Payment information to be used in FinishOrder Verification
        private String m_CCName;
        private String m_CCNumber;
        private String m_ExpiryDate;
        private String m_CVCCode;


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
                String temp = PriceStrings.get(i).replace("$", "");
                Prices.add(Float.valueOf(temp));
            }
            //now we'll set all the Float objects to their expected value
            SubTotalAmount = Prices.get(0);
            ShippingAmount = Prices.get(1);
            TaxAmount = Prices.get(2);
            PromoDiscountAmount = Prices.get(3);
            TotalAmount = Prices.get(4);
        }

        private Float ConvertToFloat(String price){
            price = price.replace("$", "");
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
            String Price;
            Float Expected = SubTotalAmount + ShippingAmount + TaxAmount - PromoDiscountAmount;
            if(Expected <= 0){
                Price = "$0.00";
            }
            else{
                Price = "$" + String.valueOf(Expected) + "0";
                //gonna tack on an extra zero since
                //Price = Price + "0";
            }
            return Price;
        }
        //tacking on zero's here untill I can figure out a way to get this to do it automatically
        public String getSubTotal(){
            String sub_str = "$"+ String.valueOf(SubTotalAmount) + "0";
            return sub_str;
        }
        public String getShipping(){
            String ship_str = "$"+ String.valueOf(ShippingAmount) + "0";
            return ship_str;
        }
        public String getTax(){
            String tax_str = "$"+ String.valueOf(TaxAmount) + "0";
            return tax_str;
        }
        public String getPromo(){
            String promo_str = "$"+ String.valueOf(PromoDiscountAmount) + "0";
            return promo_str;
        }
        public void UpdateShipping(String lineOne, String lineTwo, String city, String state, String zip){
            m_AddressLine1 = lineOne;
            m_AddressLine2 = lineTwo;
            m_City = city;
            m_State = state;
            m_Zip = zip;
            savedFromShipping = true;
        }
        public String getAddressLine1(){
            return m_AddressLine1;
        }
        public String getAddressLine2(){
            return m_AddressLine2;
        }
        public String getCity(){
            return m_City;
        }
        public String getState(){
            return m_State;
        }
        public String getZip(){
            return m_Zip;
        }
        public Boolean SavedFromBilling(){
            return savedFromShipping;
        }
        //Credit card information
        public void UpdatePaymentInfo(String name, String ccnum, String expire, String CVC){
            m_CCName = name;
            m_CCNumber = ccnum;
            m_ExpiryDate = expire;
            m_CVCCode = CVC;
        }
        public String getCCName(){
            return m_CCName;
        }
        public String getCCNumber(){
            return m_CCNumber;
        }
        public String getCVCcode(){
            return m_CVCCode;
        }
        public String getExpire(){
            return m_ExpiryDate;
        }

    }
}
