package selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import selenium.appmanager.ApplicationManager;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @Before
    public void setUp() throws Exception {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }

}

