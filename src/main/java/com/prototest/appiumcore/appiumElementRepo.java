package com.prototest.appiumcore;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/24/13
 * Time: 11:13 AM
 * The idea of this class is to gather all the elements on all the screens before any test runs and build a repository of elements so they won't need to be found later
 * Depending on the number of elements this could take several minutes to build these lists.  However they would not need to be build for later tests, and tests can find elements more
 * reliably between application versions.  Since most xpath locators change with every build, element locations should stay fairly static or at least change less frequently.
 *
 * With this class we won't need to go out an search the DOM everytime a new screen object is created.
 */
public class appiumElementRepo {
    public static class ElementRepo{
        private List<WebElement> m_Webbuttons = appiumTestBase.getDriver().findElements(By.tagName("UIAButton"));
        private List<WebElement> m_Websecure = appiumTestBase.getDriver().findElements(By.tagName("UIASecureTextField"));
        private List<WebElement> m_Webstatictext = appiumTestBase.getDriver().findElements(By.tagName("UIAStaticText"));
        private List<WebElement> m_Webtext = appiumTestBase.getDriver().findElements(By.tagName("UIATextField"));

        private List<appElement> m_buttons = new ArrayList<appElement>();
        private List<appElement> m_secure = new ArrayList<appElement>();
        private List<appElement> m_static = new ArrayList<appElement>();
        private List<appElement> m_text = new ArrayList<appElement>();

        public ElementRepo(){
            //Since this is a static class this constructor should only ever be called once per session
            BuildAppElementList(m_Webbuttons, m_buttons);
            BuildAppElementList(m_Websecure, m_secure);
            BuildAppElementList(m_Webstatictext, m_static);
            BuildAppElementList(m_Webtext, m_text);
        }

        private void BuildAppElementList(List<WebElement> webElements, List<appElement> appElements) {
            for(int i = 0; i < webElements.size(); i++){
                appElements.add(new appElement(webElements.get(i).getTagName() + String.valueOf(i), webElements.get(i), webElements.get(i).getLocation()));
            }
        }

        public appElement getButton(Point location){
            return m_buttons.get(FindItem(location, m_buttons));
        }
        public appElement getSecure(Point location){
            return m_secure.get(FindItem(location, m_secure));
        }
        public appElement getStatic(Point location){
            return m_static.get(FindItem(location, m_static));
        }
        public appElement getText(Point location){
            return m_text.get(FindItem(location, m_text));
        }

        private int FindItem(Point location, List<appElement> appElements){
            int matchingIndex = 0;
            boolean match = false;
            for(int i = 0; i < m_buttons.size(); i++){
                if(m_buttons.get(i).GetLocation().equals(location)){
                    //This is the first pass -- items may not be present in the list at this point
                    //TODO need to check for new elements
                    matchingIndex = i;
                    match = true;
                    i = m_buttons.size();
                }
            }
            if(!match){
                appiumTestBase.logFile.AddLog("Item matching location " + String.valueOf(location) + " was not found!");
            }
            return matchingIndex;
        }
    }

}
