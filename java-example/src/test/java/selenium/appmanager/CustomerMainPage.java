package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CustomerMainPage extends HelperBase {
    public CustomerMainPage(WebDriver wd) {
        super(wd);
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
