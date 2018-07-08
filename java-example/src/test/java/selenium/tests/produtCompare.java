package selenium.tests;

import org.junit.Test;

public class produtCompare extends TestBaseCustomer{

    @Test
    public void productCompare(){
//        app.getCustomerMainPage().goToCustomerMainPage();
        app.getCustomerMainPage().itemOnMainPage();
        app.getCustomerMainPage().itemOnOwnPage();
    }
}
