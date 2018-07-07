package selenium.tests;

import org.junit.Test;

public class SidebarElements extends TestBase {

    @Test
    public void checkSidebarElements() {
        app.goTo().homePage();
        app.getAdminMainPage().sidebarCheck();
    }

}
