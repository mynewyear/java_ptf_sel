package selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected  boolean elementSelected(By locator){return wd.findElement(locator).isSelected();}

    protected void alertAccept() {
        wd.switchTo().alert().accept();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void goBack(){
        wd.navigate().back();
    }

    public int[] colorParser(String str) {
        int[] result = {0, 0, 0};
        int i = 0;
        int j = 0;
        while (i < 3 && j < str.length()) {
            if (Character.isDigit(str.charAt(j))) {
                result[i] *= 10;
                result[i] += Character.getNumericValue(str.charAt(j));
                j++;
            } else if(str.charAt(j) == ','){
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return result;
    }

    public void attachFile(By locator, File file) {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }
}
