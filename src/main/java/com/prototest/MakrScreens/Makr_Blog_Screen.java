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

    String BlogSelect = "//window1/UIACollectionView[1]/UIACollectionCell";

    List<appElement> ScreenElements;

   public Makr_Blog_Screen(){
       InitList();
       VerifyContent(ScreenElements);

   }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Blog);
        ScreenElements.add(BlgSidebar);

    }

    public Makr_Blog_SelectedBlog_Screen SelectedBlog(int BlogID){
        String thing = "[" + String.valueOf(BlogID) + "]/text[1]";
        String elementXpath = "//window{1}/UIACollectionView{1}/UIACollectionCell" + thing;
        appElement SelectedBlog = new appElement("SelectedBlog", By.xpath(elementXpath));
        SelectedBlog.tap();
        return new Makr_Blog_SelectedBlog_Screen();
    }

    public void SelectBlog(int blogID){
        String stuff = "[" + String.valueOf(blogID) + "]";
        String elementXpath = BlogSelect + stuff;
        appElement SelectBlog = new appElement("SelectBlog", By.xpath(elementXpath));
        SelectBlog.tap();

    }
    public Makr_Blog_Screen Openblogsidebar() {
        BlgSidebar.tap();
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
