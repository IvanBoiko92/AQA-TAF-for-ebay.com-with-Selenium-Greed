package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    @FindBy(xpath="//input[@id='gh-ac']")
    public
    WebElement searchInput;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void searchKeyword(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);

    }
    public void pressSearch(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
        button.click();
    }

    public void PopularBrands(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"destinations_list2\"]/div/div/div[1]/h2/a"));
        button.click();

    }



}
