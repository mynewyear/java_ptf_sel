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

//Appearence
    public void appearencePage() {
        if(isElementPresent(By.cssSelector("h1['Template']"))){
            return;
        }
        click(By.linkText("Appearence"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Template')]")));
    }

    public void goToTemplatePage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Template')]"))) {
            return;
        }
        click(By.linkText("Template"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Template')]")));
    }
    public void goToLogotypePage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Logotype')]"))) {
            return;
        }
        click(By.linkText("Logotype"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Logotype')]")));
    }

//Catalog
    public void catalogPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Catalog')]"))){
            return;
        }
        click(By.linkText("Catalog"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Catalog')]")));
    }
    public void goToCatalogPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Catalog')]"))) {
            return;
        }
        click(By.linkText("Catalog"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Catalog')]")));
    }
    public void goToProductGroupsPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Product Groups')]"))) {
            return;
        }
        click(By.linkText("Product Groups"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Product Groups')]")));
    }
    public void goToOptionGroupsPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Option Groups')]"))) {
            return;
        }
        click(By.linkText("Option Groups"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Option Groups')]")));
    }
    public void goToManufacturersPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Manufacturers')]"))) {
            return;
        }
        click(By.linkText("Manufacturers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Manufacturers')]")));
    }
    public void goToSuppliersPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Suppliers')]"))) {
            return;
        }
        click(By.linkText("Suppliers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Suppliers')]")));
    }
    public void goToDeliveryStatusesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Delivery Statuses')]"))) {
            return;
        }
        click(By.linkText("Delivery Statuses"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Delivery Statuses')]")));
    }
    public void goToSoldOutStatusesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Sold Out Statuses')]"))) {
            return;
        }
        click(By.linkText("Sold Out Statuses"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Sold Out Statuses')]")));
    }
    public void goToQuantityUnitsPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Quantity Units')]"))) {
            return;
        }
        click(By.linkText("Quantity Units"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Quantity Units')]")));
    }
    public void goToCSVPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]"))) {
            return;
        }
        click(By.linkText("CSV Import/Export"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]")));
    }

//Countries
    public void countriesPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Countries']"))){
            return;
        }
        click(By.linkText("Countries"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Countries')]")));
    }

//Currencies
    public void currenciesPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Currencies']"))){
            return;
        }
        click(By.linkText("Currencies"));
    }

//Customer
    public void customersPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Customers']"))){
            return;
        }
        click(By.linkText("Customers"));
    }
    public void goToCustomersPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Customers')]"))) {
            return;
        }
        click(By.linkText("Customers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Customers')]")));
    }
    public void goToCSVCustomerPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]"))) {
            return;
        }
        click(By.linkText("CSV Import/Export"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]")));
    }
    public void goToNewsletterPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Newsletter')]"))) {
            return;
        }
        click(By.linkText("Newsletter"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Newsletter')]")));
    }

//Geo Zone
    public void geoZonePage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Geo Zones']"))){
            return;
        }
        click(By.linkText("Geo Zones"));
    }

