package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Header {
    WebDriver driver;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SignIn() {
        WebElement webElement = driver.findElement(By.linkText("Sign in"));
        webElement.click();
    }
    public void logInWithIncorrectEmailOrLogin(String login) throws InterruptedException {
        WebElement webElement = driver.findElement(By.linkText("Email or username"));
        webElement.sendKeys(login);
        webElement = driver.findElement(By.xpath("/html[@class='font-marketsans']/body/div[@class='body-content']/main[@id='mainContent']/div[@class='id-first']/form[@id='signin-form']/div[1]/div/button[@id='signin-continue-btn']"));
        webElement.click();
    }

}
