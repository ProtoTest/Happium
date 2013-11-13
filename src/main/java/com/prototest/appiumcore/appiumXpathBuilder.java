package com.prototest.appiumcore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 11/1/13
 * Time: 10:30 AM
 * This thing is going to find xpath's for page objects.  So we can look up objects by their location which should not change as much.  Making our tests easier to maintain.
 */
public class appiumXpathBuilder {
    private  String source = "";
    private  List<Point> Locations;
    private  List<String> xpaths;
    private  List<String> elements;
    private  String ParentTerminator = "}]";

    private  Integer intWindow = 1;
    private  Stack WindowStack = new Stack();
    private  Integer intButton = 1;
    private  Stack ButtonStack = new Stack();
    private  Integer intStaticText = 1;
    private  Stack StaticTextStack = new Stack();
    private  Integer intScrollView = 1;
    private  Stack ScrollViewStack = new Stack();
    private  Integer intTextfield = 1;
    private  Stack TextfieldStack = new Stack();
    private  Integer intSecureTextField = 1;
    private  Stack SecureTextFieldStack = new Stack();
    private  Integer intImage = 1;
    private  Stack ImageStack = new Stack();
    private  Integer intStatusBar = 1;
    private  Stack StatusBarStack = new Stack();

    public appiumXpathBuilder(){
        getPageSource();
        split();
        CalculateXpaths();
        CalculateLocations();
    }

    private void getPageSource() {
        //This function will get the page source of whatever screen the user is on
        //This is called from the ScreenBase class
        JavascriptExecutor js = (JavascriptExecutor) appiumTestBase.getDriver();
        source = (String) js.executeScript("wd_frame.getPageSource()");
    }

    private void CalculateLocations() {
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

    private void split(){
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
    private void CalculateXpaths(){
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

    private String TypeSelector(String raw){
        String type = "UIA";
        int typeloc = raw.indexOf(type) + type.length();
        int typeend = raw.indexOf('\"', typeloc);
        String selectedType = raw.substring(typeloc, typeend);
        String TypeandID = selectedType + PrintID(selectedType);
        return TypeandID;
    }

    private String PrintID(String type){
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

    private void SaveValues(){
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

    private void ResetValues(){
        intWindow = (Integer) WindowStack.pop();
        intButton = (Integer) ButtonStack.pop();
        intStaticText = (Integer) StaticTextStack.pop();
        intScrollView = (Integer) ScrollViewStack.pop();
        intImage = (Integer) ImageStack.pop();
        intStatusBar = (Integer) StatusBarStack.pop();
        intTextfield = (Integer) TextfieldStack.pop();
        intSecureTextField = (Integer) SecureTextFieldStack.pop();
    }

    public String FindByLocation(int X, int Y){
        int indexFound = 0;
        boolean foundMatch = false;
        String xpathFound = "";
        for(int i = 0; i < Locations.size(); i++){
            if((Locations.get(i).x == X) && (Locations.get(i).y == Y)){
                indexFound = i;
                foundMatch = true;
                i = Locations.size(); //to escape the loop once the matching index is found
            }
        }
        if(foundMatch){
           xpathFound = xpaths.get(indexFound);
        }
        else{
            System.out.println("Searching for xPath at Location did not find an element.  Try again.");
        }
        return xpathFound;

    }










}
