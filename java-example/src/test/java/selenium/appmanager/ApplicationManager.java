package selenium.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private CustomerMainPage customerMainPage;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;

    private String browser;
    private String adminUrl = "http://localhost/litecart/admin/";
    private String customerUrl = "http://localhost/litecart/en/";

    private String url;

    public ApplicationManager(String browser, boolean admin) {

        this.browser = browser;
        if(admin){
            this.url = adminUrl;
        }
        else this.url = customerUrl;
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

        wd.get(url);
        customerMainPage = new CustomerMainPage(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
//        sessionHelper.login("admin", "admin");
    }

    public void stop() {
        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
    public NavigationHelper goTo() { return navigationHelper; }

    public CustomerMainPage getCustomerMainPage() {
        return customerMainPage;
    }


}
