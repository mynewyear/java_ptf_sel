package selenium.tests;

import org.junit.Test;

public class CountryCheking extends TestBase{
    @Test
    public void countryChecking(){

        app.getCountriesPage().goToCountriesPage();
        app.getCountriesPage().countriesAlphabeticalOrder();

    }
}
