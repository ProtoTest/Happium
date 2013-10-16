package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import com.prototest.appiumcore.appiumScreenBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/11/13
 * Time: 7:25 PM
 * This is the screen that comes up when the user clicks the plus button
 */
public class Makr_Menu_NewProject_Screen extends appiumScreenBase {
    appElement PlusButton = new appElement("PlusButton", By.name("wmbPlusButton normal"));
    appElement NewProject = new appElement("NEW PROJECT", By.xpath("//window[1]/text[4]"));

    //Selected menu Item
    appElement Category = new appElement("Category", By.name("Category"));
    appElement Format = new appElement("Format", By.name("Format"));
    appElement Size = new appElement("Size", By.name("Size"));
    appElement Avery = new appElement("Avery", By.name("Avery"));

    //<editor-fold desc="Elements">
    //The selected menu item above results are displayed in the SelectedList item
    //appElement SelectedList = new appElement("SelectedList", By.xpath("//window[1]/tableview[5]"));
    //category
    appElement Category_Baby = new appElement("Category_Baby", By.xpath("//window[1]/tableview[2]/cell[1]"));
    appElement Category_Business = new appElement("Category_Business", By.xpath("//window[1]/tableview[2]/cell[2]"));
    appElement Category_Gifting = new appElement("Category_Gifting", By.xpath("//window[1]/tableview[2]/cell[3]"));
    appElement Category_Holiday = new appElement("Category_Holiday", By.xpath("//window[1]/tableview[2]/cell[4]"));
    appElement Category_Kitchen = new appElement("Category_Kitchen", By.xpath("//window[1]/tableview[2]/cell[5]"));
    appElement Category_Moving = new appElement("Category_Moving", By.xpath("//window[1]/tableview[2]/cell[6]"));
    appElement Category_Organization = new appElement("Category_Organization", By.xpath("//window[1]/tableview[2]/cell[7]"));
    appElement Category_Packaging = new appElement("Category_Packaging", By.xpath("//window[1]/tableview[2]/cell[8]"));
    appElement Category_Party = new appElement("Category_Party", By.xpath("//window[1]/tableview[2]/cell[9]"));
    appElement Category_Promotion = new appElement("Category_Promotion", By.xpath("//window[1]/tableview[2]/cell[10]"));
    appElement Category_Stationary = new appElement("Category_Stationery", By.xpath("//window[1]/tableview[2]/cell[11]"));
    appElement Category_TableTop = new appElement("Category_TableTop", By.xpath("//window[1]/tableview[2]/cell[12]"));
    appElement Category_ThankYou = new appElement("Category_ThankYou", By.xpath("//window[1]/tableview[2]/cell[13]"));
    appElement Category_Wedding = new appElement("Category_Wedding", By.xpath("//window[1]/tableview[2]/cell[14]"));

    //avery
    appElement Avery_Cards = new appElement("Cards", By.xpath("//window[1]/tableview[4]/cell[1]"));
    appElement Avery_Card_8869 = new appElement("Avery_Card_8869", By.xpath("//window[1]/tableview[6]/cell[1]/text[1]"));
    appElement Avery_Card_22802 = new appElement("Avery_Card_22802", By.xpath("//window[1]/tableview[6]/cell[2]/text[1]"));
    appElement Avery_Card_8820 = new appElement("Avery_Card_8820", By.xpath("//window[1]/tableview[6]/cell[3]/text[1]"));
    appElement Avery_labels = new appElement("Labels", By.xpath("//window[1]/tableview[4]/cell[2]"));
    appElement Avery_Label_8250 = new appElement("88221", By.xpath("//window[1]/tableview[6]/cell[1]/text[1]"));
    appElement Avery_Label_8160 = new appElement("Label_8160", By.xpath("//window[1]/tableview[6]/cell[2]/text[1]"));
    appElement Avery_Label_22807 = new appElement("Label_22807", By.xpath("//window[1]/tableview[6]/cell[3]/text[1]"));
    appElement Avery_Label_8168 = new appElement("Label_8168", By.xpath("//window[1]/tableview[6]/cell[4]/text[1]"));
    //</editor-fold>

    //This list stores the Overall menu items to check when the screen is displayed
    List<appElement> MainItems;
    //This list holds all the format menu items, these items are generated based on the first format menu item
    List<appElement> FormatItems;
    //This list holds all the size menu items
    List<appElement> SizeItems;

