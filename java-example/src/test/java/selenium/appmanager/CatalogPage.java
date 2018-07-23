package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage extends HelperBase {
    public CatalogPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public LogEntries log;

    public void catalogLogsTests() {

        click(By.linkText("Rubber Ducks"));
        //go to Subcategory
        click(By.linkText("Subcategory"));
        List<WebElement> itemsList = wd.findElements(By.cssSelector("#content > form > table > tbody  td:nth-child(3) > a"));

        System.out.println("Count: " + itemsList.size());
        for (int i = 0; i < itemsList.size(); i++) {

            wd.findElements(By.cssSelector("#content > form > table > tbody  td:nth-child(3) > a")).get(i).click();
            System.out.println("Items: " + (i + 1));
            wait.until(driver1 -> driver1.findElement(By.linkText("General")).isDisplayed());
            log = wd.manage().logs().get("browser");

            Assert.assertTrue("Logs:\n" + printLog(log), log.getAll().isEmpty());

            goBack();
        }
    }

    private String printLog(LogEntries log) {
        String logStr = "";
        for (LogEntry entry : log) {
            logStr += entry.toString() + "\n";
        }
        return logStr;
    }
}

