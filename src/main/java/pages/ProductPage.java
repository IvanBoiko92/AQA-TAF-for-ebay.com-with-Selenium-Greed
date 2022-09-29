package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnProduct(String name){
    WebElement webElement = driver.findElement(By.xpath(name));
        webElement.click();
    }

    public void ClickBuyItNow(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"binBtn_btn\"]"));
        button.click();
    }

}
