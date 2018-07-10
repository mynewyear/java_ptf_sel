package selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import selenium.models.AccountCreationData;

public class AccountCreationHelper extends HelperBase {
    public AccountCreationHelper(WebDriver wd) {
        super(wd);
    }

    public AccountCreationData createAccount(String firstName,
                                             String lastName,
                                             String address1,
                                             String postcode,
                                             String city,
                                             String country,
                                             String email,
                                             String phone,
                                             String password) {
        wd.findElement(By.name("firstname"));
        System.out.println(wd.findElement(By.name("firstname")).getText());
        type(By.name("firstname"), firstName);
        type(By.name("lastname"), lastName);
        type(By.name("address1"), address1);
        type(By.cssSelector("[name = postcode]"), postcode);
        type(By.cssSelector("[name = city]"), city);
        //Select selectCountry = new Select(driver.findElement(By.cssSelector(".select2-selection.select2-selection--single")));
        //selectCountry.selectByVisibleText(country);
        type(By.cssSelector("[name = email]"), email);
        type(By.cssSelector("[name = phone]"), phone);
        type(By.cssSelector("[name = password]"), password);
        type(By.cssSelector("[name = confirmed_password]"), password);

        AccountCreationData accountCreationData = new AccountCreationData(
                firstName,
                lastName,
                address1,
                postcode,
                city,
                country,
                email,
                phone,
                password);

        clickSubmitButton();
        return accountCreationData;
    }


    public void clickSubmitButton() {
        click(By.cssSelector("button[type = submit]"));
        Assert.assertTrue(isElementPresent(By.cssSelector("div#box-account.box h3.title")));
    }
    //div#box-account.box h3.title    -  //*[@id='box-account']/h3[contains(text(), 'Create Account')]
    ////*[@id="box-account"]/h3

    public void logout() {
        click(By.linkText("Logout"));
        Assert.assertTrue(isElementPresent(By.linkText("New customers click here")));
    }

    public void clickCreateNewAccount() {
        if (isElementPresent(By.cssSelector("#create-account.title"))) {
            return;
        } else click(By.linkText("New customers click here"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(), 'Create Account')]")));
    }

    public void loginToLiteCart(String email, String password) {

        type(By.name("email"), email);
        type(By.name("password"), password);
        click(By.name("login"));
        Assert.assertTrue(isElementPresent(By.cssSelector("div#box-account.box h3.title")));
    }

    public String isCountryPresent(String country) {
        WebElement countryElement = wd.findElement(By.xpath("//*[@id='select2-country_code-9p-container']"));
        if (countryElement.getText() == "Russian Federation") {
            return country;
        }
        return "not";
    }

}
