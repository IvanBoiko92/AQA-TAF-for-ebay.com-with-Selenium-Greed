package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class Cart {
    WebDriver driver;

    public Cart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverIntoCart(){
        Actions action = new Actions(driver);
        WebElement webElement = driver.findElement(By.id("gh-minicart-hover"));
        action.moveToElement(webElement).build().perform();
    }
}
