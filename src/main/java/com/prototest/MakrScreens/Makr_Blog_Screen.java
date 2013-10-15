package com.prototest.MakrScreens;

import com.prototest.appiumcore.appElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: prototest
 * Date: 9/13/13
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Makr_Blog_Screen extends Makr_MenuBar_HeaderScreen {

    appElement Blog = new appElement("Blog", By.name("BLOG"));
    appElement BlgSidebar = new appElement("blgOpenSidebar", By.name("blgMenuOpenSidebar"));

    //Blog Sode bar
    appElement AllPosts = new appElement("AllPosts", By.name("All Posts"));
    appElement Business = new appElement("Buisness", By.name("Buisness"));
    appElement Celebrations = new appElement("Celebrations", By.name("Celebrations"));
    appElement Design = new appElement("Design", By.name("Design"));
    appElement Holiday = new appElement("Holiday", By.name("Holiday"));
    appElement MakrNews = new appElement("MakrNews", By.name("Makr News"));
    appElement Uncategorized = new appElement("Uncategorized", By.name("Uncategorized"));
    appElement Wedding = new appElement("Wedding", By.name("Wedding"));

    //These are the expected Blogs on page

    String BlogSelect = "//window[1]/UIACollectionView[1]/UIACollectionCell";
    appElement SecondBlog = new appElement("SecondBlog", By.xpath("//window[1]/UIACollectionView[1]/UIACollectionCell[2]/text[1]"));

    List<appElement> ScreenElements;
    List<appElement> SidebarElements;

   public Makr_Blog_Screen(){
       InitList();
       VerifyContent(ScreenElements);

   }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Blog);
        ScreenElements.add(BlgSidebar);
        SidebarElements = new ArrayList<appElement>();
        SidebarElements.add(AllPosts);
        SidebarElements.add(Business);
        SidebarElements.add(Celebrations);
        SidebarElements.add(Design);
        SidebarElements.add(Holiday);
        SidebarElements.add(MakrNews);
        SidebarElements.add(Uncategorized);
        SidebarElements.add(Wedding);

    }

    public Makr_Blog_SelectedBlog_Screen SelectBlog(int blogID){
        String stuff = "[" + String.valueOf(blogID) + "]/text[1]";
        String elementXpath = BlogSelect + stuff;
        appElement SelectBlog = new appElement("SelectedBlog", By.xpath(elementXpath));
        SelectBlog.tap(); /* */
        //SecondBlog.tap();
        return new Makr_Blog_SelectedBlog_Screen();

    }
    public Makr_Blog_Screen Openblogsidebar() {
        BlgSidebar.tap();
        AllPosts.verifyPresent();
        Business.verifyPresent();
        Celebrations.verifyPresent();
        Design.verifyPresent();
        Holiday.verifyPresent();
        MakrNews.verifyPresent();
        Uncategorized.verifyPresent();
        Wedding.verifyPresent();
        return this;
    }

    public void AllPosts() {
        AllPosts.tap();
    }

    public void Business() {
        Business.tap();
    }

    public void Celebrations() {
        Celebrations.tap();
    }

    public void Design() {
        Design.tap();
    }

    public void Holiday() {
        Holiday.tap();
    }
    public void MakrNews() {
        MakrNews.tap();
    }

    public void Wedding() {
        Wedding.tap();
    }

}
