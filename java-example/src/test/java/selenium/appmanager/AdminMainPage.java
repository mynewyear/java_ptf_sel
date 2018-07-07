package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminMainPage extends HelperBase {

    public AdminMainPage(WebDriver wd) {
        super(wd);
    }

    public void sidebarCheck() {
        List<WebElement> sidebarList = wd.findElements(By.cssSelector("li#app-"));
        for (int i = 0; i < sidebarList.size(); i++) {
            sidebarList.get(i).click();
            Assert.assertTrue(isElementPresent(By.tagName("h1")));
            List<WebElement> subMenu = wd.findElements(By.cssSelector("ul.docs li a"));
            if (subMenu.size()!=0){
                for (int j = 0; j < subMenu.size(); j++) {
 //                   System.out.println(subMenu.get(j).getAttribute("innerText"));
                    subMenu.get(j).click();
                    Assert.assertTrue(isElementPresent(By.tagName("h1")));
                    WebElement newSubMenu= wd.findElement(By.cssSelector("#app-.selected"));
                    subMenu = newSubMenu.findElements(By.cssSelector("ul.docs li a"));
                }
            }
            sidebarList = wd.findElements(By.cssSelector("li#app-"));
        }
    }
}