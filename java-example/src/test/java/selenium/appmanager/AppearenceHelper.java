package selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppearenceHelper extends HelperBase {
    public AppearenceHelper(WebDriver wd) {
        super(wd);
    }

    public void goToTemplatePage() {
        if( !isElementPresent(By.cssSelector("li#doc-template.selected"))){
            return;
        }
        click(By.linkText("add new"));
    }



}
