package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class NavigationHelper extends  HelperBase{

    public NavigationHelper(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public void customerMainPage() {
        if(isElementPresent(By.linkText("New customers click here"))){
            return;
        }
        click(By.linkText("My Store"));
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

    public void goToCountriesPage()
    {
        if(isElementPresent(By.cssSelector("h1['Countries']"))){
            return;
        }
        click(By.linkText("Countries"));
    }


    public void catalogPage() {
        {
            if(isElementPresent(By.cssSelector("h1['Catalog']"))){
                return;
            }
            click(By.linkText("Catalog"));
        }
    }


    public void goToCart(){
        click(By.cssSelector("#cart a.image"));
        wait.until(titleIs("Checkout | My Store"));
        System.out.println("page: " + wd.findElement(By.name("different_shipping_address")).getText());
    }
}
