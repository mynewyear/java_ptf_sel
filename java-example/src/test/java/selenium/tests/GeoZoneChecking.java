package selenium.tests;

import org.junit.Test;

public class GeoZoneChecking extends TestBase {

    @Test
    public void geoZoneAlphabeticalOrder(){
        app.goTo().goToGeozonePage();
        app.getGeoZonePage().listZoneOnThePage();
    }
}
