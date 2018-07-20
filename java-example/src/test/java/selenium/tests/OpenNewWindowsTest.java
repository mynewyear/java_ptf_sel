package selenium.tests;

import org.junit.Test;

public class OpenNewWindowsTest extends TestBase {

    @Test
    public void openNewWindowsTest(){
        app.goTo().goToCountriesPage();
        app.getCountriesPage().checkOpenWindows();

    }
}
