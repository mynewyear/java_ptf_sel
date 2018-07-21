package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.models.DuckData;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class CustomerMainPage extends HelperBase {
    public CustomerMainPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public void addProduct(int count) {
        for(int i = 1; i <= count; i++) {
            List<WebElement> products = wd.findElements(By.cssSelector("a.link div.image-wrapper"));
            products.iterator().next().click();
            if (isElementPresent(By.cssSelector("[name = 'options[Size]']"))) {
                Select selectSize = new Select(wd.findElement(By.cssSelector("[name = 'options[Size]']")));
                selectSize.selectByValue("Small");
            }
            click(By.cssSelector("[name = add_cart_product]"));
            wait.until(textToBePresentInElement(wd.findElement(By.cssSelector("a.content span.quantity")), String.valueOf(i)));

            goBack();
        }
    }

    public void deleteAllItemsFromCart() {
        goToCart();
        List<WebElement> items = wd.findElements(By.cssSelector("li.shortcut"));
        for (int a = 0; a < items.size(); a++) {
            List<WebElement> itemsRows = wd.findElements(By.cssSelector("table.dataTable.rounded-corners tr"));
            click(By.name("remove_cart_item"));
            if (a < (items.size() - 1)) {
                wait.until(numberOfElementsToBe(By.cssSelector("table.dataTable.rounded-corners tr"), (itemsRows.size() - 1)));
            } else {
                wait.until(presenceOfElementLocated(By.cssSelector("em")));
            }
        }
    }


    public void goToCart(){
        click(By.cssSelector("#cart a.image"));
    }

    public DuckData getDuckFromMainPage(){
        List<WebElement> item = wd.findElements(By.cssSelector("div#box-campaigns li.product a.link"));
//Name
        String name = item.get(0).findElement(By.cssSelector("div.name")).getText();
//Price old
        WebElement oldPriceWebElement = item.get(0).findElement(By.cssSelector("s.regular-price"));
        String oldPrice = oldPriceWebElement.getText();
        String crossLineOldPrice = oldPriceWebElement.getCssValue("text-decoration-line"); //line-through //if it's true
        String colorOldPrice = oldPriceWebElement.getCssValue("color");
        String sizeOldPrice = oldPriceWebElement.getSize().toString();
//        System.out.println(oldPriceWebElement.getText() + " " + colorOldPrice + " " + crossLineOldPrice + " " + sizeOldPrice);
//New price
        WebElement newPriceWebElement = item.get(0).findElement(By.cssSelector("strong.campaign-price"));
        String newPrice = newPriceWebElement.getText();
        String boldNewPrice = newPriceWebElement.getCssValue("font-weight"); //    font-weight: bold; //if it's true
        String colorNewPrice = newPriceWebElement.getCssValue("color");
        String sizeNewPrice = newPriceWebElement.getSize().toString();
//      System.out.println(newPriceWebElement.getText() + " " + colorNewPrice + " " + boldNewPrice + " " +sizeNewPrice);

        DuckData duckDataFromMainPage = new DuckData(name,
                oldPrice,
                isGrey(colorOldPrice),
                crossLineOldPrice,
                sizeOldPrice,
                newPrice,
                isRed(colorNewPrice),
                boldNewPrice,
                sizeNewPrice);
        return duckDataFromMainPage;
        }

    public DuckData getDuckFromDucksPage(){
        click(By.cssSelector("div#box-campaigns li.product a.link"));
        List<WebElement> itemInPerson = wd.findElements(By.cssSelector("div#box-campaigns li.product a.link"));
        String name = wd.findElement(By.xpath("//h1")).getText();
//Price old
        WebElement oldPriceWebElement = wd.findElement(By.cssSelector("s.regular-price"));
        String oldPrice = oldPriceWebElement.getText();
        String crossLineOldPrice = oldPriceWebElement.getCssValue("text-decoration-line"); //line-through
        String colorOldPrice = oldPriceWebElement.getCssValue("color"); //be gray - all same value
        String sizeOldPrice = oldPriceWebElement.getSize().toString();
 //       System.out.println(oldPriceWebElement.getText() + " " + colorOldPrice + " " + crossLineOldPrice + " " +sizeOldPrice);
//New price
        WebElement newPriceWebElement = wd.findElement(By.cssSelector("strong.campaign-price"));
        String newPrice = newPriceWebElement.getText();
        String boldNewPrice = newPriceWebElement.getCssValue("font-weight"); // font-weight: bold; digits
        String colorNewPrice = newPriceWebElement.getCssValue("color");
//        System.out.println(newPriceWebElement.getText() + " " + colorNewPrice + " " + boldNewPrice + " " +sizeOldPrice);

        String sizeNewPrice = newPriceWebElement.getSize().toString();

        DuckData duckDataFromDuckPage = new DuckData(name,
                 oldPrice,
                 isGrey(colorOldPrice),
                 crossLineOldPrice,
                 sizeOldPrice,
                 newPrice,
                 isRed(colorNewPrice),
                 boldNewPrice,
                 sizeNewPrice);
        return duckDataFromDuckPage;
    }

    public String isGrey(String color){
        int[] colors = colorParser(color);
            if((colors[0] == colors[1]) &&( colors[0] == colors[2])) {
                return "Grey";
            }
            return "color is not gray";
    }

    public String isRed(String color){
        int[] colors = colorParser(color);
        if((colors[0] > 0)&&(colors[1] == 0) &&( colors[2] == 0)){
            return "Red";
        }
        return "color is not red";
    }

    public void goToCustomerMainPage() {
        click(By.linkText("My Store"));
    }

    public int count() {
        return wd.findElements(By.cssSelector("a.link div.image-wrapper")).size();
    }

    public ArrayList allGoods(){
        return  (ArrayList<WebElement>) wd.findElements(By.cssSelector("img.image"));
    }

    public void stickerSale() {
        wd.findElement(By.cssSelector("div.sticker.sale"));
    }

    public void sticker(){
        wd.findElement(By.cssSelector("div.sticker"));
    }

    public void stickerNew() {
        wd.findElement(By.cssSelector("div.sticker.new"));
    }

    public int stickerSaleCount() {
        return wd.findElements(By.cssSelector("div.image-wrapper div.sticker.sale")).size();
    }

    public int stickerNewCount() {
        return wd.findElements(By.cssSelector("div.image-wrapper div.sticker.new")).size();
    }

    public void stickersPresent() {
        List<WebElement> products = wd.findElements(By.cssSelector("a.link div.image-wrapper"));
        for (WebElement product : products) {
            List<WebElement> stickers = product.findElements(By.cssSelector("div.sticker"));
            Assert.assertEquals(stickers.size(), 1);
           System.out.println(product.getText());
        }
    }

}
