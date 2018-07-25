package selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CartPage extends HelperBase {
    public CartPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }


    public void deleteItemsFromCart() {
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
        click(By.cssSelector("#cart"));
        wait.until(titleIs("Checkout | My Store"));
 //       System.out.println("page: " + wd.findElement(By.cssSelector("h2.title")).getText());
    }

}
