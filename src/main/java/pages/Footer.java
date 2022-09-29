package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Footer {

    WebDriver driver;

    public Footer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CompanyInfo() throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath("/html[@class='font-marketsans']/body[@class='desktop gh-flex']/div[@id='hlGlobalFooter']/footer[@id='glbfooter']/div[@id='gf-BIG']/table[@class='gf-t']/tbody/tr/td[4]/ul/li[@class='gf-li'][1]/a[@class='thrd']"));
        webElement.click();
        Thread.sleep(6000);
    }

    public void FacebookLink() {
        WebElement webElement = driver.findElement(By.xpath("/html[@class='font-marketsans']/body[@class='desktop gh-flex']/div[@id='hlGlobalFooter']/footer[@id='glbfooter']/div[@id='gf-BIG']/table[@class='gf-t']/tbody/tr/td[3]/ul/li[@class='gf-li'][2]/a[@class='thrd gf-i']"));
        webElement.click();
    }
}
