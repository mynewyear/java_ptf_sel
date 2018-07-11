package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class AdminMainPage extends HelperBase {

    public AdminMainPage(WebDriver wd) {
        super(wd);
    }

    public void sidebarCheck() {
        List<WebElement> sidebarList = wd.findElements(By.cssSelector("li#app-"));
        for (int i = 0; i < sidebarList.size(); i++) {
            sidebarList.get(i).click();
            Assert.assertTrue(isElementPresent(By.tagName("h1")));
            List<WebElement> subMenu = wd.findElements(By.cssSelector("ul.docs li a"));
            if (subMenu.size()!=0){
                for (int j = 0; j < subMenu.size(); j++) {
 //                   System.out.println(subMenu.get(j).getAttribute("innerText"));
                    subMenu.get(j).click();
                    Assert.assertTrue(isElementPresent(By.tagName("h1")));
                    WebElement newSubMenu= wd.findElement(By.cssSelector("#app-.selected"));
                    subMenu = newSubMenu.findElements(By.cssSelector("ul.docs li a"));
                }
            }
            sidebarList = wd.findElements(By.cssSelector("li#app-"));
        }
    }

    public void goToCatalogPage(){
        if(isElementPresent(By.xpath("//h1[contains(text(), 'Catalog')]"))){
            return;
        }
        click(By.linkText("Catalog"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Catalog')]")));
    }

    public void goToInformation(){
        click(By.linkText("Information"));
    }

    public int allProductsCount(){
        List<WebElement> countAllProducts = wd.findElements(By.cssSelector("tr.row > td:nth-child(3) > a"));
        return  countAllProducts.size();
    }


    public void goToPrices(){
        click(By.linkText("Prices"));
    }

    public  void addNewProductButtonClick(){
        click(By.linkText("Add New Product"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Add New Product')]")));
    }

    public void createProduct(String productName,
                              String productCode,
                              String quantity,
                              String status,
                              String dataFrom,
                              String dataTo,
                              String madeBy,
                              String shortDescription,
                              String text,
                              String purchasePrice,
                              String currencyType,
                              String priceUS,
                              String priceEUR,
                              File photo) {


        WebElement statusField = wd.findElement(By.cssSelector("label"));
        statusField.findElement(By.cssSelector("input[value = '1']")).click();
//name
        type(By.cssSelector("[name = 'name[en]']"), productName);
//productCode
        type(By.cssSelector("[name = code]"), productCode);
//Product Groups, gender
        click(By.cssSelector("input[value = '1-1']"));
        click(By.cssSelector("input[value = '1-2']"));
        click(By.cssSelector("input[value = '1-3']"));
//Quantity
        type(By.cssSelector("input[name = quantity]"), quantity);
//Sold Out Status
        Select sold = new Select(wd.findElement(By.cssSelector("[name = sold_out_status_id]")));
        sold.selectByVisibleText(status);
//Photo
        attachFile(By.cssSelector("input[name = 'new_images[]']"), photo);
//DataFrom
        wd.findElement(By.cssSelector("[name = date_valid_from]")).sendKeys(dataFrom);
//DataTo
        wd.findElement(By.cssSelector("[name = date_valid_to]")).sendKeys(dataTo);

//Information
        goToInformation();
        Select manufacturer = new Select(wd.findElement(By.cssSelector("[name = manufacturer_id]")));
        manufacturer.selectByVisibleText(madeBy);
        type(By.cssSelector("[name = keywords]"), productName);
        type(By.cssSelector("[name = 'short_description[en]']"), shortDescription);
        type(By.cssSelector(".trumbowyg-editor"), text);
        type(By.cssSelector("[name = 'head_title[en]']"), productName);
        type(By.cssSelector("[name = 'meta_description[en]']"), shortDescription);

//Prices
        goToPrices();
 //       click(By.cssSelector("[href = '#tab-prices']"));
        type(By.cssSelector("[name = purchase_price]"), purchasePrice);
        Select currancy = new Select(wd.findElement(By.cssSelector("[name = purchase_price_currency_code]")));
        currancy.selectByVisibleText(currencyType);
        wd.findElement(By.cssSelector("[name = 'prices[USD]']")).sendKeys(priceUS);
        wd.findElement(By.cssSelector("[name = 'prices[EUR]']")).sendKeys(priceEUR);
        click(By.cssSelector("button[name = save]"));

        Assert.assertTrue(isElementPresent(By.linkText(productName)));
    }


}