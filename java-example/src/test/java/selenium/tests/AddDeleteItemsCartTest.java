package selenium.tests;

import org.junit.Test;

public class AddDeleteItemsCartTest extends TestBaseCustomer{

    @Test
    public void addDeleteItemsTest(){
        app.goTo().customerMainPage();
        app.getCustomerMainPage().addProduct(3);
        app.getCustomerMainPage().deleteAllItemsFromCart();

    }

}
