package selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ProductPage extends  HelperBase {
    public ProductPage(WebDriver wd, WebDriverWait wait) {
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
        }
    }

}
