package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    WebDriver driver;

    public Waiter(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }

    public void waitVisibilityOfElement(long time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
