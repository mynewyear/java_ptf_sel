package selenium.tests;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class AddNewProductTest extends TestBase {

    @Test
    public void testProductCreation() {
        File photo = new File("src/test/resources/duck.png");
        app.goTo().homePage();
        app.getAdminMainPage().goToCatalogPage();
        int beforeCount = app.getAdminMainPage().allProductsCount();

        app.getAdminMainPage().addNewProductButtonClick();
        app.getAdminMainPage().createProduct(
                "Blue Blue Duck",
                "357",
                "57",
                "Temporary sold out",
                "11072018",
                "12312018",
                "ACME Corp.",
                "toy",
                "best duck",
                "21",
                "US Dollars",
                "23",
                "18",
                photo);
        int afterCount = app.getAdminMainPage().allProductsCount();

        Assert.assertTrue(beforeCount + 1 == afterCount);
    }
}
