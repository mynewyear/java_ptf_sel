package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CountriesPage extends  HelperBase{
    public CountriesPage(WebDriver wd) {
        super(wd);
    }

    public void goToCountriesPage() {
        click(By.linkText("Countries"));
    }


    public void countriesAlphabeticalOrder() {
        List<WebElement> countiriesList = wd.findElements(By.cssSelector("tr.row > td:nth-child(5) > a"));
        List<WebElement> zoneList = wd.findElements(By.cssSelector("tr.row > td:nth-child(6)"));
//        System.out.println(countiriesList.size());
        for (int i = 0; i < countiriesList.size(); i++) {
            if(i > 0) {
                Assert.assertTrue((countiriesList.get(i).getAttribute("innerText")
                        .compareTo(countiriesList.get(i - 1).getAttribute("innerText"))) > 0);
            }
            if (!zoneList.get(i).getAttribute("innerText").equals("0")) {
                checkCountryZones(countiriesList.get(i));
            }
            countiriesList = wd.findElements(By.cssSelector("tr.row > td:nth-child(5) > a"));
            zoneList = wd.findElements(By.cssSelector("tr.row > td:nth-child(6)"));
        }
    }

    private void checkCountryZones(WebElement zone) {
        zone.click();
        List<WebElement> zoneList = wd.findElements(By.cssSelector("td:nth-child(3)"));
        for (int i = 2; i < zoneList.size()-1; i++) {
            Assert.assertTrue((zoneList.get(i).getAttribute("innerText")
                    .compareTo(zoneList.get(i - 1).getAttribute("innerText"))) > 0);

        }
        goBack();
    }

    public int count() {
        return wd.findElements(By.cssSelector("tr.row")).size();
    }

    public void countriesPresent() {
        List<WebElement> countries = wd.findElements(By.cssSelector("tr.row > td:nth-child(5) > a")); //tbody/tr[2]/td[5]/a
        for (int i = 0; i < countries.size(); i++) {
            String check = countries.get(i).getText();
            System.out.println(check);
        }
    }

}
