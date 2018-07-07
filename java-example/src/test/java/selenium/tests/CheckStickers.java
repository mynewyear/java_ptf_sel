package selenium.tests;

import org.junit.Test;



public class CheckStickers extends TestBaseCustomer{
@Test
     public void checkStikers(){
    app.getCustomerMainPage().stickersPresent();
    }
}
