package selenium.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    WebDriverWait wait;

    private AdminMainPage adminMainPage;
    private CountriesPage countriesPage;
    private CustomerMainPage customerMainPage;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private GeoZonePage geoZonePage;
    private AccountCreationHelper accountCreationHelper;

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

        wait = new WebDriverWait(wd, 1);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        wd.get(url);
        accountCreationHelper = new AccountCreationHelper(wd, wait);
        geoZonePage = new GeoZonePage(wd, wait);
        adminMainPage = new AdminMainPage(wd, wait);
        customerMainPage = new CustomerMainPage(wd, wait);
        navigationHelper = new NavigationHelper(wd, wait);
        sessionHelper = new SessionHelper(wd, wait);
        countriesPage = new CountriesPage(wd, wait);
  //      sessionHelper.login("admin", "admin");
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
    public CountriesPage getCountriesPage(){ return countriesPage; }
    public AdminMainPage getAdminMainPage(){ return adminMainPage;}
    public GeoZonePage getGeoZonePage(){ return geoZonePage; }
    public AccountCreationHelper getAccountCreationHelper(){ return accountCreationHelper;}
}
