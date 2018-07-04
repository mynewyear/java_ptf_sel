package selenium.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }else{
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.get("http://localhost/litecart/admin/");
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "admin");
    }

    public void stop() {
        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

}
