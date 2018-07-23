package selenium.tests;

import org.junit.Test;

public class BrowserLogsTests extends TestBase {

    @Test
    public void browserMessagesTest(){
        app.goTo().catalogPage();
        app.getCatalogPage().catalogLogsTests();
    }
}
