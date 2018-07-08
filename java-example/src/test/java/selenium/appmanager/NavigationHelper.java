package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends  HelperBase{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void customerMainPage() {
        if(isElementPresent(By.linkText("New customers click here"))){
            return;
        }
        click(By.cssSelector("a i.fa.fa-home"));
    }

    public void homePage() {
        if(isElementPresent(By.xpath("//div[1]/a"))){
            return;
        }
        click(By.xpath("//div[1]/a"));
    }

    public void goToGeozonePage() {
        if(isElementPresent(By.tagName("h1"))){
            return;
        }
        click(By.linkText("Geo Zones"));
    }


}
