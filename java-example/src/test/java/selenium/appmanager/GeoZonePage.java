package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GeoZonePage extends HelperBase {
    public GeoZonePage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public WebElement goToGeozonePage(){
        return wd.findElement(By.linkText("Geo Zones"));
    }

    public void listZoneOnThePage() {
        List<WebElement> geoZoneNames = wd.findElements(By.cssSelector("td:nth-child(3) > a:nth-child(1)"));

        for (int i = 0; i < geoZoneNames.size(); i++) {
            if (i > 0) {
                Assert.assertTrue((geoZoneNames.get(i).getAttribute("innerText")
                        .compareTo(geoZoneNames.get(i - 1).getAttribute("innerText"))) > 0);
            }
            subMenuCheck(geoZoneNames.get(i));
            goToGeozonePage();
            geoZoneNames = wd.findElements(By.cssSelector("td:nth-child(3) > a:nth-child(1)"));
        }
    }

    private void subMenuCheck(WebElement webElement) {
        webElement.click();

        List<WebElement> subGeoZones = wd.findElements(By.cssSelector("tr > td:nth-child(3)"));
        List<String> geozoneNames = new ArrayList<>();
        for (int i = 1; i < subGeoZones.size(); i++) {
            geozoneNames.add(subGeoZones.get(i).findElement(By.xpath(".//option[@selected = 'selected']")).getText());
            if (i > 1) {
                Assert.assertTrue(geozoneNames.get(i-1).compareTo(geozoneNames.get(i - 2)) > 0);
            }
        }
        goBack();
    }

}