    //These lists hold the Avery Menu items
    List<appElement> AveryCategories;
    //This list holds the list of Avery Items used in the nav test
    List<List<appElement>> AveryListOLists;
    //These lists hold the avery Menu items
    List<appElement> AveryCards;
    List<appElement> AveryLabels;

    //These lists hold the Category menu items
    List<appElement> CategoryList;
    //This list holds the lists of all category lists for use in the nav test
    List<List<appElement>> CategoryListofLists;
    //These lists hold all the category menu items - these items are generated based on the First item in the first list
    List<appElement> BabyItems;
    List<appElement> BusinessItems;
    List<appElement> GiftingItems;
    List<appElement> HolidayItems;
    List<appElement> KitchenItems;
    List<appElement> Movingitems;
    List<appElement> OrganizationItems;
    List<appElement> PackagingItems;
    List<appElement> PartyItems;
    List<appElement> PromotionItems;
    List<appElement> StationaryItems;
    List<appElement> TableTopItems;
    List<appElement> ThankyouItems;
    List<appElement> WeddingItems;

    //This string is used to set up the Category Menu items
    private String GenericCategoryLocator = "//window[1]/tableview[1]/cell[";
    //This string is used to set up the Size Menu Items
    private String GenericSizeLocator = "//window[1]/tableview[5]/cell[";
    //This string is used to set up the Format menu items
    private String GenericFormatLocator = "//window[1]/tableview[3]/cell[";

    //Constructor for the Project screen -- Intializes the Main Items, CategoryList, and Avery Categories
    public Makr_Menu_NewProject_Screen(){
        InitMainItemsList();
        InitCategoryList();
        InitAveryList();
        VerifyContent(MainItems);
        CategoryListofLists = new ArrayList<List<appElement>>();
        AveryListOLists = new ArrayList<List<appElement>>();
    }
    private void InitMainItemsList() {
        MainItems = new ArrayList<appElement>();
        MainItems.add(Category);
        MainItems.add(Format);
        MainItems.add(Size);
        MainItems.add(Avery);
    }
    private void InitCategoryList(){
        CategoryList = new ArrayList<appElement>();
        CategoryList.add(Category_Baby);
        CategoryList.add(Category_Business);
        CategoryList.add(Category_Gifting);
        CategoryList.add(Category_Holiday);
        CategoryList.add(Category_Kitchen);
        CategoryList.add(Category_Moving);
        CategoryList.add(Category_Organization);
        CategoryList.add(Category_Packaging);
        CategoryList.add(Category_Party);
        CategoryList.add(Category_Promotion);
        CategoryList.add(Category_Stationary);
        CategoryList.add(Category_TableTop);
        CategoryList.add(Category_ThankYou);
        CategoryList.add(Category_Wedding);
    }
    private void InitAveryList(){
        AveryCategories = new ArrayList<appElement>();
        AveryCategories.add(Avery_Cards);
        AveryCategories.add(Avery_labels);
    }

    //These functions Initialize the lists needed for the content checking loops based on the GenericCategoryLocator String
    private void InitWedding(){
        WeddingItems = new ArrayList<appElement>();
        SetupList(WeddingItems, GenericCategoryLocator, 8);
    }
    private void InitThankYou(){
        ThankyouItems = new ArrayList<appElement>();
        SetupList(ThankyouItems, GenericCategoryLocator, 2);
    }
    private void InitTableTop(){
        TableTopItems = new ArrayList<appElement>();
        SetupList(TableTopItems, GenericCategoryLocator, 5);
    }
    private void InitStationary(){
        StationaryItems = new ArrayList<appElement>();
        SetupList(StationaryItems, GenericCategoryLocator, 7);
    }
    private void InitPromotion(){
        PromotionItems = new ArrayList<appElement>();
        SetupList(PromotionItems, GenericCategoryLocator, 2);
    }
    private void InitParty(){
        PartyItems = new ArrayList<appElement>();
        SetupList(PartyItems, GenericCategoryLocator, 12);
    }
    private void InitPackaging(){
        PackagingItems = new ArrayList<appElement>();
        SetupList(PackagingItems, GenericCategoryLocator, 7);
    }
    private void InitOrganization(){
        OrganizationItems = new ArrayList<appElement>();
        SetupList(OrganizationItems, GenericCategoryLocator, 5);
    }
    private void InitMoving(){
        Movingitems = new ArrayList<appElement>();
        SetupList(Movingitems, GenericCategoryLocator, 4);
    }
    private void InitKitchen(){
        KitchenItems = new ArrayList<appElement>();
        SetupList(KitchenItems, GenericCategoryLocator, 6);
    }
    private void InitHoliday(){
        HolidayItems = new ArrayList<appElement>();
        SetupList(HolidayItems, GenericCategoryLocator, 6);
    }
    private void InitGifting() {
        GiftingItems = new ArrayList<appElement>();
        SetupList(GiftingItems, GenericCategoryLocator, 9);
    }
    private void InitBusinessItems() {
        BusinessItems = new ArrayList<appElement>();
        SetupList(BusinessItems, GenericCategoryLocator, 7);
    }
    private void InitBaby() {
        BabyItems = new ArrayList<appElement>();
        SetupList(BabyItems, GenericCategoryLocator, 6);
    }

