package selenium.tests;

import org.junit.Test;

public class SidebarElements extends TestBase {

    @Test
    public void checkSidebarElements() {
        app.getNavigationHelper().homePage();

 // Appearence
        app.getNavigationHelper().appearencePage();
        app.getNavigationHelper().goToTemplatePage();
        app.getNavigationHelper().goToLogotypePage();

//Catalog
        app.getNavigationHelper().catalogPage();
        app.getNavigationHelper().goToCatalogPage();
        app.getNavigationHelper().goToProductGroupsPage();
        app.getNavigationHelper().goToOptionGroupsPage();
        app.getNavigationHelper().goToManufacturersPage();
        app.getNavigationHelper().goToSuppliersPage();
        app.getNavigationHelper().goToDeliveryStatusesPage();
        app.getNavigationHelper().goToSoldOutStatusesPage();
        app.getNavigationHelper().goToQuantityUnitsPage();
        app.getNavigationHelper().goToCSVPage();


        app.getNavigationHelper().countriesPage();

        app.getNavigationHelper().currenciesPage();

//Customers
        app.getNavigationHelper().customersPage();
        app.getNavigationHelper().goToCustomersPage();
        app.getNavigationHelper().goToCSVCustomerPage();
        app.getNavigationHelper().goToNewsletterPage();

        app.getNavigationHelper().geoZonePage();
//Languages
        app.getNavigationHelper().languagesPage();
        app.getNavigationHelper().goToLanguagesPage();
        app.getNavigationHelper().goToStorageEncodingPage();
//Modules
        app.getNavigationHelper().modulesPage();
        app.getNavigationHelper().goToBackgroundJobsPage();
        app.getNavigationHelper().goToCustomerModulesPage();
        app.getNavigationHelper().goToShippingPage();
        app.getNavigationHelper().goToPaymentrPage();
        app.getNavigationHelper().goToOrderTotalPage();
        app.getNavigationHelper().goToOrderSuccessPage();
        app.getNavigationHelper().goToOrderActionPage();

//Orders
        app.getNavigationHelper().ordersPage();
        app.getNavigationHelper().goToOrderOrdersPage();
        app.getNavigationHelper().goToOrderStatusesPage();

        app.getNavigationHelper().pagesPage();

        app.getNavigationHelper().reportsPage();
        app.getNavigationHelper().goToMonthlySalesPage();
        app.getNavigationHelper().goToMostSoldProductsPage();
        app.getNavigationHelper().goToMostShoppingCustomersPage();

//Setting
        app.getNavigationHelper().settingsPage();
        app.getNavigationHelper().goToStoreInfoPage();
        app.getNavigationHelper().goToStoreInfoPage();
        app.getNavigationHelper().goToDefaultsPage();
        app.getNavigationHelper().goToGeneralPage();
        app.getNavigationHelper().goToListingsPage();
        app.getNavigationHelper().goToImagesPage();
        app.getNavigationHelper().goToCheckoutPage();
        app.getNavigationHelper().goToAdvancedPage();
        app.getNavigationHelper().goToSecurityPage();

        app.getNavigationHelper().slidesPage();
//Tax
        app.getNavigationHelper().taxPage();
        app.getNavigationHelper().goToTaxClassesPage();
        app.getNavigationHelper().goToTaxRatesPage();

//Translations
        app.getNavigationHelper().translationsPage();
        app.getNavigationHelper().goToSearchTranslationsPage();
        app.getNavigationHelper().goToScanFilesPage();
        app.getNavigationHelper().goToCSVImportExportTranslPage();

        app.getNavigationHelper().usersPage();

        app.getNavigationHelper().vQmodsPage();
        app.getNavigationHelper().goToVQmodsPage();

    }

}
