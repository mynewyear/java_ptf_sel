package selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends  HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userName, String password) {
        type(By.name("username"),userName);
        type(By.name("password"),password);
        click(By.name("login"));
    }
}