    //These functions initialize the size menu items
    private void InitSize() {
        SizeItems = new ArrayList<appElement>();
        SetupList(SizeItems, GenericSizeLocator, 8);
    }
    private void InitFormat() {
        FormatItems = new ArrayList<appElement>();
        SetupList(FormatItems, GenericFormatLocator, 14);
    }
    private void InitAveryCards(){
        AveryCards = new ArrayList<appElement>();
        AveryCards.add(Avery_Card_8869);
        AveryCards.add(Avery_Card_22802);
        AveryCards.add(Avery_Card_8820);
    }
    private void InitAveryLabels(){
        AveryLabels = new ArrayList<appElement>();
        AveryLabels.add(Avery_Label_8250);
        AveryLabels.add(Avery_Label_8160);
        AveryLabels.add(Avery_Label_22807);
        AveryLabels.add(Avery_Label_8168);
    }
    //This function is used to actually build the Lists with the generic locator strings
    private void SetupList(List<appElement> list, String ReplaceString, int max){
        for(int i = 1; i < max + 1; i++){
            String num = Integer.toString(i);
            list.add(new appElement("Item" + num, By.xpath(ReplaceString + num + "]")));
        }
    }
    //This function is used by the Nav test to build the list of category lists
    private void InitCategorySubs(){
        //Used for the Category Nav test loop
        InitBaby();
        CategoryListofLists.add(BabyItems);
        InitBusinessItems();
        CategoryListofLists.add(BusinessItems);
        InitGifting();
        CategoryListofLists.add(GiftingItems);
        InitHoliday();
        CategoryListofLists.add(HolidayItems);
        InitKitchen();
        CategoryListofLists.add(KitchenItems);
        InitMoving();
        CategoryListofLists.add(Movingitems);
        InitOrganization();
        CategoryListofLists.add(OrganizationItems);
        InitPackaging();
        CategoryListofLists.add(PackagingItems);
        InitParty();
        CategoryListofLists.add(PartyItems);
        InitPromotion();
        CategoryListofLists.add(PromotionItems);
        InitStationary();
        CategoryListofLists.add(StationaryItems);
        InitTableTop();
        CategoryListofLists.add(TableTopItems);
        InitThankYou();
        CategoryListofLists.add(ThankyouItems);
        InitWedding();
        CategoryListofLists.add(WeddingItems);
    }
    //This function is used by the Nav test to build the list of Avery Lists
    private void InitAveryListOList(){
        AveryListOLists.add(AveryCards);
        AveryListOLists.add(AveryLabels);
    }
    //This function is used by the Navigation Test and should not be used by any other test
    public void ProjectMenuNavigationLoopTest(){
        //This takes forever
        CheckFormatNavs();
        CheckCategoryNavs();
        CheckSizeNavs();
        CheckAveryNavs();
    }