//Languages
    public void languagesPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Languages']"))){
            return;
        }
        click(By.linkText("Languages"));
    }
    public void goToLanguagesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Languages')]"))) {
            return;
        }
        click(By.linkText("Languages"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Languages')]")));
    }
    public void goToStorageEncodingPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Storage Encoding')]"))) {
            return;
        }
        click(By.linkText("Storage Encoding"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Storage Encoding')]")));
    }

//Modules
    public void modulesPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Modules']"))){
            return;
        }
        click(By.linkText("Modules"));
    }
    public void goToBackgroundJobsPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), ' Job Modules')]"))) {
            return;
        }
        click(By.linkText("Background Jobs"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), ' Job Modules')]")));
    }
    public void goToCustomerModulesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Customer')]"))) {
            return;
        }
        click(By.linkText("Customer"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Customer')]")));
    }
    public void goToShippingPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Shipping')]"))) {
            return;
        }
        click(By.linkText("Shipping"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Shipping')]")));
    }
    public void goToPaymentrPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Payment')]"))) {
            return;
        }
        click(By.linkText("Payment"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Payment')]")));
    }
    public void goToOrderTotalPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Order Total')]"))) {
            return;
        }
        click(By.linkText("Order Total"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Order Total')]")));
    }
    public void goToOrderSuccessPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Order Success')]"))) {
            return;
        }
        click(By.linkText("Order Success"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Order Success')]")));
    }
    public void goToOrderActionPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Order Action')]"))) {
            return;
        }
        click(By.linkText("Order Action"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Order Action')]")));
    }

//Orders
    public void ordersPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Orders']"))){
            return;
        }
        click(By.linkText("Orders"));
    }
    public void goToOrderOrdersPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Order')]"))) {
            return;
        }
        click(By.cssSelector("li#doc-orders span.name"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Order')]")));
    }
    public void goToOrderStatusesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Order Statuses')]"))) {
            return;
        }
        click(By.linkText("Order Statuses"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Order Statuses')]")));
    }

//Pages
    public void pagesPage() {
        if(isElementPresent(By.name("pages_form"))){
            return;
        }
        click(By.linkText("Pages"));
        Assert.assertTrue(isElementPresent(By.name("pages_form")));
    }

//Reports
    public void reportsPage() {
        if(isElementPresent(By.xpath("//*[@id=\'content\']/h1[contains(text(), 'Monthly Sales')]"))){
            return;
        }
        click(By.linkText("Reports"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id=\'content\']/h1[contains(text(), 'Monthly Sales')]")));
    }
    public void goToMonthlySalesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Monthly Sales')]"))) {
            return;
        }
        click(By.linkText("Monthly Sales"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Monthly Sales')]")));
    }
    public void goToMostSoldProductsPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Most Sold Products')]"))) {
            return;
        }
        click(By.linkText("Most Sold Products"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Most Sold Products')]")));
    }
    public void goToMostShoppingCustomersPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Most Shopping Customers')]"))) {
            return;
        }
        click(By.linkText("Most Shopping Customers"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Most Shopping Customers')]")));
    }

//Setting
    public void settingsPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Settings']"))){
            return;
        }
        click(By.linkText("Settings"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[2]/td[1]")));
    }
    public void goToStoreInfoPage() {
        if(isElementPresent(By.xpath("//*[.='Store Name']']"))){
            return;
        }
        click(By.linkText("Store Info"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Store Name']")));
    }
    public void goToDefaultsPage() {
        if(isElementPresent(By.xpath("//*[.='Default Language']"))){
        return;
    }
    click(By.linkText("Defaults"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Default Language']")));
}

    public void goToGeneralPage() {
        if(isElementPresent(By.xpath("//*[.='There are no entries in the database.']"))){
            return;
        }
        click(By.linkText("General"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='There are no entries in the database.']")));
    }
    public void goToListingsPage() {
        if(isElementPresent(By.xpath("//*[.='Catalog Only Mode']"))){
            return;
        }
        click(By.linkText("Listings"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Catalog Only Mode']")));
    }
    public void goToImagesPage() {
        if(isElementPresent(By.xpath("//*[.='Category Images: Aspect Ratio']"))){
            return;
        }
        click(By.linkText("Images"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Category Images: Aspect Ratio']")));
    }
    public void goToCheckoutPage() {
        if(isElementPresent(By.xpath("//*[.='Register Guests']"))){
            return;
        }
        click(By.linkText("Checkout"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Register Guests']")));
    }
    public void goToAdvancedPage() {
        if(isElementPresent(By.xpath("//*[.='System Cache Enabled']"))){
            return;
        }
        click(By.linkText("Advanced"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='System Cache Enabled']")));
    }
    public void goToSecurityPage() {
        if(isElementPresent(By.xpath("//*[.='Blacklist']"))){
            return;
        }
        click(By.linkText("Security"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Blacklist']")));
    }

//Slides
    public void slidesPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Slides']"))){
            return;
        }
        click(By.linkText("Slides"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Slides')]")));
    }

//Tax
    public void taxPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), ' Tax Classes']"))){
            return;
        }
        click(By.linkText("Tax"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), ' Tax Classes')]")));
    }
    public void goToTaxClassesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), ' Tax Classes')]"))) {
            return;
        }
        click(By.linkText("Tax Classes"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), ' Tax Classes')]")));
    }
    public void goToTaxRatesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), ' Tax Rates')]"))) {
            return;
        }
        click(By.linkText("Tax Rates"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), ' Tax Rates')]")));
    }

//Translations
    public void translationsPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Translations']"))){
            return;
        }
        click(By.linkText("Translations"));
    }
    public void goToSearchTranslationsPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Search Translations')]"))) {
            return;
        }
        click(By.linkText("Search Translations"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Search Translations')]")));
    }
    public void goToScanFilesPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'Scan Files For Translations')]"))) {
            return;
        }
        click(By.linkText("Scan Files"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Scan Files For Translations')]")));
    }
    public void goToCSVImportExportTranslPage() {
        if (isElementPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]"))) {
            return;
        }
        click(By.linkText("CSV Import/Export"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]")));
    }

    public void usersPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), ' Users')]"))){
            return;
        }
        click(By.linkText("Users"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), ' Users')]")));

    }

    public void vQmodsPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'vQmods']"))){
            return;
        }
        click(By.linkText("vQmods"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'vQmods')]")));
    }

    public void goToVQmodsPage() {
        if(isElementPresent(By.xpath("//h1[contains(text(), 'vQmods']"))){
            return;
        }
        click(By.xpath("//*[@id=\'doc-vqmods\']/a/span"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'vQmods')]")));
    }
}
