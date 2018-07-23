package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CountriesPage extends  HelperBase{
    public CountriesPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public void goToCountriesPage() {
        click(By.linkText("Countries"));
    }

    public void checkOpenWindows(){
        String mainWindow;
        Set<String> oldWindows;
        String newWindow;

        click(By.linkText("Afghanistan"));
        Assert.assertTrue(isElementPresent(By.cssSelector("input[value='Afghanistan']")));

        List<WebElement> externalLinks = wd.findElements(By.cssSelector("i.fa.fa-external-link"));

        for (int i = 0; i < externalLinks.size(); i++) {
            mainWindow = wd.getWindowHandle();
//            System.out.println("ID: " + mainWindow);
            oldWindows = wd.getWindowHandles();

            externalLinks.get(i).click();

            newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
            wd.switchTo().window(newWindow);
            System.out.println("Opened " + (i + 1) + "th window: " + wd.getTitle());
            wd.close();
            wd.switchTo().window(mainWindow);

        }

    }

    private ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows) {
        return input -> {
            Set<String> handles = input.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
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
