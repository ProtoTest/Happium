package com.prototest.MakrTests;

import org.openqa.selenium.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 11/1/13
 * Time: 10:30 AM
 * This thing is going to find xpath's for page objects.  So we can look up objects by their location which should not change as much
 */
public class Experimental {
    static String source = "{\"name\":\"Makr α\",\"type\":\"UIAApplication\",\"label\":\"Makr α\",\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":0},\"size\":{\"width\":1024,\"height\":768}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[{\"name\":null,\"type\":\"UIAWindow\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":0},\"size\":{\"width\":1024,\"height\":768}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":0},\"size\":{\"width\":55,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAStaticText\",\"label\":\"\",\"value\":\"\",\"rect\":{\"origin\":{\"x\":67,\"y\":5},\"size\":{\"width\":250,\"height\":34}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":1,\"rect\":{\"origin\":{\"x\":380,\"y\":0},\"size\":{\"width\":44,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":454,\"y\":0},\"size\":{\"width\":44,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":528,\"y\":0},\"size\":{\"width\":44,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":602,\"y\":0},\"size\":{\"width\":44,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":925,\"y\":0},\"size\":{\"width\":32,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":925,\"y\":0},\"size\":{\"width\":32,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]}]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":968,\"y\":0},\"size\":{\"width\":44,\"height\":44}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":\"BUSINESS\",\"type\":\"UIAButton\",\"label\":\"BUSINESS\",\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":44},\"size\":{\"width\":170,\"height\":49}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":\"PARTIES\",\"type\":\"UIAButton\",\"label\":\"PARTIES\",\"value\":null,\"rect\":{\"origin\":{\"x\":171,\"y\":44},\"size\":{\"width\":170,\"height\":49}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":\"WEDDING\",\"type\":\"UIAButton\",\"label\":\"WEDDING\",\"value\":null,\"rect\":{\"origin\":{\"x\":342,\"y\":44},\"size\":{\"width\":170,\"height\":49}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":\"BABY\",\"type\":\"UIAButton\",\"label\":\"BABY\",\"value\":null,\"rect\":{\"origin\":{\"x\":513,\"y\":44},\"size\":{\"width\":170,\"height\":49}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":\"HOLIDAY\",\"type\":\"UIAButton\",\"label\":\"HOLIDAY\",\"value\":null,\"rect\":{\"origin\":{\"x\":684,\"y\":44},\"size\":{\"width\":170,\"height\":49}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":\"HOME\",\"type\":\"UIAButton\",\"label\":\"HOME\",\"value\":null,\"rect\":{\"origin\":{\"x\":855,\"y\":44},\"size\":{\"width\":169,\"height\":49}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAScrollView\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":96},\"size\":{\"width\":1024,\"height\":672}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[{\"name\":null,\"type\":\"UIAScrollView\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":96},\"size\":{\"width\":1024,\"height\":460}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":-1024,\"y\":96},\"size\":{\"width\":1024,\"height\":460}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":96},\"size\":{\"width\":1024,\"height\":460}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":1024,\"y\":96},\"size\":{\"width\":1024,\"height\":460}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":2048,\"y\":96},\"size\":{\"width\":1024,\"height\":460}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":3072,\"y\":96},\"size\":{\"width\":1024,\"height\":460}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]}]},{\"name\":null,\"type\":\"UIAPageIndicator\",\"label\":null,\"value\":\"page 1 of 3\",\"rect\":{\"origin\":{\"x\":100,\"y\":526},\"size\":{\"width\":824,\"height\":35}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":\"FRESH IDEAS\",\"type\":\"UIAStaticText\",\"label\":\"FRESH IDEAS\",\"value\":\"FRESH IDEAS\",\"rect\":{\"origin\":{\"x\":465,\"y\":581},\"size\":{\"width\":94,\"height\":18}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":22,\"y\":619},\"size\":{\"width\":310,\"height\":242}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":357,\"y\":619},\"size\":{\"width\":310,\"height\":242}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":692,\"y\":619},\"size\":{\"width\":310,\"height\":242}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":true,\"children\":[]},{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":1017,\"y\":763},\"size\":{\"width\":7,\"height\":5}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAImage\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":1019,\"y\":761},\"size\":{\"width\":5,\"height\":7}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":\"MOST POPULAR\",\"type\":\"UIAStaticText\",\"label\":\"MOST POPULAR\",\"value\":\"MOST POPULAR\",\"rect\":{\"origin\":{\"x\":457,\"y\":886},\"size\":{\"width\":110,\"height\":18}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":22,\"y\":924},\"size\":{\"width\":310,\"height\":242}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":357,\"y\":924},\"size\":{\"width\":310,\"height\":242}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":null,\"type\":\"UIAButton\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":692,\"y\":924},\"size\":{\"width\":310,\"height\":242}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]}]}]},{\"name\":null,\"type\":\"UIAWindow\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":-256},\"size\":{\"width\":768,\"height\":1024}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[{\"name\":null,\"type\":\"UIAStatusBar\",\"label\":null,\"value\":null,\"rect\":{\"origin\":{\"x\":0,\"y\":0},\"size\":{\"width\":1024,\"height\":20}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[{\"name\":\"iPad\",\"type\":\"UIAElement\",\"label\":\"iPad\",\"value\":null,\"rect\":{\"origin\":{\"x\":6,\"y\":0},\"size\":{\"width\":26,\"height\":20}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":\"3 of 3 Wi-Fi bars\",\"type\":\"UIAElement\",\"label\":\"3 of 3 Wi-Fi bars\",\"value\":\"ProtoTest\",\"rect\":{\"origin\":{\"x\":37,\"y\":0},\"size\":{\"width\":13,\"height\":20}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":\"1:23 PM\",\"type\":\"UIAElement\",\"label\":\"1:23 PM\",\"value\":null,\"rect\":{\"origin\":{\"x\":490,\"y\":0},\"size\":{\"width\":45,\"height\":20}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":\"Bluetooth on\",\"type\":\"UIAElement\",\"label\":\"Bluetooth on\",\"value\":null,\"rect\":{\"origin\":{\"x\":898,\"y\":0},\"size\":{\"width\":8,\"height\":20}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":\"Not charging\",\"type\":\"UIAElement\",\"label\":\"Not charging\",\"value\":null,\"rect\":{\"origin\":{\"x\":912,\"y\":0},\"size\":{\"width\":76,\"height\":20}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]},{\"name\":\"69% battery power, Charging\",\"type\":\"UIAElement\",\"label\":\"69% battery power, Charging\",\"value\":null,\"rect\":{\"origin\":{\"x\":994,\"y\":0},\"size\":{\"width\":25,\"height\":20}},\"dom\":null,\"enabled\":true,\"valid\":true,\"visible\":false,\"children\":[]}]}]}]}";
    private static List<Point> Locations;
    private static List<String> xpaths;
    private static List<String> elements;
    private static String ParentTerminator = "}]";

    private static Integer intWindow = 1;
    private static Stack WindowStack = new Stack();
    private static Integer intButton = 1;
    private static Stack ButtonStack = new Stack();
    private static Integer intStaticText = 1;
    private static Stack StaticTextStack = new Stack();
    private static Integer intScrollView = 1;
    private static Stack ScrollViewStack = new Stack();
    private static Integer intTextfield = 1;
    private static Stack TextfieldStack = new Stack();
    private static Integer intSecureTextField = 1;
    private static Stack SecureTextFieldStack = new Stack();
    private static Integer intImage = 1;
    private static Stack ImageStack = new Stack();
    private static Integer intStatusBar = 1;
    private static Stack StatusBarStack = new Stack();

    public static void main(String[] args){
        split();
        CalculateXpaths();
        CalculateLocations();
        System.out.println("derp");
    }

    private static void CalculateLocations() {
        //This function will parse the element strings and stip out the location strings, parse them into Points and add them to the locations array
        //the locations and xpaths array are treated as parellel arrays
        Locations = new ArrayList<Point>();
        String XFinder = "\"x\":";
        String YFinder = "\"y\":";

        String Xloc = "";
        String Yloc = "";
        Point Location;
        for(int i = 0; i < elements.size(); i++){
            int XlocStart = elements.get(i).indexOf(XFinder);
            int DividLoc = elements.get(i).indexOf(',', XlocStart);
            int YlocStart = elements.get(i).indexOf(YFinder);
            int Yend = elements.get(i).indexOf('}', YlocStart);
            Xloc = elements.get(i).substring(XlocStart + XFinder.length(), DividLoc);
            Yloc = elements.get(i).substring(YlocStart + YFinder.length(), Yend);
            Location = new Point(Integer.valueOf(Xloc), Integer.valueOf(Yloc));
            Locations.add(Location);
        }
    }

    private static void split(){
        //Split the source into it's basic components
        String[] firstsplit = source.split("\\},\\{");
        List<String[]> secondsplit = new ArrayList<String[]>();
        //for each component in the array, split them into parents and siblings
        for(int i = 0; i < firstsplit.length; i++){
            String[] things = firstsplit[i].split("\\[\\{");
            if(things.length > 0){
                secondsplit.add(things);
            }
        }
        //let's simplify some things here -- add all the split strings to a new list
        elements = new ArrayList<String>();
        for(int i = 0; i < secondsplit.size(); i++){
            for(int x = 0; x < secondsplit.get(i).length; x++){
                elements.add(secondsplit.get(i)[x]);
            }
        }
    }
    private static void CalculateXpaths(){
        //so now we should just be able to iterate through the array to build xpath locators
        //The first element in the array is assumed to be the parent of everything below
        xpaths = new ArrayList<String>();

        String ParentName = "//";
        //now we need some way to determine how many of each thing is on the screen

        //Now were going to go through each string and build the appropriate xpath locator and parse the origin point
        for(int i = 0; i < elements.size(); i++){
            String xpath = "";
            if((elements.get(i).length() - 1) == elements.get(i).lastIndexOf(':')){
                //this is a parent -- set the parent name
                ParentName +=  TypeSelector(elements.get(i));
                ParentName += "//";
                xpath = ParentName;
                SaveValues();
            }
            else{
                if(elements.get(i).indexOf(ParentTerminator) == -1){
                    String theType = TypeSelector(elements.get(i));
                    xpath = ParentName + theType;
                }
            }

            if(elements.get(i).indexOf(ParentTerminator) != -1){ //this string contains at least one parent terminator
                //we need to figure out if there is more than one parent terminator -- so we'll remove the substring of the initial parent terminator and check for it again
                xpath = ParentName + TypeSelector(elements.get(i));

                while (elements.get(i).indexOf(ParentTerminator) != -1){
                    String thing = elements.get(i).replaceFirst(ParentTerminator, "");
                    elements.set(i, thing); //This is the weird Java way to change an element in the Array list
                    //need to update the parent string now to close the previous parent
                    String[] Parents = ParentName.split("//");
                    //need to check this.
                    ParentName = "";
                    for(int x = 0; x < Parents.length - 1; x++){
                        //we don't want the last element in the array since we found a parent terminator
                        ParentName += Parents[x] + "//";
                    }
                    ResetValues();
                }
            }
            //we want to strip off the //Application Part and any trailing //
            String app = "//Application";
            String stripped = xpath.substring(app.length(), xpath.length());
            xpaths.add(stripped);
        }
    }

    private static String TypeSelector(String raw){
        String type = "UIA";
        int typeloc = raw.indexOf(type) + type.length();
        int typeend = raw.indexOf('\"', typeloc);
        String selectedType = raw.substring(typeloc, typeend);
        String TypeandID = selectedType + PrintID(selectedType);
        return TypeandID;
    }

    private static String PrintID(String type){
        //TODO add all the other locators here
        String thenumber = "";
        if(type.equals("Window")){
            thenumber = "[" + String.valueOf(intWindow) + "]";
            intWindow += 1;
        }
        if(type.equals("Button")){
            thenumber = "[" + String.valueOf(intButton) + "]";
            intButton += 1;
        }
        if(type.equals("StaticText")){
            thenumber = "[" + String.valueOf(intStaticText) + "]";
            intStaticText += 1;
        }
        if(type.equals("ScrollView")){
            thenumber = "[" + String.valueOf(intScrollView) + "]";
            intScrollView += 1;
        }
        if(type.equals("TextField")){
            thenumber = "[" + String.valueOf(intTextfield) + "]";
            intTextfield += 1;
        }
        if(type.equals("SecureTextField")){
            thenumber = "[" + String.valueOf(intSecureTextField) + "]";
            intSecureTextField += 1;
        }
        if(type.equals("Image")){
            thenumber = "[" + String.valueOf(intImage) + "]";
            intImage += 1;
        }
        if(type.equals("StatusBar")){
            thenumber = "[" + String.valueOf(intStatusBar) + "]";
            intStatusBar += 1;
        }
        return thenumber;
    }

    private static void SaveValues(){
        WindowStack.push(intWindow);
        ButtonStack.push(intButton);
        StaticTextStack.push(intStaticText);
        ScrollViewStack.push(intScrollView);
        ImageStack.push(intImage);
        StatusBarStack.push(intStatusBar);
        TextfieldStack.push(intTextfield);
        SecureTextFieldStack.push(intSecureTextField);
        //reset the values of the ints to 1 now that we saved them previously
        intWindow = 1;
        intButton = 1;
        intStaticText = 1;
        intScrollView = 1;
        intImage = 1;
        intStatusBar = 1;
        intTextfield = 1;
        intSecureTextField = 1;
    }

    private static void ResetValues(){
        intWindow = (Integer) WindowStack.pop();
        intButton = (Integer) ButtonStack.pop();
        intStaticText = (Integer) StaticTextStack.pop();
        intScrollView = (Integer) ScrollViewStack.pop();
        intImage = (Integer) ImageStack.pop();
        intStatusBar = (Integer) StatusBarStack.pop();
        intTextfield = (Integer) TextfieldStack.pop();
        intSecureTextField = (Integer) SecureTextFieldStack.pop();
    }










}
