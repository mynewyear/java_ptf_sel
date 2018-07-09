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

//    Yellow Duck
//        $20 rgba(119, 119, 119, 1) line-through (24, 16)
//        $18 rgba(204, 0, 0, 1) 700 (30, 20)
//        Yellow Duck
//        $20 rgba(102, 102, 102, 1) line-through (27, 17)
//        $18 rgba(204, 0, 0, 1) 700 (37, 25)



// IE
//Yellow Duck
//    $20 rgba(119, 119, 119, 1)  (24, 17)
//        $18 rgba(204, 0, 0, 1) 900 (36, 25)
//        Yellow Duck
//        $20 rgba(102, 102, 102, 1)  (27, 18)
//        $18 rgba(204, 0, 0, 1) 700 (27, 18)