    //These will check each and every menu item
    private void CheckFormatNavs(){
        InitFormat();
        for(int i = 0; i < FormatItems.size(); i++){
            Format.tap();
            OpenFormatItem(i);
            PlusButton.tap();
        }
    }
    private void CheckSizeNavs(){
        InitSize();
        for(int i = 0; i < SizeItems.size(); i++){
            Size.tap();
            OpenSizeItem(i);
            PlusButton.tap();
        }
    }
    private void CheckCategoryNavs(){
        //Appium really doesn't like By.Name locators
        //I fought with this function for 2 hours first with By.Name locators for the category submenus.  Appium must be disposing of the name
        //or something after you tap on it once.  Xpaths work great, but they change with each build of the app.  ARG!
        InitCategorySubs();
        for(int i = 0; i < CategoryList.size(); i++){
            for(int x = 0; x < CategoryListofLists.get(i).size(); x++){
                //Category.tap();
                //CategoryList.get(i).tap();
                //CategoryListofLists.get(i).get(x).tap();
                OpenCategory(CategoryList.get(i).GetElementName(), x);
                PlusButton.tap();
            }
        }
    }
    private void CheckAveryNavs(){
        InitAveryCards();
        InitAveryLabels();
        InitAveryListOList();
        for(int i = 0; i < AveryCategories.size(); i++){
            for(int x = 0; x < AveryListOLists.get(i).size(); x++){
                PlusButton.tap();
                OpenAveryItem(AveryCategories.get(i).GetElementName(), x);
            }
        }
    }
    //These are the functions used to open specific menu items, the QAE needs to know which item they wish to open and the specific string (if applicable) they need to open it
    public Makr_Content_Category_Screen OpenFormatItem(int FormatNum){
        if(FormatItems == null){
            InitFormat();
        }
        FormatItems.get(FormatNum).tap();
        return new Makr_Content_Category_Screen();
    }
    public Makr_Content_Category_Screen OpenSizeItem(int SizeItem){
        SizeItems.get(SizeItem).tap();
        return new Makr_Content_Category_Screen();
    }
    public Makr_Content_Category_Screen OpenAveryItem(String AveryCategory, int AveryItem){
        Avery.tap();
        if(AveryCategory == Avery_Cards.GetElementName()){
            Avery_Cards.tap();
            AveryCards.get(AveryItem).tap();
        }
        if(AveryCategory == Avery_labels.GetElementName()){
            Avery_labels.tap();
            AveryLabels.get(AveryItem).tap();
        }
        return new Makr_Content_Category_Screen();
    }
    public Makr_Content_Category_Screen OpenCategory(String cat, int item){
        //I hate the way the function works but i can't think of a faster way to do it
        Category.tap();

        if(cat == Category_Baby.GetElementName()){
            InitBaby();
            Category_Baby.tap();
            BabyItems.get(item).tap();
        }
        if(cat == Category_Business.GetElementName()){
            InitBusinessItems();
            Category_Business.tap();
            BusinessItems.get(item).tap();
        }
        if(cat == Category_Gifting.GetElementName()){
            InitGifting();
            Category_Gifting.tap();
            GiftingItems.get(item).tap();
        }
        if(cat == Category_Holiday.GetElementName()){
            InitHoliday();
            Category_Holiday.tap();
            HolidayItems.get(item).tap();
        }
        if(cat == Category_Kitchen.GetElementName()){
            InitKitchen();
            Category_Kitchen.tap();
            KitchenItems.get(item).tap();
        }
        if(cat == Category_Moving.GetElementName()){
            InitMoving();
            Category_Moving.tap();
            Movingitems.get(item).tap();
        }
        if(cat == Category_Organization.GetElementName()){
            InitOrganization();
            Category_Organization.tap();
            OrganizationItems.get(item).tap();
        }
        if(cat == Category_Packaging.GetElementName()){
            InitPackaging();
            Category_Packaging.tap();
            PackagingItems.get(item).tap();
        }
        if(cat == Category_Party.GetElementName()){
            InitParty();
            Category_Party.tap();
            PartyItems.get(item).tap();
        }
        if(cat == Category_Promotion.GetElementName()){
            InitPromotion();
            Category_Promotion.tap();
            PromotionItems.get(item).tap();
        }
        if(cat == Category_Stationary.GetElementName()){
            InitStationary();
            Category_Stationary.tap();
            StationaryItems.get(item).tap();
        }
        if(cat == Category_TableTop.GetElementName()){
            InitTableTop();
            Category_TableTop.tap();
            TableTopItems.get(item).tap();
        }
        if(cat == Category_ThankYou.GetElementName()){
            InitThankYou();
            Category_ThankYou.tap();
            ThankyouItems.get(item).tap();
        }
        if(cat == Category_Wedding.GetElementName()){
            InitWedding();
            Category_Wedding.tap();
            WeddingItems.get(item).tap();
        }

        return new Makr_Content_Category_Screen();
    }




}
