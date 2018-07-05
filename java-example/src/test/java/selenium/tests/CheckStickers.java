package selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CheckStickers extends TestBaseCustomer{
@Test
     public void checkStikers(){
    app.getCustomerMainPage().stickersPresent();
    }
}
