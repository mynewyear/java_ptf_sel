package selenium.tests;

import org.junit.Test;

public class AddDeleteItemsCartTest extends TestBaseCustomer{

    @Test
    public void addDeleteItemsTest(){
        app.goTo().customerMainPage();
        app.getProductPage().addProduct(3);
        app.getCartPage().deleteItemsFromCart();
    }

}
