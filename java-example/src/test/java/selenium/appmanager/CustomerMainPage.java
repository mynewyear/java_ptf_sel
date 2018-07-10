package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.models.DuckData;


import java.util.ArrayList;
import java.util.List;

public class CustomerMainPage extends HelperBase {
    public CustomerMainPage(WebDriver wd) {
        super(wd);
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

    public void stikerSale() {
        wd.findElement(By.cssSelector("div.sticker.sale"));
    }

    public void sticker(){
        wd.findElement(By.cssSelector("div.sticker"));
    }

    public void stikerNew() {
        wd.findElement(By.cssSelector("div.sticker.new"));
    }

    public int stikerSaleCount() {
        return wd.findElements(By.cssSelector("div.image-wrapper div.sticker.sale")).size();
    }

    public int stikerNewCount() {
        return wd.findElements(By.cssSelector("div.image-wrapper div.sticker.new")).size();
    }

    public void stickersPresent() {
        List<WebElement> products = wd.findElements(By.cssSelector("a.link div.image-wrapper"));
        for (WebElement product : products) {
            List<WebElement> stickers = product.findElements(By.cssSelector("div.sticker"));
            Assert.assertEquals(stickers.size(), 1);
            System.out.println(stickers);
        }
    }


}
