package selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import selenium.appmanager.ApplicationManager;

public class TestBaseCustomer {
    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME, false);

    @Before
    public void setUp() throws Exception {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }

}
