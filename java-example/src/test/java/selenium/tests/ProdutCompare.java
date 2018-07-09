package selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import selenium.Models.DuckData;

public class ProdutCompare extends TestBaseCustomer{

    @Test
    public void productCompare(){
        app.goTo().customerMainPage();
        DuckData duckFromMainPage = app.getCustomerMainPage().getDuckFromMainPage();
        app.goTo().customerMainPage();
        DuckData duckFromDuckPage = app.getCustomerMainPage().getDuckFromDucksPage();

        Assert.assertEquals(duckFromDuckPage.name, duckFromMainPage.name);
        Assert.assertEquals(duckFromDuckPage.oldPrice, duckFromMainPage.oldPrice);
        Assert.assertEquals(duckFromDuckPage.newPrice, duckFromMainPage.newPrice);
        Assert.assertEquals(duckFromDuckPage.colorOldPrice, duckFromMainPage.colorOldPrice);
        Assert.assertEquals(duckFromDuckPage.colorNewPrice, duckFromMainPage.colorNewPrice);

        Assert.assertTrue((duckFromDuckPage.sizeNewPrice).compareTo(duckFromDuckPage.sizeOldPrice) > 0);
        Assert.assertTrue((duckFromMainPage.sizeNewPrice).compareTo(duckFromMainPage.sizeOldPrice) > 0);

    }
}
